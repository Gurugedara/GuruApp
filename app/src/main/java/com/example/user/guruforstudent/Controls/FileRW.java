package com.example.user.guruforstudent.Controls;
import java.io.*;
import java.util.*;
/**
 * Created by USER on 9/3/2018.
 */

public class FileRW {
         String username;
         public FileRW(String username){
             this.username = username;
         }
         public FileRW(){}


    public void write() {
        //String text = "Hello world";
        BufferedWriter output = null;
        try {
            File file = new File("C:\\Users\\USER\\GuruforStudent\\app\\src\\main\\java\\com\\example\\user\\guruforstudent\\Controls\\temp.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(username);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void clearTheFile() {
        FileWriter fwOb = null;
        try {
            fwOb = new FileWriter("C:\\Users\\USER\\GuruforStudent\\app\\src\\main\\java\\com\\example\\user\\guruforstudent\\Controls\\temp.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String Read() {
        //this.username = username;


            // The name of the file to open.
            String fileName = "C:\\Users\\USER\\GuruforStudent\\app\\src\\main\\java\\com\\example\\user\\guruforstudent\\Controls\\temp.txt";

            // This will reference one line at a time
            String line = null;

            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader =
                        new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                // Always close files.
                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                fileName + "'");
            }
            catch(IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }
         return line;
        }
    }






