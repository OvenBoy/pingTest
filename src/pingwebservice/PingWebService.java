/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingwebservice;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author evanc
 */
public class PingWebService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ping = JOptionPane.showInputDialog("Please input a server"); //could check if string "google" has no ".com" then add
        
        /**
         * Known Problems:
         * Blows up if no text is input to start
         * ONLY adds .com
         * Very slow because of 4 time CMD ping
         */
        
        PingCommand.ping(ping);
       
    }
    
}
