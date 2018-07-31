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

public class PriorizacaoGUI
        extends JFrame {

    private SlaGUI telaSla;
    private JTextArea areaAcaoEfetuada;
    private JButton botaoNovaConsulta;
    private JTextField campoModeloComunicacao;
    private JTextField campoTipoComunicacao;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public PriorizacaoGUI() {
        initComponents();

        setIcon();

        this.campoTipoComunicacao.setText("Priorização");
        this.campoModeloComunicacao.setText("PRIORIATACADO");
        this.areaAcaoEfetuada.setText("Priorização de Chamado [Somente ser usado uma UNICA vez por chamado, quando estiver dentro do SLA]");
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
        this.botaoNovaConsulta = new JButton();
        this.jLabel4 = new JLabel();

        setDefaultCloseOperation(3);
        setTitle("SIPRIC - Sistema de Prioridade e Cobrança");
        setResizable(false);

        this.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Necessário efetuar a priorização no chamado", 2, 0, new Font("Tahoma", 1, 11)));

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

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(this.jLabel2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(this.campoTipoComunicacao, -2, 151, -2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(this.jLabel3)
                                                .addComponent(this.jLabel1))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(this.jScrollPane1, -2, 280, -2)
                                                .addComponent(this.campoModeloComunicacao, -2, 150, -2))))
                        .addContainerGap(-1, 32767)));

        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel2)
                                .addComponent(this.campoTipoComunicacao, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel1)
                                .addComponent(this.campoModeloComunicacao, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(this.jLabel3)
                                        .addGap(0, 0, 32767))
                                .addComponent(this.jScrollPane1, -1, 79, 32767))
                        .addContainerGap()));

        this.botaoNovaConsulta.setText("Nova Consulta");
        this.botaoNovaConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PriorizacaoGUI.this.botaoNovaConsultaActionPerformed(evt);
            }
        });
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
                                .addComponent(this.botaoNovaConsulta, -1, -1, 32767)
                                .addComponent(this.jPanel1, -1, -1, 32767))
                        .addContainerGap(-1, 32767))
                .addComponent(this.jLabel4, -1, -1, 32767));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(-1, 32767)
                        .addComponent(this.jPanel1, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.botaoNovaConsulta)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jLabel4)));

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

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PriorizacaoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PriorizacaoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PriorizacaoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PriorizacaoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PriorizacaoGUI().setVisible(true);
            }
        });
    }
}
