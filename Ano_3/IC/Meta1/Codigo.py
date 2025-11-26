# Importação de bibliotecas necessária
from keras.src.callbacks import EarlyStopping, ReduceLROnPlateau  # Callbacks para treinamento
from tensorflow.keras import  regularizers
from sklearn.metrics import confusion_matrix, classification_report, roc_auc_score, accuracy_score, \
    ConfusionMatrixDisplay  # Métricas de avaliação
from sklearn.preprocessing import label_binarize  # Para codificação one-hot dos rótulos
from tensorflow.keras.preprocessing.image import ImageDataGenerator  # Para carregamento e aumento de imagens
from tensorflow.keras import layers, models  # Camadas e modelos do Keras
import matplotlib.pyplot as plt  # Para visualização de gráficos

# --- 1. Configuração dos caminhos e parâmetros ---
train_path = r"C:\Users\Daniel\Desktop\3_ano\IC\TP\Dataset\Skin_Diseases\kaggle\train"  # Caminho de treino
test_path = r"C:\Users\Daniel\Desktop\3_ano\IC\TP\Dataset\Skin_Diseases\kaggle\test"  # Caminho de teste
val_path = r"C:\Users\Daniel\Desktop\3_ano\IC\TP\Dataset\Skin_Diseases\kaggle\val"  # Caminho de validação
img_size = 128 # Tamanho das imagens
batch_size = 16  # Tamanho do lote para treinamento

# --- 2. Configuração dos geradores de dados ---
# Configuração do gerador para o conjunto de treinamento com aumento de dados
train_datagen = ImageDataGenerator(
    rescale=1./255,  # Normaliza os pixels para [0, 1]
    rotation_range=20,  # Rotação aleatória de até 20 graus
    width_shift_range=0.15,  # Deslocamento horizontal de até 15%
    height_shift_range=0.15,  # Deslocamento vertical de até 15%
    shear_range=0.15,  # Distorção de cisalhamento
    zoom_range=0.15,  # Zoom aleatório
    horizontal_flip=True,  # Inversão horizontal aleatória
    fill_mode='nearest'  # Preenchimento de pixels fora da imagem
)

# Gerador de dados de treinamento
train_generator = train_datagen.flow_from_directory(
    train_path,
    target_size=(img_size, img_size),  # Redimensiona imagens para 128x128
    batch_size=batch_size,  # Lotes de 16 imagens
    class_mode='categorical',  # Classificação multiclasse (one-hot encoded)
    shuffle=True  # Embaralha os dados para treinamento
)

# Configuração do gerador para validação (sem aumento de dados)
val_datagen = ImageDataGenerator(rescale=1./255)  # Apenas normalização

# Gerador de dados de validação
val_generator = val_datagen.flow_from_directory(
    val_path,
    target_size=(img_size, img_size),
    batch_size=batch_size,
    class_mode='categorical',
    shuffle=False  # Não embaralha para manter consistência na avaliação
)

# Configuração do gerador para teste (sem aumento de dados)
test_datagen = ImageDataGenerator(rescale=1./255)  # Apenas normalização

# Gerador de dados de teste
test_generator = test_datagen.flow_from_directory(
    test_path,
    target_size=(img_size, img_size),
    batch_size= batch_size,
    class_mode='categorical',
    shuffle=False  # Não embaralha para manter correspondência com rótulos
)

