package main;

import java.util.*;

public class TestSlangDictionary {
    public static void main(String[] args) {
        try {
            SlangDictionary dict = new SlangDictionary("data/slang_saved.txt");

            // // TEST 1: search by slang word
            // System.out.println("Searching >:( ");
            // System.out.println(dict.searchBySlang(">:("));  

            // // TEST 2: search by definition
            // System.out.println("Search: 'too'");
            // System.out.println("Result: " + dict.searchByDefinition("too"));

            // // TEST 3: get history
            // dict.searchBySlang("LOL");
            // dict.searchBySlang("BRB");
            // dict.searchBySlang(">:(");
            // dict.searchBySlang("NOT_EXIST");   
            // dict.printHistory();

            // TEST 4: add slang
            // Scanner scanner = new Scanner(System.in);
            // dict.addSlang(scanner, "UWU", List.of("Cute"));
            // System.out.println("Result: " + dict.searchBySlang("UWU"));

            // dict.addSlang(scanner, "LOL", List.of("Fun"));
            // System.out.println("Result: " + dict.searchBySlang("LOL"));
            // TEST 5: edit slang
            // dict.editSlang("LOL", List.of("Laugh Out Loud", "Very Funny"));
            // System.out.println("Result: " + dict.searchBySlang("LOL").getDefinitions());
            // dict.editSlang("NOT_EXIST", List.of("No meaning"));
            // System.out.println("Result: " + dict.searchBySlang("NOT_EXIST"));
            //TEST 6: delete slang
            Scanner scanner = new Scanner(System.in);
            dict.deleteSlang(scanner, "ELOL");
            System.out.println("Check search result: " + dict.searchBySlang("ELOL"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
