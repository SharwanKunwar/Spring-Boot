package com.unpredictableXexpirement.PC_ontroller.service;

import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    public String openChrome() {

        try {

            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder processBuilder;

            if (os.contains("win")) {

                processBuilder = new ProcessBuilder(
                        "cmd",
                        "/c",
                        "start",
                        "chrome"
                );

            } else if (os.contains("mac")) {

                processBuilder = new ProcessBuilder(
                        "open",
                        "-a",
                        "Google Chrome"
                );

            } else if (os.contains("linux")) {

                processBuilder = new ProcessBuilder(
                        "google-chrome"
                );

            } else {

                return "Unsupported operating system";
            }

            processBuilder.start();

            return "Chrome opened successfully";

        } catch (Exception e) {

            return "Failed to open Chrome: " + e.getMessage();
        }
    }
}