package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.Comunicado;
import model.Data;
import model.Grupo;

public class CobrancaInfoGUI
        extends JFrame {

    String logComunicacao;
    String nomeGrupo;
    private Grupo grupos;
    private Comunicado comunicados;
    private Data data;
    private RespostaGUI telaResposta;
    private SlaGUI telaSla;
    private LogServicoGUI telaLogServico;
    private JButton botaoVerificar;
    private JFormattedTextField campoFormatadoData;
    private JComboBox<String> comboGrupoProprietario;
    private JComboBox<String> comboTipo;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public CobrancaInfoGUI() {
        initComponents();

        setIcon();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.comboTipo = new JComboBox();
        this.jLabel2 = new JLabel();
        this.campoFormatadoData = new JFormattedTextField();
        this.jLabel5 = new JLabel();
        this.botaoVerificar = new JButton();
        this.jPanel2 = new JPanel();
        this.comboGrupoProprietario = new JComboBox();
        this.jLabel4 = new JLabel();

        setDefaultCloseOperation(3);
        setTitle("SIPRIC - Sistema de Prioridade e Cobrançaa");
        setResizable(false);

        this.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Dados da última cobrança", 2, 0, new Font("Tahoma", 1, 11)));

        this.jLabel1.setText("Tipo de log de comunicação:");

        this.comboTipo.setModel(new DefaultComboBoxModel(new String[]{"Nenhum", "Priorização", "1ª Cobrançaa", "2ª Cobrança", "3ª Cobrança", "4ª ou mais cobranças"}));
        this.comboTipo.setSelectedIndex(-1);
        this.comboTipo.setFocusable(false);
        this.comboTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CobrancaInfoGUI.this.comboTipoActionPerformed(evt);
            }
        });
        this.jLabel2.setText("Data e horário da última cobrança");
        try {
            this.campoFormatadoData.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/#### ##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.campoFormatadoData.setHorizontalAlignment(0);
        this.campoFormatadoData.setEnabled(false);

        this.jLabel5.setFont(new Font("Tahoma", 1, 8));
        this.jLabel5.setText("DD/MM/AAAA  HH:MM");

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(this.jLabel2)
                                .addComponent(this.jLabel1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(this.jLabel5))
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(this.comboTipo, -2, 110, -2)
                                        .addComponent(this.campoFormatadoData)))
                        .addContainerGap(-1, 32767)));

        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(-1, 32767)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel1)
                                .addComponent(this.comboTipo, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel2)
                                .addComponent(this.campoFormatadoData, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jLabel5)));

        this.botaoVerificar.setText("Verificar");
        this.botaoVerificar.setEnabled(false);
        this.botaoVerificar.setFocusPainted(false);
        this.botaoVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CobrancaInfoGUI.this.botaoVerificarActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Grupo Proprietário:", 2, 0, new Font("Tahoma", 1, 11)));

        this.comboGrupoProprietario.setModel(new DefaultComboBoxModel(new String[]{"SUPORTE BBA MOBILIDADE", "SUPORTE BBA MOBILIDADE OPERADORAS", "SUPORTE CORREIO", "SUPORTE ADM USER", "SUPORTE BBA LOCAL REMOTO", "SUPORTE BBA TELECOM", "SUPORTE ATACADO 1 NIVEL SPOC NOVO COLABORADOR", "SUPORTE BBA OPERACAO VDI", "SUPORTE BBA LOCAL WTORRE", "SUPORTE BBA LOCAL FLFC", "SUPORTE BBA LOCAL FL3500", "OUTRO GRUPO RESPONSAVEL"}));
        this.comboGrupoProprietario.setSelectedIndex(-1);
        this.comboGrupoProprietario.setEnabled(false);
        this.comboGrupoProprietario.setFocusable(false);
        this.comboGrupoProprietario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CobrancaInfoGUI.this.comboGrupoProprietarioActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.comboGrupoProprietario, 0, -1, 32767)
                        .addContainerGap()));

        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.comboGrupoProprietario, -2, -1, -2)
                        .addContainerGap(-1, 32767)));

        this.jLabel4.setFont(new Font("Tahoma", 0, 9));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("Criado por Luiz G. Carvalho / Versão: 1.2");
        this.jLabel4.setToolTipText("");
        this.jLabel4.setBorder(BorderFactory.createEtchedBorder());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(this.jPanel2, -1, -1, 32767)
                                .addComponent(this.jPanel1, -1, -1, 32767)
                                .addComponent(this.botaoVerificar, -1, -1, 32767))
                        .addContainerGap(-1, 32767))
                .addComponent(this.jLabel4, -1, -1, 32767));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jPanel1, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jPanel2, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.botaoVerificar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                        .addComponent(this.jLabel4)));

        pack();
        setLocationRelativeTo(null);
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/iconeGUI.png")));
    }

    private void populaTelaResposta() {
        this.telaResposta = new RespostaGUI();

        this.comunicados = new Comunicado(this.logComunicacao);
        this.comunicados.definirComunicado();

        this.telaResposta.campoHorasUteis.setText(this.data.getTotalTempoPassado());

        this.telaResposta.campoTipoComunicacao.setText(this.comunicados.getTipoComunicacao());
        this.telaResposta.campoModeloComunicacao.setText(this.comunicados.getModeloComunicacao());
        this.telaResposta.areaAcaoEfetuada.setText(this.comunicados.getAcaoEfetuada());

        this.nomeGrupo = ((String) this.comboGrupoProprietario.getSelectedItem());
        this.grupos = new Grupo(this.nomeGrupo);
        this.grupos.validaGrupo();

        this.telaResposta.campoGrupoProprietario.setText(this.nomeGrupo);
        this.telaResposta.campoCoordenador.setText(this.grupos.getNomeCoordenador());
        this.telaResposta.campoGerente.setText(this.grupos.getNomeGerente());
        this.telaResposta.campoSuperintendente.setText(this.grupos.getNomeSuperintendente());
    }

    private void botaoVerificarActionPerformed(ActionEvent evt) {
        String dataCobranca = this.campoFormatadoData.getText();

        this.data = new Data();
        if ((this.logComunicacao.equals("Nenhum")) || (this.logComunicacao.equals("Priorização"))) {
            populaTelaResposta();
            this.telaResposta.setVisible(true);
            dispose();
        } else if (this.data.validarData(dataCobranca) == true) {
            if (!this.data.verificarDataCobranca(dataCobranca)) {
                if (this.data.calcularHorasPassadas(dataCobranca) == true) {
                    if (this.data.verificarHorasPassadas(this.logComunicacao) == true) {
                        populaTelaResposta();
                        this.telaResposta.setVisible(true);
                        dispose();
                    } else {
                        this.telaLogServico = new LogServicoGUI();
                        this.telaLogServico.setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Data inválida. Feriado ou final de semana");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Data/Horário inválidos");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data/Horário inválidos");
        }
    }

    private void comboTipoActionPerformed(ActionEvent evt) {
        this.logComunicacao = ((String) this.comboTipo.getSelectedItem());
        if (this.comboTipo.getSelectedIndex() == -1) {
            this.comboGrupoProprietario.setEnabled(false);
        } else {
            this.comboGrupoProprietario.setEnabled(true);
        }
        if ((this.comboTipo.getSelectedIndex() == -1) || (this.comboTipo.getSelectedIndex() == 0) || (this.comboTipo.getSelectedIndex() == 1)) {
            this.campoFormatadoData.setEnabled(false);
        } else {
            this.campoFormatadoData.setEnabled(true);
            this.campoFormatadoData.requestFocus();
        }
    }

    private void comboGrupoProprietarioActionPerformed(ActionEvent evt) {
        if (this.comboGrupoProprietario.getSelectedIndex() == -1) {
            this.botaoVerificar.setEnabled(false);
        } else {
            this.botaoVerificar.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CobrancaInfoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CobrancaInfoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CobrancaInfoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CobrancaInfoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CobrancaInfoGUI().setVisible(true);
            }
        });
    }
}
