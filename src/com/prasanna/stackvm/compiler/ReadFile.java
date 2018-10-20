package com.prasanna.stackvm.compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import  java.io.*;
import java.util.ArrayList;


//reads the file supplied as parameter and returns stream of lines
public class ReadFile {

    String fname;
    File file;

    public ReadFile(String fname) throws IOException{
        this.fname = fname;
        file = new File(fname);
    }

    public ArrayList<String> getFileStream() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            ArrayList<String> lines = new ArrayList<>();

            String line;
            while((line = reader.readLine()) != null) lines.add(line);

            return lines;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}