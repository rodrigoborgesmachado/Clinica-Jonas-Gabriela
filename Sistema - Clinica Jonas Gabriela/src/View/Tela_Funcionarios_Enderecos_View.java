/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Pessoa.Pessoa_Generica;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.lang.String;
import javax.swing.ImageIcon;

/**
 *
 * @author Rodrigo
 */
public class Tela_Funcionarios_Enderecos_View extends javax.swing.JInternalFrame {
    public ArrayList Noticias = new ArrayList<String>();
    
    public void setNoticias(String c){
        this.Noticias.add(c);
    }
    public String getNoticias(int i){
        return (String) this.Noticias.get(i);
    }
    /**
     * Creates new form Tela_Cadastro_Funcionarios_View
     */
    public Tela_Funcionarios_Enderecos_View() {        
        this.setIcon();
        initComponents();
    }
    public void setIcon(){
        initComponents();
         setFrameIcon(new ImageIcon(this.getClass().getResource("../Imagens/princ.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        Button_Sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(960, 610));
        setMinimumSize(new java.awt.Dimension(960, 610));
        setPreferredSize(new java.awt.Dimension(960, 610));
        setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel1.setText("Endereços:");

        Button_Sair.setText("Sair");
        Button_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SairActionPerformed(evt);
            }
        });

        jList1.setBackground(new java.awt.Color(240, 240, 240));
        jList1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() {
                return Noticias.size();
            }
            public Object getElementAt(int i){
                return Noticias.get(i);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Sair))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Button_Sair))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void Button_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_SairActionPerformed
    public void Button_SairActionListener(ActionListener evt) {                                                 
        Button_Sair.addActionListener(evt);
    }  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Sair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
