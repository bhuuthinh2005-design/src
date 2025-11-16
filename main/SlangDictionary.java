package main;

import model.SlangEntry;
import java.io.*;
import java.util.*;

public class SlangDictionary {
    private HashMap<String, SlangEntry> dict = new HashMap<>();
    private List<String> history = new ArrayList<>();

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
}
