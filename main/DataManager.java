package main;

import java.io.*;
import java.util.*;
import model.SlangEntry;

public class DataManager {
    public static LinkedHashMap<String, SlangEntry> load(String filePath) throws IOException {
        LinkedHashMap<String, SlangEntry> map = new LinkedHashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.contains("`")) continue;
            String[] parts = line.split("`");
            String word = parts[0];
            List<String> defs = Arrays.asList(parts[1].split("\\|"));
            map.put(word, new SlangEntry(word, new ArrayList<>(defs)));
        }
        br.close();
        return map;
    }

    public static void save(LinkedHashMap<String, SlangEntry> dict, String filePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        for (SlangEntry entry : dict.values()) {
            bw.write(entry.getWord() + "`" + String.join("|", entry.getDefinitions()));
            bw.newLine();
        }

        bw.close();
    }
}
 
