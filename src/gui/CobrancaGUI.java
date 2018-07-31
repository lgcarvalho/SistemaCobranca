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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CobrancaGUI
        extends JFrame {

    private CobrancaInfoGUI telaCobrancaInfo;
    private RespostaGUI telaResposta;
    private JRadioButton botaoGrupoNao;
    private JRadioButton botaoGrupoSim;
    private JButton botaoProximo;
    private ButtonGroup grupoPriorizacao;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public CobrancaGUI() {
        initComponents();

        setIcon();
    }

    private void initComponents() {
        this.grupoPriorizacao = new ButtonGroup();
        this.jPanel2 = new JPanel();
        this.jLabel2 = new JLabel();
        this.botaoGrupoSim = new JRadioButton();
        this.botaoGrupoNao = new JRadioButton();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.botaoProximo = new JButton();
        this.jLabel4 = new JLabel();

        setDefaultCloseOperation(3);
        setTitle("SIPRIC - Sistema de Prioridade e Cobrança");
        setResizable(false);

        this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Verificar ultima cobrança", 2, 0, new Font("Tahoma", 1, 11)));

        this.jLabel2.setText("Houve a troca do grupo responsvel?");

        this.grupoPriorizacao.add(this.botaoGrupoSim);
        this.botaoGrupoSim.setText("Sim");
        this.botaoGrupoSim.setFocusPainted(false);
        this.botaoGrupoSim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CobrancaGUI.this.botaoGrupoSimActionPerformed(evt);
            }
        });
        this.grupoPriorizacao.add(this.botaoGrupoNao);
        this.botaoGrupoNao.setText("Não");
        this.botaoGrupoNao.setFocusPainted(false);
        this.botaoGrupoNao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CobrancaGUI.this.botaoGrupoNaoActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Tahoma", 0, 10));
        this.jLabel1.setForeground(new Color(255, 0, 51));
        this.jLabel1.setText("Obs.: Verificar se houve a troca do Grupo Proprietário após");

        this.jLabel3.setFont(new Font("Tahoma", 0, 10));
        this.jLabel3.setForeground(new Color(255, 0, 51));
        this.jLabel3.setText("ter sido realizado uma cobrança no chamado.");

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jLabel1)
                                .addComponent(this.jLabel3))
                        .addContainerGap(-1, 32767)));

        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jLabel3)
                        .addContainerGap(-1, 32767)));

        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.botaoGrupoSim)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.botaoGrupoNao)
                        .addContainerGap())
                .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -2, -1, -2));

        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(11, 32767)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel2)
                                .addComponent(this.botaoGrupoSim)
                                .addComponent(this.botaoGrupoNao))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jPanel1, -2, -1, -2)));

        this.botaoProximo.setText("Próximo");
        this.botaoProximo.setEnabled(false);
        this.botaoProximo.setFocusPainted(false);
        this.botaoProximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CobrancaGUI.this.botaoProximoActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(this.jPanel2, -1, -1, 32767)
                                .addComponent(this.botaoProximo, -1, -1, 32767))
                        .addContainerGap(-1, 32767))
                .addComponent(this.jLabel4, -1, -1, 32767));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jPanel2, -2, -1, -2)
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
        this.telaCobrancaInfo = new CobrancaInfoGUI();
        this.telaResposta = new RespostaGUI();
        if (this.botaoGrupoSim.isSelected()) {
            this.telaResposta.campoHorasUteis.setEnabled(false);
            this.telaResposta.campoTipoComunicacao.setText("1ª Cobrança");
            this.telaResposta.campoModeloComunicacao.setText("COBSTATUSATA1");
            this.telaResposta.areaAcaoEfetuada.setText("Enviar e-mail para os analistas da fila de atendimento");
            this.telaResposta.campoCoordenador.setEnabled(false);
            this.telaResposta.campoGerente.setEnabled(false);
            this.telaResposta.campoGrupoProprietario.setEnabled(false);
            this.telaResposta.botaoVoltar.setEnabled(false);
            this.telaResposta.setVisible(true);
            dispose();
        } else {
            this.telaCobrancaInfo.setVisible(true);
            dispose();
        }
    }

    private void botaoGrupoSimActionPerformed(ActionEvent evt) {
        this.botaoProximo.setEnabled(true);
    }

    private void botaoGrupoNaoActionPerformed(ActionEvent evt) {
        this.botaoProximo.setEnabled(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CobrancaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CobrancaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CobrancaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CobrancaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CobrancaGUI().setVisible(true);
            }
        });
    }
}
