package com.sparta.ja.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CleanerLogger {

    private static Logger logger = Logger.getLogger("DB cleaner logger");

    public static void setLoggerConfig() {
        try {
            Handler fileHandler = new FileHandler("src/main/java/com/sparta/ja/logging/CleanerLogs.log");
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.setLevel(Level.INFO);
    }

    public static Logger getLogger(){
        return logger;
    }
}
