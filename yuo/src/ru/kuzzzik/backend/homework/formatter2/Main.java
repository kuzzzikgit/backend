package ru.kuzzzik.backend.homework.formatter2;
import java.io.*;
import java.util.*;

/**
 * Class to correct placement of brackets
 * @author kuzzzik (Kuzovleva Oksana)
 * @version 1.0
 */

public class Main {


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

    }//main

}
