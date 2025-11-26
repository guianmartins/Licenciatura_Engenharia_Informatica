### --- 1. IMPORTAÇÃO DE BIBLIOTECAS ---
import numpy as np
import tensorflow as tf
import matplotlib.pyplot as plt
import os
from sklearn.metrics import confusion_matrix, roc_auc_score, accuracy_score, \
    ConfusionMatrixDisplay
from sklearn.preprocessing import label_binarize
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras import layers, models
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.callbacks import EarlyStopping, ReduceLROnPlateau
from Functions.pso import pso

# (Certifique-se que o ficheiro Functions/pso.py tem o código otimizado que lhe enviei antes)

# <-- CORREÇÃO DE CAMINHO (Paths locais do Windows) -->
base_drive_path = r"C:\Users\wolfe\Desktop\ISEC\3_Ano\1_Semestre\IC\TP\DataSet\Skin_Diseases\kaggle"
train_otimization_path = os.path.join(base_drive_path, "temp_train")
train_path = os.path.join(base_drive_path, "train")
test_path = os.path.join(base_drive_path, "test")
val_path = os.path.join(base_drive_path, "val")

# --- 2. CONFIGURAÇÃO DOS GERADORES ---
IMG_SIZE_OPT = 64
IMG_SIZE_FINAL = 128
batch_size = 16

print(f"A carregar gerador de treino de otimização (temp_train, {IMG_SIZE_OPT}x{IMG_SIZE_OPT})...")
trainWSA_datagen = ImageDataGenerator(rescale=1. / 255, fill_mode='nearest')
trainWSA_generator = trainWSA_datagen.flow_from_directory(
    train_otimization_path,
    target_size=(IMG_SIZE_OPT, IMG_SIZE_OPT),
    batch_size=batch_size,
    class_mode='categorical',
    shuffle=True
)

print(f"A carregar gerador de validação de otimização (val, {IMG_SIZE_OPT}x{IMG_SIZE_OPT})...")
val_opt_datagen = ImageDataGenerator(rescale=1. / 255)
val_generator_opt = val_opt_datagen.flow_from_directory(
    val_path,
    target_size=(IMG_SIZE_OPT, IMG_SIZE_OPT),
    batch_size=batch_size,
    class_mode='categorical',
    shuffle=False
)

num_classes = trainWSA_generator.num_classes


### --- 3. FUNÇÃO PARA CRIAR O MODELO ---
def create_model(learning_rate, num_neurons, size):
    model = models.Sequential([
        layers.Conv2D(16, (3, 3), activation='relu', input_shape=(size, size, 3)),
        layers.MaxPooling2D((2, 2)),
        layers.Conv2D(32, (3, 3), activation='relu'),
        layers.MaxPooling2D((2, 2)),
        layers.Conv2D(64, (3, 3), activation='relu'),
        layers.Flatten(),
        layers.Dense(int(num_neurons), activation='relu'),
        layers.Dense(num_classes, activation='softmax')
    ])
    optimizer = Adam(learning_rate=learning_rate)
    model.compile(optimizer=optimizer, loss='categorical_crossentropy', metrics=['accuracy'])
    return model


### --- 4. DEFINIÇÃO DA FUNÇÃO DE FITNESS (Melhorada) ---
# Aumentei o limite para 20, mas o EarlyStopping vai parar muito antes se necessário
EPOCHS_FOR_OPTIMIZATION = 1


def fitness_function(params):
    learning_rate = params[0]
    num_neurons = int(params[1])

    # --- ALTERAÇÃO 1: Adicionado EarlyStopping ---

    print(f"Testando: LR={learning_rate:.6f}, Neurónios={num_neurons}...", end=" ", flush=True)

    model = create_model(learning_rate, num_neurons, IMG_SIZE_OPT)
    history = model.fit(
        trainWSA_generator,
        epochs=EPOCHS_FOR_OPTIMIZATION,
        validation_data=val_generator_opt,
        verbose=0
    )

    val_loss = np.min(history.history['val_loss'])
    epochs_run = len(history.history['val_loss'])  # Para sabermos quantas épocas durou
    print(f"-> Val Loss={val_loss:.5f} ({epochs_run} épocas)", flush=True)

    return val_loss


### --- 5. EXECUÇÃO DA OTIMIZAÇÃO SWARM (APENAS PSO) ---
n_agentes = 1
n_iteracoes = 1
lb = [0.0001, 32]
ub = [0.01, 128]

print("\n" + "=" * 50, flush=True)
print("--- INICIANDO OTIMIZAÇÃO DE HIPERPARÂMETROS (PSO) ---", flush=True)
print(f"Algoritmo usará {n_agentes} agentes e {n_iteracoes} iterações.", flush=True)
print("=" * 50 + "\n", flush=True)

print("\n--- Executando Particle Swarm Optimization (PSO) ---", flush=True)
pso_optimizer = pso(n=n_agentes, function=fitness_function, lb=lb, ub=ub, dimension=2, iteration=n_iteracoes)

print("\nA obter a melhor solução do PSO...", flush=True)
best_params_pso = pso_optimizer.get_Gbest()

# --- ALTERAÇÃO 2: Recuperar score da memória sem re-treinar ---
if hasattr(pso_optimizer, 'get_Gbest_fitness'):
    # Esta é a forma correta com o PSO otimizado
    best_fitness_pso = pso_optimizer.get_Gbest_fitness()
    print("(Score recuperado da memória - SEM re-treino desnecessário)")
else:
    # Fallback de segurança caso use o PSO antigo
    print("(Atenção: Re-treinando modelo final...)")
    best_fitness_pso = fitness_function(best_params_pso)

print("\n" + "=" * 50, flush=True)
print("--- OTIMIZAÇÃO PSO CONCLUÍDA ---", flush=True)
print(f"🏆 Melhor Val Loss (PSO): {best_fitness_pso:.5f}", flush=True)
print(f"🔩 Melhores Hiperparâmetros (PSO):")
print(f"Learning Rate: {best_params_pso[0]:.6f}", flush=True)
print(f"Neurónios: {int(best_params_pso[1])}", flush=True)
print("=" * 50 + "\n", flush=True)
print("--- Script Concluído ---")