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

}
