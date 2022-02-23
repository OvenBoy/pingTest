/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingwebservice;
import java.io.*;
import java.util.*;

/**
 *
 * @author evanc
 */
public class PingWebService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        System.out.println("Enter address to be pinged: ");
        String ping = kb.nextLine();
        
        
        PingCommand.ping(ping);
        
        
        
        
        
        
        // Ping web service
        // Retrieve response
        // Interpurt the response
    }
    
}
