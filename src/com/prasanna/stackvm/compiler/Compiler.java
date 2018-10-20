package com.prasanna.stackvm.compiler;

import java.util.ArrayList;

public class Compiler {

    public static ExecutableObject compile(String filename) {
        try{
            ArrayList<String> lines = new ReadFile(filename).getFileStream();
            Parser parser = new Parser(lines);
            parser.getInstructions();

            return  parser.getExecutableObjet();

        }catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
