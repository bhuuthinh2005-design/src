package main;


public class TestSlangDictionary {
    public static void main(String[] args) {
        try {
            SlangDictionary dict = new SlangDictionary("data/slang.txt");

            // TEST 1: search by slang word
            System.out.println("Searching >:( ");
            System.out.println(dict.searchBySlang(">:("));  

            // TEST 2: search by definition
            System.out.println("Search: 'too'");
            System.out.println("Result: " + dict.searchByDefinition("too"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
