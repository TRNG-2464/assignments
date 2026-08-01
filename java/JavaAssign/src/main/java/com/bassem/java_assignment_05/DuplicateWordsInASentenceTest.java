package com.bassem.java_assignment_05;

public class DuplicateWordsInASentenceTest {
    public static void main(String[] args){
        System.out.println("Test1: ");
        DuplicateWordsInASentence.countWords(
                "The time I went to the store I bought a watermelon"
        );

        System.out.println("\n Test2: ");
        DuplicateWordsInASentence.countWords(
                "Every word here is unique"
        );
    }
}
