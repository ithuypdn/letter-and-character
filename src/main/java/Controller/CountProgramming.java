/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Library;
import View.Menu;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;


/**
 *
 * @author huypd
 */
public class CountProgramming extends Menu<String> {
     static String[] mc = {"Letter and Charator Count", "Convert base number", "Exit"};
    String str;
    Library l;

    public CountProgramming() {
        super("PROGRAMMING", mc);
        l = new Library();
        str = l.getString("Enter your content: ");
    }
    
    public void execute(int n) {
        switch (n) {
            case 1:
                countLetter(str);
                break;
            case 2:
                str = str.replaceAll("\\s+", "");
                countCharater(str);
                break;
            case 3:
                System.exit(0);
        }
    }
    
    public void countLetter(String str) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
//        String[] strSplit = str.split("\\s");
//        for (int i = 0; i < strSplit.length; i++) {
//            String ch = strSplit[i];
//            int count = 0;
//            for (int j = 0; j < strSplit.length; j++) {
//                if (strSplit[j].equals(ch)) {
//                    count++;
//                }
//            }
//            lhm.put(ch, count);
//        }
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isAllLetters(token)) {
                if (!lhm.containsKey(token)) {
                    lhm.put(token, 1);
                } else {
                    lhm.put(token, ((int) lhm.get(token)) + 1);
                }   
            }
        }
        lhm.forEach((key, value) -> {
                    System.out.println(key + " -> " + value);
                });
    }
    private boolean isAllLetters(String token) {
        for (char ch : token.toCharArray())
            if (!Character.isLetter(ch))
                return false;
        return true;
    }
    
    public void countCharater(String str) {
        LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<Character, Integer>();
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            int count = 0;
//            for (int j = 0; j < str.length(); j++) {
//                if (str.charAt(j) == ch) {
//                    count++;
//                }
//            }
//            lhm.put(ch+"", count);
//        }
        for (char ch : str.toCharArray()) {
            if (isAllLetters(ch+"")) {
                if (Character.isSpaceChar(ch)) 
                    continue;
                if (!lhm.containsKey(ch)) 
                    lhm.put(ch, 1);
                else
                    lhm.put(ch, ((int) lhm.get(ch)) + 1);
            }
        }
        
        lhm.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }
}
