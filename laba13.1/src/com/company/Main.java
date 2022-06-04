package com.company;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Main {

    public static void main(String[] a) {
        String readFile = readFile();
        String writerFile = readFile.replaceAll("/\\*(?:[^*]|\\*+[^*/])*\\*+/|//.*", "");
        Path path = Paths.get("Testcode");
        try {
            Files.writeString(path, writerFile, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error"+ ex);
        }

    }

    static String readFile() {
        File file = new File("Testcode");
        char[] buffer = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            buffer = new char[(int) file.length()];
            int i = 0;
            int read = bufferedReader.read();
            while (read != -1) {
                buffer[i++] = (char) read;
                read = bufferedReader.read();
            }
        } catch (IOException e) {
            System.out.println("Error"+ e);
        }
        return new String(buffer);
    }
}




