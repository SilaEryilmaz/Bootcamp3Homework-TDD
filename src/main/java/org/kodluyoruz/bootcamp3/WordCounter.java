package org.kodluyoruz.bootcamp3;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args){
        String str = "Cho'Gath,is.a,Cho'Gath right ? !";
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(str);
        HashMap<String, Integer> hm = new HashMap<>();
        while (m.find())
        {
            String word = m.group();
            if(!hm.containsKey(word)){ hm.put(word, 1);}
            else { hm.put(word, hm.get(word) + 1); }
        }
        System.out.println(String.format("Has %s unique words !", hm.size()));
    }
}
