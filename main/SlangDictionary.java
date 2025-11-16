package main;

import model.SlangEntry;
import java.io.*;
import java.util.*;

public class SlangDictionary {
    private HashMap<String, SlangEntry> dict = new HashMap<>();

    public SlangDictionary(String filePath) throws IOException {
        dict = DataManager.load(filePath); 
    }

    public SlangEntry searchBySlang(String key) {
        SlangEntry result = dict.get(key);
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

        return results;
    }

}
