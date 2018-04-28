package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        final Map<String, String> BADWORDS = new HashMap<>();
        BADWORDS.put("лось","лесное рогатое животное");
        BADWORDS.put("редиска","нехороший человек");

        System.out.println(replaceBadWord("Эй,ты,лось, как дела? Или ты просто редиска?Да, " +
                "скорее всего ты лось и редиска одновременно.", BADWORDS));


//	   System.out.println(search("Hello my heel lell loL",'l'));
    }
    public static String search(String string, char  simbol){
           if(string.contains(Character.toString(simbol)))
                    string  = string.replace(simbol, Character.toUpperCase(simbol));
            return string;
    }

    public static String replaceBadWord(String str, Map<String,String> badwords){
        List<String> allWords = new ArrayList();
        String word = new String();
        for (int i = 0; i < str.length(); i++){
             if(str.charAt(i)==' '||str.charAt(i)=='?'||str.charAt(i)=='.'||str.charAt(i)==','||str.charAt(i)=='!'){
                 allWords.add(word);
                 word = "";
                 continue;
             }
             word += Character.toString(str.charAt(i));
        }
        for (String aWord:allWords ) {
            str = str.replaceAll(aWord,badwords.get(aWord)==null?aWord:badwords.get(aWord));
        }
        return str;
    }
}
