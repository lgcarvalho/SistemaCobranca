package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RespostaGUI
        extends JFrame {

    private SlaGUI telaSla;
    private CobrancaInfoGUI telaCobrancaInfo;
    public JTextArea areaAcaoEfetuada;
    private JButton botaoCopiarMensagem;
    private JButton botaoNovaConsulta;
    public JButton botaoVoltar;
    public JTextField campoCoordenador;
    public JTextField campoGerente;
    public JTextField campoGrupoProprietario;
    public JTextField campoHorasUteis;
    public JTextField campoModeloComunicacao;
    public JTextField campoSuperintendente;
    public JTextField campoTipoComunicacao;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public RespostaGUI() {
        initComponents();

        setIcon();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.campoModeloComunicacao = new JTextField();
        this.jLabel2 = new JLabel();
        this.campoTipoComunicacao = new JTextField();
        this.jLabel3 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.areaAcaoEfetuada = new JTextArea();
        this.jLabel8 = new JLabel();
        this.campoHorasUteis = new JTextField();
        this.jLabel10 = new JLabel();
        this.botaoCopiarMensagem = new JButton();
        this.jPanel2 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.campoCoordenador = new JTextField();
        this.campoGerente = new JTextField();
        this.campoSuperintendente = new JTextField();
        this.jLabel7 = new JLabel();
        this.campoGrupoProprietario = new JTextField();
        this.botaoNovaConsulta = new JButton();
        this.jLabel9 = new JLabel();
        this.botaoVoltar = new JButton();

        setDefaultCloseOperation(3);
        setTitle("SIPRIC - Sistema de Prioridade e Cobrança");
        setResizable(false);

        this.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Tipo de cobrança que deverá ser efetuado", 2, 0, new Font("Tahoma", 1, 11)));

        this.jLabel1.setText("Modelo de comunicação:");

        this.campoModeloComunicacao.setEditable(false);
        this.campoModeloComunicacao.setBackground(new Color(255, 255, 255));

        this.jLabel2.setText("Tipo de comunicação:");

        this.campoTipoComunicacao.setEditable(false);
        this.campoTipoComunicacao.setBackground(new Color(255, 255, 255));

        this.jLabel3.setText("Ação para ser efetuada:");

        this.areaAcaoEfetuada.setEditable(false);
        this.areaAcaoEfetuada.setColumns(20);
        this.areaAcaoEfetuada.setFont(new Font("Monospaced", 0, 11));
        this.areaAcaoEfetuada.setLineWrap(true);
        this.areaAcaoEfetuada.setRows(3);
        this.areaAcaoEfetuada.setWrapStyleWord(true);
        this.areaAcaoEfetuada.setAutoscrolls(false);
        this.jScrollPane1.setViewportView(this.areaAcaoEfetuada);

        this.jLabel8.setText("Horas Úteis decorridas:");

        this.campoHorasUteis.setEditable(false);
        this.campoHorasUteis.setBackground(new Color(255, 255, 255));

        this.jLabel10.setText("Mensagem para o usuário:");

        this.botaoCopiarMensagem.setText("Copiar para o CTRL+C");
        this.botaoCopiarMensagem.setFocusPainted(false);
        this.botaoCopiarMensagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RespostaGUI.this.botaoCopiarMensagemActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(this.jLabel3)
                                        .addComponent(this.jLabel1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(this.jLabel8)
                                                .addComponent(this.jLabel2))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jScrollPane1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(this.campoModeloComunicacao, -2, 110, -2)
                                                .addComponent(this.campoHorasUteis, -2, 70, -2)
                                                .addComponent(this.campoTipoComunicacao, -2, 160, -2))
                                        .addGap(0, 111, 32767)))
                        .addContainerGap())
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jLabel10)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.botaoCopiarMensagem)
                        .addContainerGap(-1, 32767)));

        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel8)
                                .addComponent(this.campoHorasUteis, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel2)
                                .addComponent(this.campoTipoComunicacao, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel1)
                                .addComponent(this.campoModeloComunicacao, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jLabel3)
                                .addComponent(this.jScrollPane1, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel10)
                                .addComponent(this.botaoCopiarMensagem))
                        .addContainerGap(-1, 32767)));

        this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Informações do grupo proprietário", 2, 0, new Font("Tahoma", 1, 11)));

        this.jLabel4.setText("Coordenador:");

        this.jLabel5.setText("Gerente:");

        this.jLabel6.setText("Superintendente:");

        this.campoCoordenador.setEditable(false);
        this.campoCoordenador.setBackground(new Color(255, 255, 255));

        this.campoGerente.setEditable(false);
        this.campoGerente.setBackground(new Color(255, 255, 255));

        this.campoSuperintendente.setEditable(false);
        this.campoSuperintendente.setBackground(new Color(255, 255, 255));

        this.jLabel7.setText("Grupo Proprietário:");

        this.campoGrupoProprietario.setEditable(false);
        this.campoGrupoProprietario.setBackground(new Color(255, 255, 255));

        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(-1, 32767)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jLabel6, GroupLayout.Alignment.TRAILING)
                                .addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING)
                                .addComponent(this.jLabel5, GroupLayout.Alignment.TRAILING)
                                .addComponent(this.jLabel7, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(this.campoGrupoProprietario, -1, 306, 32767)
                                .addComponent(this.campoCoordenador, GroupLayout.Alignment.TRAILING)
                                .addComponent(this.campoGerente, GroupLayout.Alignment.TRAILING)
                                .addComponent(this.campoSuperintendente, GroupLayout.Alignment.TRAILING))
                        .addContainerGap()));

        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel7)
                                .addComponent(this.campoGrupoProprietario, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel4)
                                .addComponent(this.campoCoordenador, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel5)
                                .addComponent(this.campoGerente, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel6)
                                .addComponent(this.campoSuperintendente, -2, -1, -2))
                        .addContainerGap(-1, 32767)));

        this.botaoNovaConsulta.setText("Nova Consulta");
        this.botaoNovaConsulta.setActionCommand("");
        this.botaoNovaConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RespostaGUI.this.botaoNovaConsultaActionPerformed(evt);
            }
        });
        this.jLabel9.setFont(new Font("Tahoma", 0, 9));
        this.jLabel9.setHorizontalAlignment(0);
        this.jLabel9.setText("Criado por Luiz G. Carvalho / Versão: 1.2");
        this.jLabel9.setToolTipText("");
        this.jLabel9.setBorder(BorderFactory.createEtchedBorder());

        this.botaoVoltar.setText("Voltar");
        this.botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RespostaGUI.this.botaoVoltarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.jLabel9, -1, -1, 32767)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, 32767)
                                        .addComponent(this.botaoVoltar, -2, 115, -2)
                                        .addGap(214, 214, 214)
                                        .addComponent(this.botaoNovaConsulta, -2, 115, -2))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(this.jPanel1, -2, -1, -2)
                                                .addComponent(this.jPanel2, -2, -1, -2))
                                        .addGap(0, 0, 32767)))
                        .addContainerGap()));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jPanel1, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jPanel2, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.botaoNovaConsulta)
                                .addComponent(this.botaoVoltar))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jLabel9)));

        pack();
        setLocationRelativeTo(null);
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/iconeGUI.png")));
    }

    private void botaoNovaConsultaActionPerformed(ActionEvent evt) {
        this.telaSla = new SlaGUI();
        this.telaSla.setVisible(true);
        dispose();
    }

    private void botaoVoltarActionPerformed(ActionEvent evt) {
        this.telaCobrancaInfo = new CobrancaInfoGUI();
        this.telaCobrancaInfo.setVisible(true);
        dispose();
    }

    private void botaoCopiarMensagemActionPerformed(ActionEvent evt) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String text = "Prezado colaborador, \n\nFoi enviada para a equipe solucionadora uma [priorização/nova cobrança de status] do seu chamado.\nPara maiores informações, favor entrar em contato com o Help Desk Itaú Unibanco Atacado através do telefone 3708-8555.\n\nObrigado,\nHelp Desk Itaú Unibanco Atacado";

        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RespostaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RespostaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RespostaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RespostaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RespostaGUI().setVisible(true);
            }
        });
    }
}
