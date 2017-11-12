package ru.kuzzzik.formatter;

import java.util.ArrayList;

public class FormatterMy{
    private ArrayList<Character> listArray;;

    public FormatterMy(ArrayList<Character> listArray) {
        this.listArray = listArray;
    }


    public void formatArr() throws Exception{
        for (int p = 0; p < listArray.size(); p++) {

            FormatterMy.Inner inner = new FormatterMy(listArray).new Inner();

            inner.bracketCurlOpen(listArray, p);// проверяем {
            inner.bracketCurlClose(listArray, p);// проверяем }
            inner.bracketOpen(listArray, p);// проверяем (
            inner.bracketClose(listArray, p);// проверяем )
        }
    }

    private class Inner {
        /**
         * method checks the placement of opening curly brackets, fixes
         *
         * @param listArray from ArrayList
         * @param p    the element number of the array
         */
        void bracketCurlOpen(ArrayList<Character> listArray, int p) {
            if (listArray.get(p) == '{') {
                --p;
                if (listArray.get(p) != ' ') {
                    p++;
                    listArray.add(p, ' ');// добавляет пробел перед {
                    p += 2;
                } else {
                    p += 2;
                }

                if (listArray.get(p) != '\n') {
                    listArray.add(p, '\n');// добавляет перенос после {

                }
            }
        }

        /**
         * method checks the placement of closed curly brackets, fixes
         *
         * @param listArray from ArrayList
         * @param p    the element number of the array
         */
        void bracketCurlClose(ArrayList<Character> listArray, int p) {
            if (listArray.get(p) == '}') {
                --p;
                if (listArray.get(p) != '\n') {
                    p++;
                    listArray.add(p, '\n');// добавляет перенос перед }
                    p += 2;
                } else {
                    p += 2;
                }

                if (listArray.get(p) != '\n') {
                    listArray.add(p, '\n');// добавляет перенос после }

                }
            }
        }

        /**
         * method checks the placement of opened brackets, fixes
         *
         * @param listArray from ArrayList
         * @param p    the element number of the array
         */
        void bracketOpen(ArrayList<Character> listArray, int p) {
            if (listArray.get(p) == '(') {
                --p;
                if (listArray.get(p) != ' ') {
                    p++;
                    listArray.add(p, ' ');// добавляет пробел перед (
                    p += 2;
                } else {
                    p += 2;
                }

                if (listArray.get(p) == ' ') {// убирает пробел после (
                    listArray.remove(p);
                }

            }
        }

        /**
         * method checks the placement of closed brackets, fixes
         *
         * @param listArray from ArrayList
         * @param p    the element number of the array
         */
        void bracketClose(ArrayList<Character> listArray, int p) {
            if (listArray.get(p) == ')') {
                --p;
                if (listArray.get(p) == ' ') {// убирает пробел перед (
                    listArray.remove(p);

                } else {
                    p += 1;
                }
                p++;
                if (listArray.get(p) != ' ') {
                    listArray.add(p, ' ');// добавляет пробел после (
                }
            }
        }
    }

    }


















