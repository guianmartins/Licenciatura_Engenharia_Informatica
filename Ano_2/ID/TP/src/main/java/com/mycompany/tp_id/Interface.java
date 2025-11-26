
package com.mycompany.tp_id;

import static com.mycompany.tp_id.JDOMFunctions_XSLT.transformaDocumento;
import static com.mycompany.tp_id.JDOMFunctions_XSLT.transformaDocumento2;
import static com.mycompany.tp_id.SaxonFunctions_XQuery.xQueryToHtml;
import static com.mycompany.tp_id.SaxonFunctions_XQuery.xQueryToText;
import static com.mycompany.tp_id.XPathFunctions.executaXpath;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;
import net.sf.saxon.trans.XPathException;
import org.jdom2.Document;
import org.jdom2.Element;

public class Interface extends javax.swing.JFrame {


    public Interface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdRemover_Pais = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        txtPais_Remover = new javax.swing.JTextField();
        btnRemover = new javax.swing.JButton();
        jdAdicionar_Pais = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        txtAdiciona = new javax.swing.JTextField();
        btnAdiciona = new javax.swing.JButton();
        jOptionPane1 = new javax.swing.JOptionPane();
        jdAltera = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        txtPais_alterar = new javax.swing.JTextField();
        btnAltera = new javax.swing.JButton();
        jLabelNovo = new javax.swing.JLabel();
        txtNovo = new javax.swing.JTextField();
        jdXpath = new javax.swing.JDialog();
        btnXpath = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtXapth = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtXapth1 = new javax.swing.JTextField();
        jdXquery = new javax.swing.JDialog();
        txtXquery = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jBXquery = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMISair = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMIVer_Conteudo_Ficheiro = new javax.swing.JMenuItem();
        jMIRemover_Pais_Nome = new javax.swing.JMenuItem();
        jMIAdiciona_Pais = new javax.swing.JMenuItem();
        jMIAltera_Capital = new javax.swing.JMenuItem();
        jMIAltera_Populacao = new javax.swing.JMenuItem();
        jMIAltera_Area = new javax.swing.JMenuItem();
        jMIAltera_Continente = new javax.swing.JMenuItem();
        jMIAltera_Densidade = new javax.swing.JMenuItem();
        jMIAltera_Covid = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        JMIValidar_DTD = new javax.swing.JMenuItem();
        JMIValidar_XSD = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMIPesquisa_Nome = new javax.swing.JMenuItem();
        jMIPesquisa_CidadesImp = new javax.swing.JMenuItem();
        jMIPesquisa_habitantes = new javax.swing.JMenuItem();
        jMIPesquisa_Religiao = new javax.swing.JMenuItem();
        jMIPesquisa_Capitais = new javax.swing.JMenuItem();
        jMIPesquisa_CasosCovid = new javax.swing.JMenuItem();
        jMI_fronteira = new javax.swing.JMenuItem();
        jMI_Lingua_OFicial = new javax.swing.JMenuItem();
        jMI_Continente = new javax.swing.JMenuItem();
        jMI_Area = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jLabel1.setText("País a remover: ");

