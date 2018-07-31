package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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

public class LogServicoGUI
        extends JFrame {

    private SlaGUI telaSla;
    private CobrancaInfoGUI telaCobrancaInfo;
    private JButton botaoNovaConsulta;
    private JButton botaoVoltar;
    private JTextArea campoDetalhes;
    private JTextField campoResumo;
    private JTextField campoTipo;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public LogServicoGUI() {
        initComponents();

        setIcon();

        this.campoTipo.setText("OBSCLIENTE");
        this.campoResumo.setText("Urgência");
        this.campoDetalhes.setText("Usuário solicita urgência no chamado, pois já ultrapassou a SLA e está sendo impactado.");
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.campoResumo = new JTextField();
        this.campoTipo = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.campoDetalhes = new JTextArea();
        this.botaoVoltar = new JButton();
        this.jLabel9 = new JLabel();
        this.botaoNovaConsulta = new JButton();

        setDefaultCloseOperation(3);
        setTitle("SIPRIC - Sistema de Prioridade e Cobrançaa");
        setResizable(false);

        this.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Log de serviço", 2, 0, new Font("Tahoma", 1, 11)));
        this.jPanel1.setToolTipText("SIPRIC - Sistema de Prioridade e Cobrança");

        this.jLabel1.setText("Resumo:");

        this.jLabel2.setText("Detalhes:");

        this.jLabel3.setText("Tipo:");

        this.campoResumo.setEditable(false);
        this.campoResumo.setBackground(new Color(255, 255, 255));

        this.campoTipo.setEditable(false);
        this.campoTipo.setBackground(new Color(255, 255, 255));

        this.campoDetalhes.setEditable(false);
        this.campoDetalhes.setColumns(20);
        this.campoDetalhes.setFont(new Font("Monospaced", 0, 11));
        this.campoDetalhes.setLineWrap(true);
        this.campoDetalhes.setRows(3);
        this.campoDetalhes.setWrapStyleWord(true);
        this.jScrollPane1.setViewportView(this.campoDetalhes);

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jLabel2)
                                .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING)
                                .addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jScrollPane1, -1, 325, 32767)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(this.campoTipo, GroupLayout.Alignment.LEADING, -1, 70, 32767)
                                                .addComponent(this.campoResumo, GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, 32767)))
                        .addContainerGap()));

        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel3)
                                .addComponent(this.campoTipo, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel1)
                                .addComponent(this.campoResumo, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jLabel2)
                                .addComponent(this.jScrollPane1, -2, -1, -2))
                        .addContainerGap(-1, 32767)));

        this.botaoVoltar.setText("Voltar");
        this.botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LogServicoGUI.this.botaoVoltarActionPerformed(evt);
            }
        });
        this.jLabel9.setFont(new Font("Tahoma", 0, 9));
        this.jLabel9.setHorizontalAlignment(0);
        this.jLabel9.setText("Criado por Luiz G. Carvalho / Versão: 1.2");
        this.jLabel9.setToolTipText("");
        this.jLabel9.setBorder(BorderFactory.createEtchedBorder());

        this.botaoNovaConsulta.setText("Nova Consulta");
        this.botaoNovaConsulta.setActionCommand("");
        this.botaoNovaConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LogServicoGUI.this.botaoNovaConsultaActionPerformed(evt);
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
                                .addComponent(this.jPanel1, -1, -1, 32767)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(this.botaoVoltar, -2, 115, -2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                        .addComponent(this.botaoNovaConsulta, -2, 115, -2)))
                        .addContainerGap()));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jPanel1, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.botaoVoltar)
                                .addComponent(this.botaoNovaConsulta))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                        .addComponent(this.jLabel9)));

        pack();
        setLocationRelativeTo(null);
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/iconeGUI.png")));
    }

    private void botaoVoltarActionPerformed(ActionEvent evt) {
        this.telaCobrancaInfo = new CobrancaInfoGUI();
        this.telaCobrancaInfo.setVisible(true);
        dispose();
    }

    private void botaoNovaConsultaActionPerformed(ActionEvent evt) {
        this.telaSla = new SlaGUI();
        this.telaSla.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogServicoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LogServicoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LogServicoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LogServicoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogServicoGUI().setVisible(true);
            }
        });
    }
}
