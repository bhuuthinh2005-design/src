package main;

import java.util.*;

import model.SlangEntry;

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
            // TEST 5: edit slang
            // dict.editSlang("LOL", List.of("Laugh Out Loud", "Very Funny"));
            // System.out.println("Result: " + dict.searchBySlang("LOL").getDefinitions());
            // dict.editSlang("NOT_EXIST", List.of("No meaning"));
            // System.out.println("Result: " + dict.searchBySlang("NOT_EXIST"));
            // TEST 6: delete slang
            // Scanner scanner = new Scanner(System.in);
            // dict.deleteSlang(scanner, "ELOL");
            // System.out.println("Check search result: " + dict.searchBySlang("ELOL"));
            // TEST 8: reset slang list
            // Scanner scanner = new Scanner(System.in);
            // dict.addSlang(scanner, "UWU", List.of("Cute"));
            // System.out.println("Before reset: " + dict.searchBySlang("UWU"));
            // dict.reset();
            // System.out.println("After reset: " + dict.searchBySlang("UWU"));
            for (int i = 0; i < 5; i++) {
                SlangEntry entry = dict.randomSlang();
                System.out.println(entry.getWord() + " = " + entry.getDefinitions());
            }
            System.out.println("\n=== Slang of the day ===");
            SlangEntry today = dict.randomSlangOfDay();
            System.out.println(today.getWord() + " = " + today.getDefinitions());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
