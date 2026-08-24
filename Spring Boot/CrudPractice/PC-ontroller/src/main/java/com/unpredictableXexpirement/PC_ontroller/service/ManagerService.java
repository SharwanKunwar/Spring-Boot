package com.unpredictableXexpirement.PC_ontroller.service;

import org.springframework.stereotype.Service;

@Service
public class ManagerService {


    // =========================
    // CHROME
    // =========================

    public String openChrome() {

        try {

            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder processBuilder;

            if (os.contains("win")) {

                processBuilder = new ProcessBuilder(
                        "cmd",
                        "/c",
                        "start",
                        "",
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


    // =========================
    // TERMINAL
    // =========================

    public String openTerminal() {

        try {

            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder processBuilder;

            if (os.contains("win")) {

                processBuilder = new ProcessBuilder(
                        "cmd",
                        "/c",
                        "start",
                        "cmd"
                );

            } else if (os.contains("mac")) {

                processBuilder = new ProcessBuilder(
                        "open",
                        "-a",
                        "Terminal"
                );

            } else if (os.contains("linux")) {

                processBuilder = new ProcessBuilder(
                        "x-terminal-emulator"
                );

            } else {

                return "Unsupported operating system";
            }

            processBuilder.start();

            return "Terminal opened successfully";

        } catch (Exception e) {

            return "Failed to open terminal: " + e.getMessage();
        }
    }


    // =========================
    // FILE MANAGER
    // =========================

    public String openFiles() {

        try {

            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder processBuilder;

            if (os.contains("win")) {

                processBuilder = new ProcessBuilder(
                        "explorer"
                );

            } else if (os.contains("mac")) {

                processBuilder = new ProcessBuilder(
                        "open",
                        "."
                );

            } else if (os.contains("linux")) {

                processBuilder = new ProcessBuilder(
                        "xdg-open",
                        "."
                );

            } else {

                return "Unsupported operating system";
            }

            processBuilder.start();

            return "File manager opened successfully";

        } catch (Exception e) {

            return "Failed to open file manager: " + e.getMessage();
        }
    }


    // =========================
    // TEXT EDITOR
    // =========================

    public String openEditor() {

        try {

            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder processBuilder;

            if (os.contains("win")) {

                processBuilder = new ProcessBuilder(
                        "notepad"
                );

            } else if (os.contains("mac")) {

                processBuilder = new ProcessBuilder(
                        "open",
                        "-a",
                        "TextEdit"
                );

            } else if (os.contains("linux")) {

                processBuilder = new ProcessBuilder(
                        "gedit"
                );

            } else {

                return "Unsupported operating system";
            }

            processBuilder.start();

            return "Text editor opened successfully";

        } catch (Exception e) {

            return "Failed to open text editor: " + e.getMessage();
        }
    }
}