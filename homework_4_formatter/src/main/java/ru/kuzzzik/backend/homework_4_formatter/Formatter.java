package ru.kuzzzik.backend.homework_4_formatter;

import java.io.*;
import java.util.*;

/**
 * Class to correct placement of brackets
 * @author kuzzzik (Kuzovleva Oksana)
 * @version 1.0
 */

public class Formatter {


    public static void main(String[] args) throws IOException {
        String readerCode = args[0];//input.java

        FileReader fReaderCode = new FileReader(readerCode);
        BufferedReader bReaderCode = new BufferedReader(fReaderCode);

        ArrayList<Character> list = new ArrayList<Character>();

        int i;
        while ((i = bReaderCode.read()) != -1) {
            list.add((char) i);
        }

        System.out.println(list);

            for (int p = 0; true; p++) {//удаляет и добавляет char в общем правильно, только в конце пишет ошибку
                if (list.get(p) == '{') {//Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 51, Size: 51
                    --p;                  //разве я вызожу за длинну?
                    if (list.get(p) != ' ') {
                        p++;
                        list.add(p, ' ');// добавляет пробел перед {
                        p += 2;
                    } else {
                        p += 2;
                    }

                    if (list.get(p) != '\n') {
                        list.add(p, '\n');// добавляет перенос после {

                    }
                }
                if (list.get(p) == '}') {
                    --p;
                    if (list.get(p) != '\n') {
                        p++;
                        list.add(p, '\n');// добавляет перенос перед }
                        p += 2;
                    } else {
                        p += 2;
                    }

                    if (list.get(p) != '\n') {
                        list.add(p, '\n');// добавляет перенос после }

                    }
                }
                if (list.get(p) == '(') {
                    --p;
                    if (list.get(p) != ' ') {
                        p++;
                        list.add(p, ' ');// добавляет пробел перед (
                        p += 2;
                    } else {
                        p += 2;
                    }

                    if (list.get(p) == ' ') {// убирает пробел после (
                        list.remove(p);
                        p++;
                    }

                }
                if (list.get(p) == ')') {
                    --p;
                    if (list.get(p) == ' ') {// убирает пробел перед (
                        list.remove(p);
                        p += 3;
                    } else {
                        p += 2;
                    }

                    if (list.get(p) != ' ') {
                        list.add(p, ' ');// добавляет пробел после (
                    }
                }
            }
        String writerCode = args[1];//output.java //Error:(101, 9) java: unreachable statement
                                                  //Error:(101, 9) java: unreachable statement

        FileWriter writeFormat = new FileWriter(writerCode);//не работает после for(что-то с видимостью?)
        BufferedWriter bWriterFormat = new BufferedWriter(writeFormat);

        for(int k = 0; true; k++)
        {
            bWriterFormat.write(list.get(k));// если воткнуть перед for, то пишет в файл, но неизмененное 
            bWriterFormat.flush();// после for не видят друг с друга с  BufferedWriter bWriterFormat
        }
        bWriterFormat.close();//catch (Exception e) подчеркивает
        bReaderCode.close();
    }//main

}
