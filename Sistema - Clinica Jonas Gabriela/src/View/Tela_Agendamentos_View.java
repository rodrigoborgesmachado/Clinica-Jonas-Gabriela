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
public class Tela_Agendamentos_View extends javax.swing.JInternalFrame {
    public ArrayList Noticias = new ArrayList<String>();
    private ArrayList medico;
    public String[] medicoSel;
    public void ZeraNoticias(){
        this.Noticias.clear();
        this.AtualizaDados();
    }
    public void setNoticias(String c){
        this.Noticias.add(c);
        this.AtualizaDados();
    }
    public String getNoticias(int i){
        return (String) this.Noticias.get(i);
    }
    /**
     * Creates new form Tela_Cadastro_Funcionarios_View
     */
    public String[] setComboBoxMedica(){
        this.medicoSel=null;
        this.medicoSel = new String[medico.size()];
        this.Combo_Box_Medica.removeAllItems();
        for(int i=0;i<medico.size();i++){
            this.medicoSel[i]= new String((String)this.medico.get(i));
            this.Combo_Box_Medica.addItem(this.medicoSel[i]);
        }
        
        return medicoSel;
    }
    public String getMedico(){
        return this.medicoSel[this.Combo_Box_Medica.getSelectedIndex()];
    }
    public void setMedico(ArrayList medico) {
        this.medico = medico;
        this.setComboBoxMedica();
    }
    public Tela_Agendamentos_View() {        
        this.setIcon();
        this.medico = new ArrayList<String>();
        initComponents();
    }
    public void setIcon(){
        initComponents();
         setFrameIcon(new ImageIcon(this.getClass().getResource("../Imagens/princ.png")));
    }
    public void AtualizaDados(){
        Lista_Informacoes.setModel(new javax.swing.AbstractListModel() {
            public int getSize() {
                return Noticias.size();
            }
            public Object getElementAt(int i){
                return Noticias.get(i);
            }
        });
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
        Lista_Informacoes = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        Combo_Box_Medica = new javax.swing.JComboBox();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(960, 610));
        setMinimumSize(new java.awt.Dimension(960, 610));
        setPreferredSize(new java.awt.Dimension(960, 610));
        setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel1.setText("Agendamentos:");

        Button_Sair.setText("Sair");
        Button_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SairActionPerformed(evt);
            }
        });

        Lista_Informacoes.setBackground(new java.awt.Color(240, 240, 240));
        Lista_Informacoes.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        Lista_Informacoes.setModel(new javax.swing.AbstractListModel() {
            public int getSize() {
                return Noticias.size();
            }
            public Object getElementAt(int i){
                return Noticias.get(i);
            }
        });
        jScrollPane1.setViewportView(Lista_Informacoes);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel2.setText("Médico:");

        Combo_Box_Medica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Combo_Box_Medica.setModel(new javax.swing.DefaultComboBoxModel());
        Combo_Box_Medica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_Box_MedicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Combo_Box_Medica, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Sair))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_Sair)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Combo_Box_Medica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void Button_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_SairActionPerformed

    private void Combo_Box_MedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_Box_MedicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_Box_MedicaActionPerformed
    public void Combo_Box_MedicaActionPerformed(ActionListener evt) {                                                 
        Combo_Box_Medica.addActionListener(evt);
    }
    public void Button_SairActionListener(ActionListener evt) {                                                 
        Button_Sair.addActionListener(evt);
    }  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Sair;
    private javax.swing.JComboBox Combo_Box_Medica;
    private javax.swing.JList Lista_Informacoes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
