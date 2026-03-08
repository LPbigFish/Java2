package me.filip.stegner;

import cz.vsb.fei.java2.lab01text2asciiart.Text2AsciiArt;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class <b>App</b> - main class
 */
@Log4j2
public class App {
    static void main(String[] args) {
        log.info("Launching Java application.");

        boolean isCli = false;
        boolean isText = false;
        String inputText = "";

        if (args.length > 2) {
            log.error("Too many arguments");
            return;
        }
        for (String in : args) {
            if (in.equals("-cli") && !isText) {
                isCli = true;
                System.out.print("Insert the text: ");
                Scanner s = new Scanner(System.in);
                inputText = s.next();
                s.close();
                break;
            } else if (in.equals("-text")) {
                isText = true;
            } else if (isText) {
                inputText = in;
            } else {
                log.error("Wrong params!");
                return;
            }
        }

        try {
            System.out.println(new Text2AsciiArt().convert(inputText, "Big Money-sw"));
        } catch (Exception e) {
            log.error(e);
        }
    }
}