        txtPais_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPais_RemoverActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdRemover_PaisLayout = new javax.swing.GroupLayout(jdRemover_Pais.getContentPane());
        jdRemover_Pais.getContentPane().setLayout(jdRemover_PaisLayout);
        jdRemover_PaisLayout.setHorizontalGroup(
            jdRemover_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdRemover_PaisLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jdRemover_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemover)
                    .addGroup(jdRemover_PaisLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPais_Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        jdRemover_PaisLayout.setVerticalGroup(
            jdRemover_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdRemover_PaisLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jdRemover_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPais_Remover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnRemover)
                .addGap(56, 56, 56))
        );

        jLabel2.setText("País a Adicionar: ");

        txtAdiciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdicionaActionPerformed(evt);
            }
        });

        btnAdiciona.setText("Adiciona");
        btnAdiciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdAdicionar_PaisLayout = new javax.swing.GroupLayout(jdAdicionar_Pais.getContentPane());
        jdAdicionar_Pais.getContentPane().setLayout(jdAdicionar_PaisLayout);
        jdAdicionar_PaisLayout.setHorizontalGroup(
            jdAdicionar_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdAdicionar_PaisLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jdAdicionar_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdiciona)
                    .addGroup(jdAdicionar_PaisLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAdiciona, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        jdAdicionar_PaisLayout.setVerticalGroup(
            jdAdicionar_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdAdicionar_PaisLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jdAdicionar_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAdiciona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnAdiciona)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLabel4.setText("País a Alterar: ");

        txtPais_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPais_alterarActionPerformed(evt);
            }
        });

        btnAltera.setText("Alterar");
        btnAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraActionPerformed(evt);
            }
        });

        jLabelNovo.setText("Capital (Nova):");
        jLabelNovo.setToolTipText("");

        txtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdAlteraLayout = new javax.swing.GroupLayout(jdAltera.getContentPane());
        jdAltera.getContentPane().setLayout(jdAlteraLayout);
        jdAlteraLayout.setHorizontalGroup(
            jdAlteraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdAlteraLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jdAlteraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAltera)
                    .addGroup(jdAlteraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jdAlteraLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPais_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdAlteraLayout.createSequentialGroup()
                            .addComponent(jLabelNovo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jdAlteraLayout.setVerticalGroup(
            jdAlteraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdAlteraLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jdAlteraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPais_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jdAlteraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNovo)
                    .addComponent(txtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnAltera)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnXpath.setText("Pesquisar");
        btnXpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXpathActionPerformed(evt);
            }
        });

        jLabel7.setText("País a Pesquisar:");

        txtXapth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXapthActionPerformed(evt);
            }
        });

        jLabel8.setText("Nº Máximo de Casos:");

        txtXapth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXapth1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdXpathLayout = new javax.swing.GroupLayout(jdXpath.getContentPane());
        jdXpath.getContentPane().setLayout(jdXpathLayout);
        jdXpathLayout.setHorizontalGroup(
            jdXpathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdXpathLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jdXpathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jdXpathLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(31, 31, 31)
                        .addComponent(txtXapth))
                    .addGroup(jdXpathLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtXapth1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addComponent(btnXpath))
                .addGap(17, 17, 17))
        );
        jdXpathLayout.setVerticalGroup(
            jdXpathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdXpathLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jdXpathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtXapth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdXpathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtXapth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnXpath)
                .addGap(21, 21, 21))
        );

        txtXquery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXqueryActionPerformed(evt);
            }
        });

        jLabel5.setText("Introduza País:");

        jBXquery.setText("Gerar");
        jBXquery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBXqueryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdXqueryLayout = new javax.swing.GroupLayout(jdXquery.getContentPane());
        jdXquery.getContentPane().setLayout(jdXqueryLayout);
        jdXqueryLayout.setHorizontalGroup(
            jdXqueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdXqueryLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jdXqueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBXquery)
                    .addComponent(jLabel5)
                    .addComponent(txtXquery, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jdXqueryLayout.setVerticalGroup(
            jdXqueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdXqueryLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtXquery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBXquery)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(105, 102, 103));

        jLabel3.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(81, 51, 60));
        jLabel3.setText("Output");

        jTextArea1.setBackground(new java.awt.Color(86, 117, 114));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel3)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setBorder(null);

        jMenu3.setText("Principal");

        jMISair.setText("Sair");
        jMISair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISairActionPerformed(evt);
            }
        });
        jMenu3.add(jMISair);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("XML");

        jMIVer_Conteudo_Ficheiro.setText("Ver Conteúdo do Ficheiro");
        jMIVer_Conteudo_Ficheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIVer_Conteudo_FicheiroActionPerformed(evt);
            }
        });
        jMenu1.add(jMIVer_Conteudo_Ficheiro);

        jMIRemover_Pais_Nome.setText("Remover País pelo Nome");
        jMIRemover_Pais_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRemover_Pais_NomeActionPerformed(evt);
            }
        });
        jMenu1.add(jMIRemover_Pais_Nome);

        jMIAdiciona_Pais.setText("Adicionar País");
        jMIAdiciona_Pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAdiciona_PaisActionPerformed(evt);
            }
        });
        jMenu1.add(jMIAdiciona_Pais);

        jMIAltera_Capital.setText("Altera Capital");
        jMIAltera_Capital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAltera_CapitalActionPerformed(evt);
            }
        });
        jMenu1.add(jMIAltera_Capital);

        jMIAltera_Populacao.setText("Altera População");
        jMIAltera_Populacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAltera_PopulacaoActionPerformed(evt);
            }
        });
        jMenu1.add(jMIAltera_Populacao);

        jMIAltera_Area.setText("Altera Area");
        jMIAltera_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAltera_AreaActionPerformed(evt);
            }
        });
        jMenu1.add(jMIAltera_Area);

        jMIAltera_Continente.setText("Altera Continente");
        jMIAltera_Continente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAltera_ContinenteActionPerformed(evt);
            }
        });
        jMenu1.add(jMIAltera_Continente);

        jMIAltera_Densidade.setText("Altera Densidade");
        jMIAltera_Densidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAltera_DensidadeActionPerformed(evt);
            }
        });
        jMenu1.add(jMIAltera_Densidade);

        jMIAltera_Covid.setText("Altera Covid");
        jMIAltera_Covid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAltera_CovidActionPerformed(evt);
            }
        });
        jMenu1.add(jMIAltera_Covid);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Validar");

        JMIValidar_DTD.setText("DTD");
        JMIValidar_DTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIValidar_DTDActionPerformed(evt);
            }
        });
        jMenu2.add(JMIValidar_DTD);

        JMIValidar_XSD.setText("XSD");
        JMIValidar_XSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIValidar_XSDActionPerformed(evt);
            }
        });
        jMenu2.add(JMIValidar_XSD);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("XPATH");

        jMIPesquisa_Nome.setText("Pesquisar pelo nome");
        jMIPesquisa_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPesquisa_NomeActionPerformed(evt);
            }
        });
        jMenu4.add(jMIPesquisa_Nome);

        jMIPesquisa_CidadesImp.setText("Pesquisar cidades importantes de um dado país");
        jMIPesquisa_CidadesImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPesquisa_CidadesImpActionPerformed(evt);
            }
        });
        jMenu4.add(jMIPesquisa_CidadesImp);

        jMIPesquisa_habitantes.setText("Pesquisar países com número de habitantes superior a um valor introduzido");
        jMIPesquisa_habitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPesquisa_habitantesActionPerformed(evt);
            }
        });
        jMenu4.add(jMIPesquisa_habitantes);

        jMIPesquisa_Religiao.setText("Pesquisar países com uma determinada religião");
        jMIPesquisa_Religiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPesquisa_ReligiaoActionPerformed(evt);
            }
        });
        jMenu4.add(jMIPesquisa_Religiao);

        jMIPesquisa_Capitais.setText("Pesquisar todas as capitais existentes no ficheiro");
        jMIPesquisa_Capitais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPesquisa_CapitaisActionPerformed(evt);
            }
        });
        jMenu4.add(jMIPesquisa_Capitais);

        jMIPesquisa_CasosCovid.setText("Mostrar países com casos covid entre um valor mínimo e um valor máximo");
        jMIPesquisa_CasosCovid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPesquisa_CasosCovidActionPerformed(evt);
            }
        });
        jMenu4.add(jMIPesquisa_CasosCovid);

        jMI_fronteira.setText("Pesquisar países que partilham fronteira com um determinado país");
        jMI_fronteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_fronteiraActionPerformed(evt);
            }
        });
        jMenu4.add(jMI_fronteira);

        jMI_Lingua_OFicial.setText("Pesquisar países que tenham uma determinada língua oficial");
        jMI_Lingua_OFicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_Lingua_OFicialActionPerformed(evt);
            }
        });
        jMenu4.add(jMI_Lingua_OFicial);

        jMI_Continente.setText("Pesquisar países num determinado continente");
        jMI_Continente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_ContinenteActionPerformed(evt);
            }
        });
        jMenu4.add(jMI_Continente);

        jMI_Area.setText("Pesquisar países com área maior que um valor introduzido");
        jMI_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_AreaActionPerformed(evt);
            }
        });
        jMenu4.add(jMI_Area);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("XLST");

        jMenuItem1.setText("Gerar HTML com as bandeiras dos países");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem3.setText(" Gerar ficheiro XML com os 5 países mais populosos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem7.setText("Gerar TXT com as linguas e religiões de cada país");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("XQUERY");

        jMenuItem2.setText("Gerar ficheiro TXT com cidades importantes de um país");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuItem4.setText("Gerar ficheiro HTML com os países fronteiriços de um país escolhido");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem5.setText("Gerar HTML com as informações paises de um continente escolhido");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem6.setText("Gerar XML com a Informação de cada continente existente");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIRemover_Pais_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRemover_Pais_NomeActionPerformed
        jdRemover_Pais.setSize(350, 200);
        jdRemover_Pais.setLocation(200, 200);
        jdRemover_Pais.setVisible(true);
    }//GEN-LAST:event_jMIRemover_Pais_NomeActionPerformed

    private void jMIPesquisa_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPesquisa_NomeActionPerformed
        txtXapth.setText("");
       
        jLabel8.setVisible(false);
        txtXapth1.setVisible(false);
         jdXpath.setSize(350, 200);
        jdXpath.setLocation(200, 200);
        jdXpath.setTitle("Pesquisa 1");
        jdXpath.setVisible(true);
    }//GEN-LAST:event_jMIPesquisa_NomeActionPerformed

    private void jMISairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISairActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMISairActionPerformed

    private void jMIVer_Conteudo_FicheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIVer_Conteudo_FicheiroActionPerformed
        Document doc = XMLJDomFunctions.lerDocumentoXML("paises.xml"); 
        String texto = XMLJDomFunctions.escreverDocumentoString(doc); 
        jTextArea1.setText(texto);
    }//GEN-LAST:event_jMIVer_Conteudo_FicheiroActionPerformed

    private void txtPais_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPais_RemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPais_RemoverActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        Document doc = XMLJDomFunctions.lerDocumentoXML("paises.xml"); 
        String nome = txtPais_Remover.getText();
        try {
            doc=ModeloXML.removePais(nome, doc);
            if(doc!=null){ 
                XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "paises.xml"); 
                jOptionPane1.showMessageDialog(this, 
                "Pais Removido com Sucesso", 
                "INFO", 
                jOptionPane1.INFORMATION_MESSAGE);
            }else{
                jOptionPane1.showMessageDialog(this, 
            "País não existe", 
            "ERROR", 
            jOptionPane1.ERROR_MESSAGE);
            }
            jdRemover_Pais.setVisible(false);
            String texto = XMLJDomFunctions.escreverDocumentoString(doc); 
            jTextArea1.setText(texto);
            
        } catch (HeadlessException e) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void txtAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdicionaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdicionaActionPerformed

    private void btnAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaActionPerformed
        pais p;
        String xp=null;
        XdmValue res = null;
        
        
        try {
            p = Wrappers.procura_dados_pais(txtAdiciona.getText());
            
            if(p == null){
                jdAdicionar_Pais.setVisible(false);
                jOptionPane1.showMessageDialog(this, 
                "País já existe", 
                "ERRO", 
                jOptionPane1.ERROR_MESSAGE);
            }else{
                Document doc = XMLJDomFunctions.lerDocumentoXML("paises.xml"); 
                doc = ModeloXML.adicionaPais(p, doc);
                XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "paises.xml");
                jdAdicionar_Pais.setVisible(false);
                
                String texto = XMLJDomFunctions.escreverDocumentoString(doc); 
                jTextArea1.setText(texto);
                jOptionPane1.showMessageDialog(this, 
                "País Inserido com sucesso", 
                "Informação", 
                jOptionPane1.INFORMATION_MESSAGE);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SaxonApiException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdicionaActionPerformed

    private void jMIAdiciona_PaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAdiciona_PaisActionPerformed
        jdAdicionar_Pais.setSize(350, 200);
        jdAdicionar_Pais.setLocation(200, 200);
        jdAdicionar_Pais.setVisible(true);
    }//GEN-LAST:event_jMIAdiciona_PaisActionPerformed

    private void JMIValidar_DTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIValidar_DTDActionPerformed
        int res = 0;
        try { 
            res = ValidarXML.validarDocumentoDTD("paises.xml", "paises.dtd");
            if(res == -1){
                jOptionPane1.showMessageDialog(this, 
                "Invalido por DTD", 
                "INFORMATION", 
                jOptionPane1.INFORMATION_MESSAGE);
            }else{
                jOptionPane1.showMessageDialog(this, 
                "Valido por DTD", 
                "INFORMATION", 
                jOptionPane1.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JMIValidar_DTDActionPerformed

    private void JMIValidar_XSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIValidar_XSDActionPerformed
            int res;
            res = ValidarXML.validarDocumentoXSD("paises.xml", "paises.xsd");
            if(res == -1){
                jOptionPane1.showMessageDialog(this,
                        "Invalido por XSD",
                        "INFORMATION",
                        jOptionPane1.INFORMATION_MESSAGE);
            }else{
                jOptionPane1.showMessageDialog(this,
                        "Valido por XSD",
                        "INFORMATION",
                        jOptionPane1.INFORMATION_MESSAGE);
            }
            
    }//GEN-LAST:event_JMIValidar_XSDActionPerformed

    private void txtPais_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPais_alterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPais_alterarActionPerformed

    private void btnAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteraActionPerformed
        String tipoAlterar = jLabelNovo.getToolTipText();
        String pais = txtPais_alterar.getText();
        String CampoNovo = txtNovo.getText();
        Document doc = XMLJDomFunctions.lerDocumentoXML("paises.xml"); 
        
        switch (tipoAlterar){
                case "Capital" -> doc = ModeloXML.alteraCapital(pais, CampoNovo, doc);
                case "Populacao" -> doc = ModeloXML.alteraPopulacao(pais, CampoNovo, doc);
                case "Area" -> doc = ModeloXML.alteraArea(pais, CampoNovo, doc);
                case "Continente" -> doc = ModeloXML.alteraContinente(pais, CampoNovo, doc);
                case "Densidade" -> doc = ModeloXML.alteraDensidade(pais, CampoNovo, doc);
                case "Covid" -> doc = ModeloXML.alteraCovid(pais, CampoNovo, doc); 
              
        }
        
        if(doc == null){      
            jOptionPane1.showMessageDialog(this, 
            "País não Encontrado", 
            "ERRO", 
            jOptionPane1.ERROR_MESSAGE);
        }else{
            String texto = XMLJDomFunctions.escreverDocumentoString(doc); 
            jTextArea1.setText(texto);
            XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "paises.xml");
            jOptionPane1.showMessageDialog(this, 
            tipoAlterar + " Alterada com Sucesso", 
            "INFORMATION", 
            jOptionPane1.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnAlteraActionPerformed

    private void txtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNovoActionPerformed

    private void jMIAltera_CapitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAltera_CapitalActionPerformed
        jdAltera.setSize(350, 250);
        jdAltera.setLocation(200, 200);
        jdAltera.setVisible(true);
        jLabelNovo.setText("Capital (Novo): ");
        jLabelNovo.setToolTipText("Capital");
    }//GEN-LAST:event_jMIAltera_CapitalActionPerformed

    private void jMIAltera_PopulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAltera_PopulacaoActionPerformed
        jdAltera.setSize(400, 250);
        jdAltera.setLocation(200, 200);
        jdAltera.setVisible(true);
        jLabelNovo.setText("Numero População (Novo): ");
        jLabelNovo.setToolTipText("Populacao");
    }//GEN-LAST:event_jMIAltera_PopulacaoActionPerformed

    private void jMIAltera_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAltera_AreaActionPerformed
        jdAltera.setSize(350, 250);
        jdAltera.setLocation(200, 200);
        jdAltera.setVisible(true);
        jLabelNovo.setText("Area (Nova): ");
        jLabelNovo.setToolTipText("Area");
    }//GEN-LAST:event_jMIAltera_AreaActionPerformed

    private void jMIAltera_ContinenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAltera_ContinenteActionPerformed
        jdAltera.setSize(350, 250);
        jdAltera.setLocation(200, 200);
        jdAltera.setVisible(true);
        jLabelNovo.setText("Continente (Novo): ");
        jLabelNovo.setToolTipText("Continente");
    }//GEN-LAST:event_jMIAltera_ContinenteActionPerformed

    private void jMIAltera_DensidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAltera_DensidadeActionPerformed
        jdAltera.setSize(350, 250);
        jdAltera.setLocation(200, 200);
        jdAltera.setVisible(true);
        jLabelNovo.setText("Densidade (Nova): ");
        jLabelNovo.setToolTipText("Densidade");
    }//GEN-LAST:event_jMIAltera_DensidadeActionPerformed

    private void jMIAltera_CovidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAltera_CovidActionPerformed
        jdAltera.setSize(400, 250);
        jdAltera.setLocation(200, 200);
        jdAltera.setVisible(true);
        jLabelNovo.setText("Numero Casos Covid (Novo): ");
        jLabelNovo.setToolTipText("Covid");
    }//GEN-LAST:event_jMIAltera_CovidActionPerformed

    private void btnXpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXpathActionPerformed

        Document doc = XMLJDomFunctions.lerDocumentoXML("paises.xml");
        if (doc != null) {
            doc.setDocType(null); // Isto remove o DOCTYPE
            XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "paises.xml");
        } // Como o ficheiro quando validado contem o <!DOCType ...> , este nao permite os \n depois.
        
        String xp=null;
        XdmValue res=null;
        String pesquisa = txtXapth.getText();
        String pesquisa1 = txtXapth1.getText();
        
        if(jdXpath.getTitle().equals("Pesquisa 1")){
            xp = "//pais[@nome = '"+ pesquisa +"']";
        }   

        if(jdXpath.getTitle().equals("Pesquisa 2")){
            xp="//pais[@nome='"+pesquisa+"']/cidadesImportantes/cidade";
        }   

        if(jdXpath.getTitle().equals("Pesquisa 3")){
            xp="//pais[number(populacao) > "+ Integer.valueOf(pesquisa)+"]/@nome";
        }   

        if(jdXpath.getTitle().equals("Pesquisa 4")){ 
            xp = "//pais[//religioes/religiao ='"+pesquisa+"']/@nome";
        }   

        if(jdXpath.getTitle().equals("Pesquisa 5")){
            xp="//pais[number(casosCovid) >= " + Integer.valueOf(pesquisa) + 
                " and number(casosCovid) <= " + Integer.valueOf(pesquisa1) + "]/@nome";
        }   

        if(jdXpath.getTitle().equals("Pesquisa 6")){
            xp="//pais[paisesFronteira/paisFronteira='"+pesquisa+"']/@nome";
        }   

        if(jdXpath.getTitle().equals("Pesquisa 7")){
            xp="//pais[linguasOficiais/lingua='"+pesquisa+"']/@nome";
        }   

        if(jdXpath.getTitle().equals("Pesquisa 8")){
            xp="//pais[continente='"+pesquisa+"']/@nome";
        }  

        if(jdXpath.getTitle().equals("Pesquisa 9")){
            xp="//pais[area > "+pesquisa+"]/@nome";
        }  

        jdXpath.setVisible(false);
        try {
            res = XPathFunctions.executaXpath(xp, "paises.xml");
        } catch (SaxonApiException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }

        //String s1 = XPathFunctions.listaResultado(res_1);
        if (res == null  || res.size() == 0)
            JOptionPane.showMessageDialog(this, 
            "Sem Resultados", 
            "Warning", 
            JOptionPane.WARNING_MESSAGE); 
        else if(res != null  || res.size() != 0){
            String s = XPathFunctions.listaResultado(res);
            jTextArea1.setText(s);
        }
        
    }//GEN-LAST:event_btnXpathActionPerformed

    private void txtXapthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXapthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXapthActionPerformed

    private void txtXapth1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXapth1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXapth1ActionPerformed

    private void jMIPesquisa_CidadesImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPesquisa_CidadesImpActionPerformed
        txtXapth.setText("");
        jLabel7.setText("Introduza País");
        jLabel8.setVisible(false);
        txtXapth1.setVisible(false);
        jdXpath.setSize(350, 200);
        jdXpath.setLocation(200, 200);
        jdXpath.setTitle("Pesquisa 2");
        jdXpath.setVisible(true);
    }//GEN-LAST:event_jMIPesquisa_CidadesImpActionPerformed

    private void jMIPesquisa_habitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPesquisa_habitantesActionPerformed
        txtXapth.setText("");
        jLabel8.setVisible(false);
        txtXapth1.setVisible(false);
        jLabel7.setText("Nº de Habitantes");
         jdXpath.setSize(350, 200);
        jdXpath.setLocation(200, 200);
        jdXpath.setTitle("Pesquisa 3");
        jdXpath.setVisible(true);
    }//GEN-LAST:event_jMIPesquisa_habitantesActionPerformed

    private void jMIPesquisa_ReligiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPesquisa_ReligiaoActionPerformed
        txtXapth.setText("");
        jLabel8.setVisible(false);
        txtXapth1.setVisible(false);
        jLabel7.setText("Religião a Procurar");
         jdXpath.setSize(350, 200);
        jdXpath.setLocation(200, 200);
        jdXpath.setTitle("Pesquisa 4");
        jdXpath.setVisible(true);
    }//GEN-LAST:event_jMIPesquisa_ReligiaoActionPerformed

    private void jMIPesquisa_CapitaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPesquisa_CapitaisActionPerformed
        try {
            String xp="//pais/capital";
            XdmValue res = null;
            res = XPathFunctions.executaXpath(xp, "paises.xml");
            String s = XPathFunctions.listaResultado(res);
            if (res == null  || res.size() == 0)
                jTextArea1.setText("Sem resultados");
            else
                jTextArea1.setText(s);
        } catch (SaxonApiException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMIPesquisa_CapitaisActionPerformed

    private void jMIPesquisa_CasosCovidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPesquisa_CasosCovidActionPerformed
        txtXapth.setText("");
        jLabel7.setText("Nº Minimo de Casos:");
        jLabel8.setVisible(true);
        txtXapth1.setVisible(true);
         jdXpath.setSize(350, 200);
        jdXpath.setLocation(200, 200);
        jdXpath.setTitle("Pesquisa 5");
        jdXpath.setVisible(true);
    }//GEN-LAST:event_jMIPesquisa_CasosCovidActionPerformed

    private void jMI_fronteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_fronteiraActionPerformed
        txtXapth.setText("");
        jLabel7.setText("País que faz fronteira:");
        jLabel8.setVisible(false);
        txtXapth1.setVisible(false);
         jdXpath.setSize(350, 200);
        jdXpath.setLocation(200, 200);
        jdXpath.setTitle("Pesquisa 6");
        jdXpath.setVisible(true);
    }//GEN-LAST:event_jMI_fronteiraActionPerformed

    private void jMI_Lingua_OFicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_Lingua_OFicialActionPerformed
        txtXapth.setText("");
        jLabel7.setText("Lingua Oficial:");
        jLabel8.setVisible(false);
        txtXapth1.setVisible(false);
        jdXpath.setSize(350, 200);
        jdXpath.setLocation(200, 200);
        jdXpath.setTitle("Pesquisa 7");
        jdXpath.setVisible(true);
    }//GEN-LAST:event_jMI_Lingua_OFicialActionPerformed

    private void jMI_ContinenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_ContinenteActionPerformed
        txtXapth.setText("");
        jLabel7.setText("Continente:");
        jLabel8.setVisible(false);
        txtXapth1.setVisible(false);
         jdXpath.setSize(350, 200);
        jdXpath.setLocation(200, 200);
        jdXpath.setTitle("Pesquisa 8");
        jdXpath.setVisible(true);
    }//GEN-LAST:event_jMI_ContinenteActionPerformed

    private void jMI_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_AreaActionPerformed
        txtXapth.setText("");
        jLabel7.setText("Valor a Introduzir:");
        jLabel8.setVisible(false);
        txtXapth1.setVisible(false);
         jdXpath.setSize(350, 200);
        jdXpath.setLocation(200, 200);
        jdXpath.setTitle("Pesquisa 9");
        jdXpath.setVisible(true);
    }//GEN-LAST:event_jMI_AreaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Document doc = XMLJDomFunctions.lerDocumentoXML("paises.xml"); 
        if (doc != null) { 
            Document novo = transformaDocumento(doc, "paises.xml", "xsl_tabelaPaises.xsl"); 
            XMLJDomFunctions.escreverDocumentoParaFicheiro(novo, "bandeiras.html"); 
            JOptionPane.showMessageDialog(this, 
            "Transformação feita com sucesso... a abrir browser...", 
            "XSLT para HTML",JOptionPane.INFORMATION_MESSAGE); 
            String url = "bandeiras.html"; 
            File htmlFile = new File(url); 
           try { 
               Desktop.getDesktop().browse(htmlFile.toURI());
           } catch (IOException ex) {
               Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
           }
        } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Document doc = XMLJDomFunctions.lerDocumentoXML("paises.xml"); 
        if (doc != null) { 
            Document novo = transformaDocumento(doc, "paises.xml", "xsl_paisesPopulosos.xsl"); 
            XMLJDomFunctions.escreverDocumentoParaFicheiro(novo, "Top5PaisesPopulosos.xml"); 

            // Corrigido: ler o ficheiro XML gerado
            doc = XMLJDomFunctions.lerDocumentoXML("Top5PaisesPopulosos.xml"); 
            String t = XMLJDomFunctions.escreverDocumentoString(doc); 
            jTextArea1.setText(t); 

            JOptionPane.showMessageDialog(this, 
                "Transformação feita com sucesso...", 
                "XSLT para XML", JOptionPane.INFORMATION_MESSAGE); 
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void txtXqueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXqueryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXqueryActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        txtXquery.setText("");
        jdXquery.setSize(350, 250);
        jdXquery.setLocation(200, 200);
        jdXquery.setVisible(true);
        jdXquery.setTitle("Xquery1");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jBXqueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBXqueryActionPerformed
        String tit = jdXquery.getTitle();
        
        String esc = txtXquery.getText();
        Element raiz = new Element("input"); 
        Document docV = new Document(raiz); 
        raiz.addContent(esc); 
        XMLJDomFunctions.escreverDocumentoParaFicheiro(docV, "input.xml"); 
        
        switch (tit){
            case "Xquery1" -> {
                try {
                    xQueryToText("CidadesImportantes.txt", "cidadesImp.xql");
                    StringBuilder sb;
                    
                    try (Scanner in = new Scanner(new FileInputStream("CidadesImportantes.txt"), "UTF-8")) {
                        sb = new StringBuilder();
                        while (in.hasNextLine()) {
                            sb.append(in.nextLine()).append("\n");
                        }
                    }
                        
                    jTextArea1.setText(sb.toString());
                    
                    JOptionPane.showMessageDialog(this, 
                    "Transformação feita com sucesso... ", 
                    "XSLT para TXT",JOptionPane.INFORMATION_MESSAGE); 

                } catch (XPathException | IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case "Xquery2" -> {
                try {
                    SaxonFunctions_XQuery.xQueryToHtml("PaisesFronteiricos.html", "paisesFront.xql");
                    String url = "PaisesFronteiricos.html"; 
                    JOptionPane.showMessageDialog(this, 
                    "Transformação feita com sucesso... a abrir browser...", 
                    "XSLT para HTML",JOptionPane.INFORMATION_MESSAGE); 
                    File htmlFile = new File(url); 
                   try { 
                       Desktop.getDesktop().browse(htmlFile.toURI());
                   } catch (IOException ex) {
                       Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                   }
                } catch (XPathException | IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            case "Xquery3" -> {
                 try {
                    SaxonFunctions_XQuery.xQueryToHtml("PaisesPorContinente.html", "InfoPorCont.xql");
                    String url = "PaisesPorContinente.html"; 
                    JOptionPane.showMessageDialog(this, 
                    "Transformação feita com sucesso... a abrir browser...", 
                    "XSLT para HTML",JOptionPane.INFORMATION_MESSAGE); 
                    File htmlFile = new File(url); 
                    try { 
                        Desktop.getDesktop().browse(htmlFile.toURI());
                    } catch (IOException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (XPathException | IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
        
        
    }//GEN-LAST:event_jBXqueryActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        txtXquery.setText("");
        jdXquery.setSize(350, 250);
        jdXquery.setLocation(200, 200);
        jdXquery.setVisible(true);
        jdXquery.setTitle("Xquery2");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        txtXquery.setText("");
        jLabel5.setText("Continente Desejado:");
        jdXquery.setSize(350, 250);
        jdXquery.setLocation(200, 200);
        jdXquery.setVisible(true);
        jdXquery.setTitle("Xquery3");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       try {
            SaxonFunctions_XQuery.xQueryToXml("InfoContinentes.xml", "Continentes.xql");
            Document doc = XMLJDomFunctions.lerDocumentoXML("InfoContinentes.xml"); 
            if(doc == null){
                JOptionPane.showMessageDialog(this, 
                "Ficheiro Nao existe para leitura", 
                "ERRO",JOptionPane.ERROR_MESSAGE); 
            }else{
                String text = XMLJDomFunctions.escreverDocumentoString(doc);
                jTextArea1.setText(text);
                JOptionPane.showMessageDialog(this, 
                "Transformação feita com sucesso...", 
                "XSLT para XML",JOptionPane.INFORMATION_MESSAGE); 
            }
            
        } catch (XPathException | IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Document doc = XMLJDomFunctions.lerDocumentoXML("paises.xml"); 
        if (doc != null) { 
           transformaDocumento2("paises.xml", "xsl_linguasReligioes.xsl","Linguas_Religioes.txt"); 

            StringBuilder sb;
                    
            try (Scanner in = new Scanner(new FileInputStream("Linguas_Religioes.txt"), "UTF-8")) {
                sb = new StringBuilder();
                while (in.hasNextLine()) {
                    sb.append(in.nextLine()).append("\n");
                }
                jTextArea1.setText(sb.toString());
                JOptionPane.showMessageDialog(this, 
                "Transformação feita com sucesso...", 
                "XSLT para TXT", JOptionPane.INFORMATION_MESSAGE); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }    
            
        }else{
            JOptionPane.showMessageDialog(this, 
                "Ficheiro XML não existe (paises.xml)", 
                "ERRO", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMIValidar_DTD;
    private javax.swing.JMenuItem JMIValidar_XSD;
    private javax.swing.JButton btnAdiciona;
    private javax.swing.JButton btnAltera;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnXpath;
    private javax.swing.JButton jBXquery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelNovo;
    private javax.swing.JMenuItem jMIAdiciona_Pais;
    private javax.swing.JMenuItem jMIAltera_Area;
    private javax.swing.JMenuItem jMIAltera_Capital;
    private javax.swing.JMenuItem jMIAltera_Continente;
    private javax.swing.JMenuItem jMIAltera_Covid;
    private javax.swing.JMenuItem jMIAltera_Densidade;
    private javax.swing.JMenuItem jMIAltera_Populacao;
    private javax.swing.JMenuItem jMIPesquisa_Capitais;
    private javax.swing.JMenuItem jMIPesquisa_CasosCovid;
    private javax.swing.JMenuItem jMIPesquisa_CidadesImp;
    private javax.swing.JMenuItem jMIPesquisa_Nome;
    private javax.swing.JMenuItem jMIPesquisa_Religiao;
    private javax.swing.JMenuItem jMIPesquisa_habitantes;
    private javax.swing.JMenuItem jMIRemover_Pais_Nome;
    private javax.swing.JMenuItem jMISair;
    private javax.swing.JMenuItem jMIVer_Conteudo_Ficheiro;
    private javax.swing.JMenuItem jMI_Area;
    private javax.swing.JMenuItem jMI_Continente;
    private javax.swing.JMenuItem jMI_Lingua_OFicial;
    private javax.swing.JMenuItem jMI_fronteira;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JDialog jdAdicionar_Pais;
    private javax.swing.JDialog jdAltera;
    private javax.swing.JDialog jdRemover_Pais;
    private javax.swing.JDialog jdXpath;
    private javax.swing.JDialog jdXquery;
    private javax.swing.JTextField txtAdiciona;
    private javax.swing.JTextField txtNovo;
    private javax.swing.JTextField txtPais_Remover;
    private javax.swing.JTextField txtPais_alterar;
    private javax.swing.JTextField txtXapth;
    private javax.swing.JTextField txtXapth1;
    private javax.swing.JTextField txtXquery;
    // End of variables declaration//GEN-END:variables
}
