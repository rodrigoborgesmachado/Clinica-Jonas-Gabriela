/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import View.Tela_Informacoes_View;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public abstract class Server_Subject {
    public abstract void registrar_Observador(Home_Broker_Observer o);
    public abstract void Notifica_Observador();    
}
