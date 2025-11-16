package main;

public class TestSlangDictionary {
    public static void main(String[] args) {
        try {
            SlangDictionary dict = new SlangDictionary("data/slang.txt");

            // TEST 1: search by slang word
            System.out.println("Searching >:( ");
            System.out.println(dict.searchBySlang(">:("));  

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
