package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'k', 'l', 'o', 'o', 'l'},
                {'l', 'o', 'k', 'o', 'l'},
                {'k', 'o', 'o', 'l', 'k'},
        };
        detectAllWords(crossword, "kol","k").forEach(System.out::println);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordsList = new ArrayList<>();
        for (String word : words){
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == word.charAt(0)) {
                        Word word1;
                        if (word.length() == 1) {
                            word1 = new Word(word);
                            word1.setStartPoint(j,i);
                            word1.setEndPoint(j,i);
                            wordsList.add(word1);
                        }else for(Word word2 : wordSearch(crossword, word, j, i)) wordsList.add(word2);
                    }
                }
            }
        }
        return wordsList;
    }

    private static List<Word> wordSearch(int[][] crossword, String text, int startX, int startY){
        List<Word> words = new ArrayList<>();
        for (int count = 1; count < text.length();){
            if (0<=startY-count && crossword[startY-count][startX] == text.charAt(count)){
            } else break;
            if (count == text.length()-1) {
                Word word = new Word(text);
                word.setStartPoint(startX, startY);
                word.setEndPoint(startX,startY-count);
                words.add(word);
                break;
            } else count++;
        }
        for (int count = 1; count < text.length();){
            if (crossword.length>startY+count && crossword[startY+count][startX] == text.charAt(count)){
            } else break;
            if (count == text.length()-1) {
                Word word = new Word(text);
                word.setStartPoint(startX, startY);
                word.setEndPoint(startX,startY+count );
                words.add(word);
                break;
            } else count++;
        }
        for (int count = 1; count < text.length();){
            if (crossword[0].length > startX+count && crossword[startY][startX+count] == text.charAt(count)){
            } else break;
            if (count == text.length()-1) {
                Word word = new Word(text);
                word.setStartPoint(startX, startY);
                word.setEndPoint(startX+count,startY );
                words.add(word);
                break;
            } else count++;
        }
        for (int count = 1; count < text.length();){
            if (0 <= startX-count && crossword[startY][startX-count] == text.charAt(count)){
            } else break;
            if (count == text.length()-1) {
                Word word = new Word(text);
                word.setStartPoint(startX, startY);
                word.setEndPoint(startX-count,startY );
                words.add(word);
                break;
            } else count++;
        }
        for (int count = 1; count < text.length();){
            if (crossword.length>startY+count && crossword[0].length > startX+count && crossword[startY+count][startX+count] == text.charAt(count)){
            } else break;
            if (count == text.length()-1) {
                Word word = new Word(text);
                word.setStartPoint(startX, startY);
                word.setEndPoint(startX+count,startY+count );
                words.add(word);
                break;
            } else  count++;
        }
        for (int count = 1; count < text.length();){
            if (0<=startY-count && crossword[0].length > startX+count && crossword[startY-count][startX+count] == text.charAt(count)){
            } else break;
            if (count == text.length()-1) {
                Word word = new Word(text);
                word.setStartPoint(startX, startY);
                word.setEndPoint(startX+count,startY-count );
                words.add(word);
                break;
            } else count++;
        }
        for (int count = 1; count < text.length();){
            if (crossword.length>startY+count && 0 <= startX-count && crossword[startY+count][startX-count] == text.charAt(count)){
            } else break;
            if (count == text.length()-1) {
                Word word = new Word(text);
                word.setStartPoint(startX, startY);
                word.setEndPoint(startX-count,startY+count );
                words.add(word);
                break;
            } else count++;
        }
        for (int count = 1; count < text.length();){
            if (0<=startY-count && 0 <= startX-count && crossword[startY-count][startX-count] == text.charAt(count)){
            } else break;
            if (count == text.length()-1) {
                Word word = new Word(text);
                word.setStartPoint(startX, startY);
                word.setEndPoint(startX-count,startY-count );
                words.add(word);
                break;
            } else count++;
        }
        return words;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
