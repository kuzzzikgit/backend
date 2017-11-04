package ru.kuzzzik.backend.homework.formatter2;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        String readerCode = args[0];//input.java
        String writerCode = args[1];//output.java

        FileReader fReaderCode = new FileReader(readerCode);
        BufferedReader bReaderCode = new BufferedReader(fReaderCode);

        FileWriter writeFormat = new FileWriter(writerCode);
        BufferedWriter bWriterFormat = new BufferedWriter(writeFormat);

        List<Character> chars = new ArrayList<>();// не дает добавлять/удалять char (только заменять)
        List<Character> linkedList = new LinkedList<>();//получается пустой

        int i;
        while ((i = bReaderCode.read()) != -1) {
            chars.add((char) i);
        }

        int w;
        while ((w = bReaderCode.read()) != -1) {
            linkedList.add((char) w);
        }

        System.out.println(chars);
        System.out.println(linkedList);
    }

}

