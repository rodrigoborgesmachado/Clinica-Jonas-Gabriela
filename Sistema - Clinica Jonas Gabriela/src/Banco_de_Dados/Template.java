/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco_de_Dados;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public abstract class Template implements Strategy{
    private static volatile Connection instancia;
      private static String Usuario;
      private static String Ip;
      private static String Banco;
      private static String Senha;
      private static int type=2;
      public static Connection GetInstance(){
          
          return Template.GetInformation();
      }

    /**
     * @return the Ip
     */
    public static String getIp() {
        return Ip;
    }

    /**
     * @param aIp the Ip to set
     */
    public static void setIp(String aIp) {
        Ip = aIp;
    }
    static Connection GetInformation() {
        BufferedReader reader = null;
        Connection Conexao;
        boolean start=true;
        char tipo;
        int i, j;
        String caminho="", host="";
        try {
           reader = new BufferedReader(new InputStreamReader(new FileInputStream("Arquivo.txt")));
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Arquivo não encontrado!");
        }
        try {
            caminho = reader.readLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "O banco de dados não foi configurado, configurar!");
            start = false;
        }
        
        if(start){
            j=caminho.length()-1;
            tipo=(char)caminho.charAt(j);
            if(tipo == '1'){
                try {
                    Template.type=1;
                    caminho = reader.readLine();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "O banco de dados não foi configurado, configurar!");
                }
                i=0;
                while(caminho.charAt(i)!='=')i++;
                for(i++;i<caminho.length();i++){
                    host+=caminho.charAt(i);
                }
                Singleton_Connection_Banco_SQLite.setIp(host);
                return Singleton_Connection_Banco_SQLite.GetInstance();
            }
            else{
                Template.type=2;
                Template.setBanco("2359910_jonasgabriela");
                Template.setIp("localhost");
                Template.setUsuario("root");
                Template.setSenha("");
                
                return Singleton_Connection_Banco_Mysql.GetInstance();
            }
        }
        try {
            reader.close();
        } catch (IOException ex) {
        }
        return null;
    }

    /**
     * @return the instancia
     */
    public static Connection getInstancia() {
        return instancia;
    }

    /**
     * @param aInstancia the instancia to set
     */
    public static void setInstancia(Connection aInstancia) {
        instancia = aInstancia;
    }

    /**
     * @return the Usuario
     */
    public static String getUsuario() {
        return Usuario;
    }

    /**
     * @param aUsuario the Usuario to set
     */
    public static void setUsuario(String aUsuario) {
        Usuario = aUsuario;
    }

    /**
     * @return the Banco
     */
    public static String getBanco() {
        return Banco;
    }

    /**
     * @param aBanco the Banco to set
     */
    public static void setBanco(String aBanco) {
        Banco = aBanco;
    }

    /**
     * @return the Senha
     */
    public static String getSenha() {
        return Senha;
    }

    /**
     * @param aSenha the Senha to set
     */
    public static void setSenha(String aSenha) {
        Senha = aSenha;
    }
    static Strategy estrategia;
    public static void Criar_Banco() throws SQLException {
        if(Template.type == 1){
           Template.estrategia = new Criar_SQLite(); 
        }
        else{
            Template.estrategia = new Criar_Mysql(); 
        }
    }
}
