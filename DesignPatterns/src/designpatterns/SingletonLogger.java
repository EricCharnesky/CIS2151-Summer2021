package designpatterns;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

// https://www.gofpatterns.com/design-patterns/module3/intro-singleton-design-pattern.php
public class SingletonLogger {

    private PrintWriter writer;

    private SingletonLogger() {
        try {
            // maybe use append mode next time?
            writer = new PrintWriter("log.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex); // this is bad
        }
    }

    public void log(String message) {
        writer.print(message);
        writer.flush();
    }

    public static SingletonLogger getInstance() {
        return instance;
    }

    private static SingletonLogger instance = new SingletonLogger();
}
