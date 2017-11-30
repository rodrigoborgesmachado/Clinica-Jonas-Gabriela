/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco_de_Dados;
import Models.Tela_Login_Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Singleton_Connection_Banco_Mysql extends Template{
      
    private Singleton_Connection_Banco_Mysql(){}
    public static Connection GetInstance(){
        //Singleton_Connection_Banco_Mysql.GetInformation();
        if(Singleton_Connection_Banco_Mysql.getInstancia()==null){
            synchronized (Singleton_Connection_Banco_Mysql.class){
                if(Singleton_Connection_Banco_Mysql.getInstancia() == null){
                    try {
                        //iniciando o Singleton
                       
                        Singleton_Connection_Banco_Mysql.setInstancia(DriverManager.getConnection("jdbc:mysql://"+Template.getIp()+"/" + Template.getBanco() + "", Template.getUsuario(), Template.getSenha()));
                            String sql="select count(table_name) as pe FROM INFORMATION_SCHEMA.TABLES WHERE table_name like 'agenda'";
                        try {
                            Connection instancia = Singleton_Connection_Banco_Mysql.getInstancia();
                            instancia.setAutoCommit(true);
                            PreparedStatement stm= instancia.prepareStatement(sql);
                            
                            stm.executeQuery();
                            ResultSet results=stm.getResultSet();
                            if(results.next()){
                                int temp=results.getInt("pe");
                                if(temp <1){
                                    Template.Criar_Banco();
                                    System.out.println("Banco de dados criado");
                                }
                                else{
                                    System.out.println("Banco de dados existe");
                                }
                                stm.close();
                            }
                            else{
                                stm.close();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //JOptionPane.showMessageDialog(null, "Conectado com o banco de dados!");
                    }                    
                    catch (SQLException e) {
                        
                        JOptionPane.showMessageDialog(null, "Sem conexão com o banco de dados! Erro SQL");
                        System.exit(-1);
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Sem conexão com o banco de dados! Erro");
                        System.exit(-1);
                    }
                }
            }
        }
        return Singleton_Connection_Banco_Mysql.getInstancia();
    }

    
}