# --- 3. Construção do modelo CNN ---
#Modelo Simples
'''model = models.Sequential([
    # Primeira camada convolucional: 32 filtros de 3x3, ativação ReLU
    layers.Conv2D(32, (3, 3), activation='relu', input_shape=(img_size, img_size, 3)),
    layers.MaxPooling2D((2, 2)),  # Reduz dimensão com pooling 2x2
    # Segunda camada convolucional: 64 filtros de 3x3
    layers.Conv2D(64, (3, 3), activation='relu'),
    layers.MaxPooling2D((2, 2)),
    # Terceira camada convolucional: 128 filtros de 3x3
    layers.Conv2D(128, (3, 3), activation='relu'),
    layers.Flatten(),  # Achata a saída para uma camada densa
    layers.Dense(64, activation='relu'),  # Camada densa com 100 neurônios
    layers.Dense(train_generator.num_classes, activation='softmax')  # Saída com número de classes
])'''
#Modelo Melhorado
model = models.Sequential([
    # Bloco 1
    layers.Conv2D(32, (3, 3), activation='relu', padding='same', input_shape=(img_size, img_size, 3)),
    layers.BatchNormalization(),
    layers.Conv2D(32, (3, 3), activation='relu', padding='same'),
    layers.BatchNormalization(),
    layers.MaxPooling2D((2, 2)),
    layers.Dropout(0.2),
    # Bloco 2
    layers.Conv2D(64, (3, 3), activation='relu', padding='same'),
    layers.BatchNormalization(),
    layers.Conv2D(64, (3, 3), activation='relu', padding='same'),
    layers.BatchNormalization(),
    layers.MaxPooling2D((2, 2)),
    layers.Dropout(0.3),
    # Bloco 3
    layers.Conv2D(128, (3, 3), activation='relu', padding='same'),
    layers.BatchNormalization(),
    layers.Conv2D(128, (3, 3), activation='relu', padding='same'),
    layers.BatchNormalization(),
    layers.MaxPooling2D((2, 2)),
    layers.Dropout(0.3),
    # Bloco 4
    layers.Conv2D(256, (3, 3), activation='relu', padding='same'),
    layers.BatchNormalization(),
    layers.MaxPooling2D((2, 2)),
    layers.Dropout(0.4),
    # Camadas Densas
    layers.GlobalAveragePooling2D(), #trocar para Flatten() ou GlobalAveragePooling2D,
    layers.Dense(512, activation='relu'),
    layers.BatchNormalization(),
    layers.Dropout(0.5),
    layers.Dense(256, activation='relu'),
    layers.BatchNormalization(),
    layers.Dropout(0.5),
    layers.Dense(train_generator.num_classes, activation='softmax')
])

# --- 4. Compilação do modelo ---
model.compile(
    optimizer='adam',  # Otimizador Adam com taxa de aprendizado padrão
    loss='categorical_crossentropy',  # Função de perda para classificação multiclasse
    metrics=['accuracy']  # Métrica de acurácia para monitoramento
)


# --- 5. Configuração dos callbacks ---
callbacks = [
    EarlyStopping(patience=5, restore_best_weights=True),  # Para treinamento se não melhorar após 5 épocas
    ReduceLROnPlateau(patience=2, factor=0.3)  # Reduz taxa de aprendizado por 0.3 se não melhorar após 2 épocas
]

# --- 6. Treinamento do modelo ---
history = model.fit(
    train_generator,
    epochs=30,  # Número de épocas (pode ser aumentado para melhor convergência)
    validation_data=val_generator,  # Dados de validação para monitoramento
    callbacks=callbacks  # Aplica os callbacks configurados
)

# --- 7. Avaliação do modelo ---
# Previsão das probabilidades no conjunto de teste
y_pred_probs = model.predict(test_generator)  # Probabilidades para cada classe
y_pred = y_pred_probs.argmax(axis=1)  # Classes preditas (índice da maior probabilidade)
y_true = test_generator.classes  # Rótulos verdadeiros do conjunto de teste

# Obter número de classes e nomes
num_classes = len(test_generator.class_indices)
class_names = list(test_generator.class_indices.keys())

# --- 8. Cálculo e exibição das métricas ---
# Acurácia
accuracy = accuracy_score(y_true, y_pred)
print(f"Acurácia no conjunto de teste: {accuracy:.3f}")

# Matriz de confusão
cm = confusion_matrix(y_true, y_pred)
# Visualização da matriz de confusão
disp = ConfusionMatrixDisplay(confusion_matrix=cm, display_labels=class_names)
disp.plot(cmap='Blues')
plt.title("Matriz de Confusão")
plt.show()

# Sensibilidade, especificidade e F1-score por classe
print("\nMétricas por classe:")
for i in range(num_classes):
    TP = cm[i, i]  # Verdadeiros positivos
    FP = cm[:, i].sum() - TP  # Falsos positivos
    FN = cm[i, :].sum() - TP  # Falsos negativos
    TN = cm.sum() - (TP + FP + FN)  # Verdadeiros negativos

    # Cálculo das métricas
    sensitivity = TP / (TP + FN) if (TP + FN) != 0 else 0  # Sensibilidade (Recall)
    specificity = TN / (TN + FP) if (TN + FP) != 0 else 0  # Especificidade
    f1 = 2 * TP / (2 * TP + FP + FN) if (2 * TP + FP + FN) != 0 else 0  # F1-score

    print(f"{class_names[i]}: Sensibilidade={sensitivity:.3f}, Especificidade={specificity:.3f}, F1={f1:.3f}")

# AUC (macro, One-vs-Rest)
y_true_onehot = label_binarize(y_true, classes=range(num_classes))  # Converte rótulos para one-hot
auc = roc_auc_score(y_true_onehot, y_pred_probs, average='macro', multi_class='ovr')  # Calcula AUC média
print(f"\nAUC (macro, OVR): {auc:.3f}")