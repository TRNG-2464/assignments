package com.bassem.java_assignment_05;
import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicateWordsInASentence {

    public static void countWords(String sentence){

        LinkedHashMap<String,Integer> wordCount =new LinkedHashMap<>();

       String[] words = sentence.split(" ");

       for(String w:words){

           w = w.toLowerCase();

           if (wordCount.containsKey(w)) {

               wordCount.put(w, wordCount.get(w)+1);
           }
           else {
               wordCount.put(w, 1);
           }
       }
       boolean firstOccur = true;
       for(Map.Entry<String,Integer>entry :wordCount.entrySet()){
           String word = entry.getKey();
           int count = entry.getValue();
           if(!firstOccur){
               System.out.print(", ");


           }
           System.out.print(word+ "- " + count);
           firstOccur = false;
       }
    }
}
