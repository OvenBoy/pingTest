/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingwebservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author evanc
 */
public class PingCommand {

    protected static void ping(String s) {
        ProcessBuilder procBuild = new ProcessBuilder();

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
            determine(exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void determine(int code) {
        if (code == 1) {
            System.out.println("This server is down");
        } else {
            System.out.println("This server is up");
        }

    }

}
