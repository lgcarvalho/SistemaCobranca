package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
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
import model.Data;

public class SlaGUI
        extends JFrame {

    private Data data;
    private PriorizacaoGUI telaPriorizacao;
    private CobrancaGUI telaCobranca;
    private JButton botaoProximo;
    public JFormattedTextField campoFormatadoData;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public SlaGUI() {
        initComponents();

        setIcon();
    }

    private void initComponents() {
        this.botaoProximo = new JButton();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.campoFormatadoData = new JFormattedTextField();
        this.jLabel5 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();

        setDefaultCloseOperation(3);
        setTitle("SIPRIC - Sistema de Prioridade e Cobrançaa");
        setResizable(false);

        this.botaoProximo.setText("Próximo");
        this.botaoProximo.setFocusPainted(false);
        this.botaoProximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SlaGUI.this.botaoProximoActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Insira o SLA do chamado", 2, 0, new Font("Tahoma", 1, 11)));

        this.jLabel1.setText("Data de termino previsto:");
        try {
            this.campoFormatadoData.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/#### ##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.campoFormatadoData.setHorizontalAlignment(0);

        this.jLabel5.setFont(new Font("Tahoma", 1, 8));
        this.jLabel5.setText("DD/MM/AAAA  HH:MM");

        this.jLabel2.setFont(new Font("Tahoma", 0, 10));
        this.jLabel2.setForeground(new Color(255, 0, 51));
        this.jLabel2.setText("Obs.: O SLA deve ser visualizado na SOLICITAÇÃO e");

        this.jLabel3.setFont(new Font("Tahoma", 0, 10));
        this.jLabel3.setForeground(new Color(255, 0, 51));
        this.jLabel3.setText("não no INCIDENTE !!");

        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jLabel3)
                                .addComponent(this.jLabel2))
                        .addContainerGap(-1, 32767)));

        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jLabel3)
                        .addContainerGap(-1, 32767)));

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.campoFormatadoData)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(this.jLabel5)
                                        .addGap(0, 19, 32767)))
                        .addContainerGap())
                .addComponent(this.jPanel2, -1, -1, 32767));

        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(-1, 32767)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel1)
                                .addComponent(this.campoFormatadoData, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jPanel2, -2, -1, -2)));

        this.jLabel4.setFont(new Font("Tahoma", 0, 9));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("Criado por Luiz G. Carvalho / Versão: 1.2");
        this.jLabel4.setToolTipText("");
        this.jLabel4.setBorder(BorderFactory.createEtchedBorder());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.jLabel4, -1, -1, 32767)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jPanel1, -2, -1, -2)
                        .addContainerGap(-1, 32767))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(-1, 32767)
                        .addComponent(this.botaoProximo, -2, 277, -2)
                        .addContainerGap()));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jPanel1, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.botaoProximo)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                        .addComponent(this.jLabel4)));

        pack();
        setLocationRelativeTo(null);
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/iconeGUI.png")));
    }

    private void botaoProximoActionPerformed(ActionEvent evt) {
        String dataSLA = this.campoFormatadoData.getText();

        this.data = new Data();
        if (this.data.validarData(dataSLA) == true) {
            if (this.data.verificarDataSLA(dataSLA) == true) {
                this.telaPriorizacao = new PriorizacaoGUI();
                this.telaPriorizacao.setVisible(true);
            } else {
                this.telaCobranca = new CobrancaGUI();
                this.telaCobranca.setVisible(true);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Data/Horário inválidos");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SlaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SlaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SlaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SlaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SlaGUI().setVisible(true);
            }
        });
    }
}
