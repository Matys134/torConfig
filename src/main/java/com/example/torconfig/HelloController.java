package com.example.torconfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private Button checkTor;

    @FXML
    private Button installTor;

    @FXML
    private Text isTorInstalled;

    @FXML
    void checkIfTorInstalled(ActionEvent event) {
        try {
            Process process = Runtime.getRuntime().exec("dkpg -l | grep tor");
            process.waitFor();
            int exitCode = process.exitValue();

            if (exitCode == 0) {
                isTorInstalled.setText("Tor is installed");
            } else {
                isTorInstalled.setText("Tor is not installed");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @FXML
    void installTor(ActionEvent event) {
        try {
            Process process = Runtime.getRuntime().exec("sudo apt-get install tor");
            process.waitFor();
            int exitCode = process.exitValue();

            if (exitCode == 0) {
                isTorInstalled.setText("Tor is installed");
            } else {
                isTorInstalled.setText("Tor is not installed");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
