package com.example.torconfig;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.IOException;

public class HelloController {

    public Button installTor;
    public Text isTorInstalled;
    public Button checkTor;

    @FXML
    void InstallTor() {
        //install tor on ubuntu
        try {
            String[] command = {"sudo", "apt-get", "update", "&&", "sudo", "apt-get", "install", "tor"};
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void CheckTor(ProcessBuilder processBuilder) throws IOException, InterruptedException {
        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Tor je nainstalován.");
            isTorInstalled.setText("Tor je nainstalován.");
        } else {
            System.out.println("Tor není nainstalován.");
            isTorInstalled.setText("Tor není nainstalován.");
        }
    }


    @FXML
    void checkIfTorInstalled() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("which", "tor");
            CheckTor(processBuilder);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}