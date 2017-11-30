/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.Tela_Informacoes_Control;
import Models.Tela_Informacoes_Model;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Notebook
 */
public class Tela_Principal_View extends javax.swing.JFrame {
    /**
     * Creates new form TelaLogin
     */
    private BufferedImage img;
    private BufferedImage img2;
    private Tela_Informacoes_Model model = new Tela_Informacoes_Model();
    private Tela_Informacoes_View view = new Tela_Informacoes_View();
    private Tela_Informacoes_Control control = new Tela_Informacoes_Control((Tela_Informacoes_View)getView(), model);
    public Tela_Principal_View(){
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIcon();
        //jFrame.setUndecorated(true); //apaga o menu inicial
        this.initComponents();
        Desktop_Panel_Informacoes.add(view);
        view.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        try {     
            img2 = ImageIO.read(new File("src/Imagens/fundo-2.png"));
        }
        catch (Exception ex) {
            ex.printStackTrace(); 
        }
        Desktop_Panel_Informacoes = new javax.swing.JDesktopPane(){   
            @Override     
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);         
                //grphcs.drawImage(img,  img.getWidth(), img.getHeight(), null);
                grphcs.drawImage(img2, 0, 0, getWidth(), getHeight(), null);
            }      
            @Override 
            public Dimension getPreferredSize()
            {        
                return new Dimension(img2.getWidth(), img2.getHeight());
            } 
        };
        setExtendedState( MAXIMIZED_BOTH ); 
        try {     
            img = ImageIO.read(new File("src/Imagens/azul.png"));
        }
        catch (Exception ex) {
            ex.printStackTrace(); 
        }
        Desktop_Panel_Telas = new javax.swing.JDesktopPane(){   
            @Override     
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);         
                //grphcs.drawImage(img,  img.getWidth(), img.getHeight(), null);
                grphcs.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }      
            @Override 
            public Dimension getPreferredSize()
            {        
                return new Dimension(img.getWidth(), img.getHeight());
            } 
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Opcao_Cadastrar_Funcionario = new javax.swing.JMenuItem();
        Opcao_Funcionarios_Cadastrados = new javax.swing.JMenuItem();
        Opcao_Funcionarios_Enderecos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Opcao_Agendar_Consulta = new javax.swing.JMenuItem();
        Opcao_Consultas_Agendadas = new javax.swing.JMenuItem();
        Opcao_Pagar_Consulta = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Opcao_Realizar_Consulta = new javax.swing.JMenuItem();
        Opcao_Verificar_Consultas = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jonas Gabriela");
        setBackground(new java.awt.Color(77, 10, 158));
        setFocusable(false);
        setForeground(new java.awt.Color(77, 10, 158));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setName("Janela_Principal"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Desktop_Panel_Informacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 710));

        Desktop_Panel_Telas.setBackground(new java.awt.Color(240, 240, 240));
        Desktop_Panel_Telas.setMaximumSize(new java.awt.Dimension(960, 610));
        Desktop_Panel_Telas.setMinimumSize(new java.awt.Dimension(960, 610));
        getContentPane().add(Desktop_Panel_Telas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 1040, 680));

        jMenu1.setText("Funcionários");

        Opcao_Cadastrar_Funcionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Opcao_Cadastrar_Funcionario.setText("Cadastrar Funcionário");
        Opcao_Cadastrar_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcao_Cadastrar_FuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(Opcao_Cadastrar_Funcionario);

        Opcao_Funcionarios_Cadastrados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Opcao_Funcionarios_Cadastrados.setText("Funcionários Cadastrados");
        Opcao_Funcionarios_Cadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcao_Funcionarios_CadastradosActionPerformed(evt);
            }
        });
        jMenu1.add(Opcao_Funcionarios_Cadastrados);

        Opcao_Funcionarios_Enderecos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Opcao_Funcionarios_Enderecos.setText("Endereco dos Funcionarios");
        Opcao_Funcionarios_Enderecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcao_Funcionarios_EnderecosActionPerformed(evt);
            }
        });
        jMenu1.add(Opcao_Funcionarios_Enderecos);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Consultas");

        Opcao_Agendar_Consulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Opcao_Agendar_Consulta.setText("Agendar Consulta");
        Opcao_Agendar_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcao_Agendar_ConsultaActionPerformed(evt);
            }
        });
        jMenu4.add(Opcao_Agendar_Consulta);

        Opcao_Consultas_Agendadas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        Opcao_Consultas_Agendadas.setText("Consultas Agendadas");
        Opcao_Consultas_Agendadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcao_Consultas_AgendadasActionPerformed(evt);
            }
        });
        jMenu4.add(Opcao_Consultas_Agendadas);

        Opcao_Pagar_Consulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Opcao_Pagar_Consulta.setText("Pagar Consultas");
        Opcao_Pagar_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcao_Pagar_ConsultaActionPerformed(evt);
            }
        });
        jMenu4.add(Opcao_Pagar_Consulta);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Atendimento");

        Opcao_Realizar_Consulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Opcao_Realizar_Consulta.setText("Realizar Consulta");
        Opcao_Realizar_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcao_Realizar_ConsultaActionPerformed(evt);
            }
        });
        jMenu5.add(Opcao_Realizar_Consulta);

        Opcao_Verificar_Consultas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        Opcao_Verificar_Consultas.setText("Verificar Consultas");
        Opcao_Verificar_Consultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcao_Verificar_ConsultasActionPerformed(evt);
            }
        });
        jMenu5.add(Opcao_Verificar_Consultas);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1426, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Opcao_Cadastrar_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcao_Cadastrar_FuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opcao_Cadastrar_FuncionarioActionPerformed

    private void Opcao_Funcionarios_CadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcao_Funcionarios_CadastradosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opcao_Funcionarios_CadastradosActionPerformed

    private void Opcao_Funcionarios_EnderecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcao_Funcionarios_EnderecosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opcao_Funcionarios_EnderecosActionPerformed

    private void Opcao_Agendar_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcao_Agendar_ConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opcao_Agendar_ConsultaActionPerformed

    private void Opcao_Consultas_AgendadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcao_Consultas_AgendadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opcao_Consultas_AgendadasActionPerformed

    private void Opcao_Pagar_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcao_Pagar_ConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opcao_Pagar_ConsultaActionPerformed

    private void Opcao_Realizar_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcao_Realizar_ConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opcao_Realizar_ConsultaActionPerformed

    private void Opcao_Verificar_ConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcao_Verificar_ConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opcao_Verificar_ConsultasActionPerformed
    public void Opcao_Verificar_ConsultasActionPerformed(ActionListener evt) {                                                          
        this.Opcao_Verificar_Consultas.addActionListener(evt);
    }
    public void Opcao_Realizar_ConsultaActionPerformed(ActionListener evt) {                                                        
        this.Opcao_Realizar_Consulta.addActionListener(evt);
    } 
    public void Opcao_Pagar_ConsultaActionPerformed(ActionListener evt) {                                                     
        this.Opcao_Pagar_Consulta.addActionListener(evt);
    }   
    public void Opcao_Consultas_AgendadasActionPerformed(ActionListener evt) {                                                          
        this.Opcao_Consultas_Agendadas.addActionListener(evt);
    }
    public void Opcao_Agendar_ConsultaActionPerformed(ActionListener evt) {                                                       
        this.Opcao_Agendar_Consulta.addActionListener(evt);
    }
    public void Opcao_Cadastrar_FuncionarioActionListener(ActionListener evt) {                                             
        this.Opcao_Cadastrar_Funcionario.addActionListener(evt);
    }
    public void Opcao_Funcionarios_CadastradosActionListener(ActionListener evt) {                                             
        this.Opcao_Funcionarios_Cadastrados.addActionListener(evt);
    }
    public void Opcao_Funcionarios_EnderecosActionListener(ActionListener evt) {                                             
        this.Opcao_Funcionarios_Enderecos.addActionListener(evt);
    }   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Principal_View().setVisible(true);
            }
        });
    }
    
    public void Adicione_Telas(JInternalFrame obj){
        this.Desktop_Panel_Telas.add(obj);
        obj.setAlignmentX(100);
        obj.setAlignmentY(100);
        obj.setLocation(20, 30);
        obj.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop_Panel_Informacoes;
    private javax.swing.JDesktopPane Desktop_Panel_Telas;
    private javax.swing.JMenuItem Opcao_Agendar_Consulta;
    private javax.swing.JMenuItem Opcao_Cadastrar_Funcionario;
    private javax.swing.JMenuItem Opcao_Consultas_Agendadas;
    private javax.swing.JMenuItem Opcao_Funcionarios_Cadastrados;
    private javax.swing.JMenuItem Opcao_Funcionarios_Enderecos;
    private javax.swing.JMenuItem Opcao_Pagar_Consulta;
    private javax.swing.JMenuItem Opcao_Realizar_Consulta;
    private javax.swing.JMenuItem Opcao_Verificar_Consultas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Imagens/icon.png")));
    }

    /**
     * @return the view
     */
    public Tela_Informacoes_View getView() {
        return view;
    }
    public Tela_Informacoes_Control getControl() {
        return control;
    }
}
