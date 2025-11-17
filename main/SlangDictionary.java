package main;

import model.SlangEntry;
import java.io.*;
import java.util.*;

public class SlangDictionary {
    private HashMap<String, SlangEntry> dict = new HashMap<>();
    private List<String> history = new ArrayList<>();
    private String savePath = "data/slang_saved.txt";

    public SlangDictionary(String filePath) throws IOException {
        dict = DataManager.load(filePath);
    }

    public SlangEntry searchBySlang(String key) {
        SlangEntry result = dict.get(key);
        if (result != null) addToHistory(key);
        return result;
    }

    public List<String> searchByDefinition(String keyword) {
        List<String> results = new ArrayList<>();
        for (SlangEntry entry : dict.values()) {
            for (String def : entry.getDefinitions()) {
                if (def.toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(entry.getWord());
                }
            }
        }
        history.add("DEF: " + keyword);
        return results;
    }

    public void addToHistory(String key) {
        history.add(key);
    }

    public List<String> getHistory() {
        return history;
    }

    public void printHistory(){
        if (history.isEmpty()) {
            System.out.println("History is empty.");
            return;
        }

        System.out.println("===== SEARCH HISTORY =====");
        for (String h : history) {
            System.out.println(h);
        }
    }

    public void addSlang(Scanner scanner, String word, List<String> defs)  throws IOException {
        if (dict.containsKey(word)) {
            System.out.println("Slang word already exists: " + word);
            System.out.println("Do you want to:");
            System.out.println("1. Overwrite existing slang");
            System.out.println("2. Duplicate (add new definition)");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                dict.put(word, new SlangEntry(word, new ArrayList<>(defs)));
                System.out.println("Slang overwritten.");
            } else if (choice == 2) {
                SlangEntry existing = dict.get(word);
                for (String d : defs) {
                    existing.addDefinition(d);
                }
                System.out.println("Slang duplicated.");
            } else {
                System.out.println("Invalid choice. Cancel add slang.");
            }
        } else {
            dict.put(word, new SlangEntry(word, new ArrayList<>(defs)));
            System.out.println("New slang added.");
        }
        DataManager.save(dict, savePath);
    }

    public void editSlang(String word, List<String> defs) throws IOException {
        if (!dict.containsKey(word)) {
            System.out.println("Slang not found.");
            return;
        }
        dict.put(word, new SlangEntry(word, new ArrayList<>(defs)));
        DataManager.save(dict, savePath);
        System.out.println("Slang edited.");
    }

    public void deleteSlang(Scanner scanner, String word) throws IOException {
        if (!dict.containsKey(word)) {
            System.out.println("Not found.");
            return;
        }

        System.out.print("Are you sure to delete? (y/n): ");
        if (!scanner.nextLine().equalsIgnoreCase("y")) return;
        dict.remove(word);
        DataManager.save(dict, savePath);
        System.out.println("Slang deleted.");
    }

    public void reset() {
        try {
            HashMap<String, SlangEntry> original = DataManager.load("data/slang.txt");
            DataManager.save(original, savePath);
            dict = original;
            System.out.println("Slang dictionary has been reset to original data!");
        } catch (IOException e) {
            System.out.println("Error resetting slang dictionary.");
            e.printStackTrace();
        }
    }

    public SlangEntry randomSlang() {
        if (dict.isEmpty()) return null;
        List<String> keys = new ArrayList<>(dict.keySet());
        Random rand = new Random();
        String randomKey = keys.get(rand.nextInt(keys.size()));
        return dict.get(randomKey);
    }

    public SlangEntry  randomSlangOfDay() {
        if (dict.isEmpty()) return null;
        List<String> keys = new ArrayList<>(dict.keySet());
        long daySeed = System.currentTimeMillis() / (24 * 60 * 60 * 1000);
        Random rand = new Random(daySeed);
        String randomKey = keys.get(rand.nextInt(keys.size()));
        return dict.get(randomKey);
    }

}
