/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingwebservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.*;

/**
 *
 * @author evanc
 */
public class PingCommand {

    protected static void ping(String s) {
        ProcessBuilder procBuild = new ProcessBuilder();
        
        if(!isDigit(s) && !s.contains(".")){
            s += ".com";
        }
        

        String ping = "ping " + s;

        procBuild.command("cmd.exe", "/c", ping);

        try {
            Process process = procBuild.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("\nExited with Code " + exitCode);
            determine(exitCode); //Should I send the exit code back to main and determine there? 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void determine(int code) {
        if(code == 1){
            JOptionPane.showMessageDialog(null, "THIS SERVER IS NOT UP", "ERROR", 
				JOptionPane.WARNING_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "THIS SERVER IS UP", "SUCCESS", 
				JOptionPane.INFORMATION_MESSAGE);
        
        
        
//        if (code == 1) {
//            System.out.println("This server is down");
//        } else {
//            System.out.println("This server is up");
//        }

    }
    
    private static boolean isDigit(String s){
        return Character.isDigit(s.charAt(0));
    }

}
