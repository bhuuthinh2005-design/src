package model;

import java.util.ArrayList;
import java.util.List;

public class SlangEntry {
    private String word;
    private List<String> definitions;

    public SlangEntry(String word, List<String> definitions) {
        this.word = word;
        this.definitions = new ArrayList<>(definitions);
    }

    public String getWord() { 
        return word; 
    }
    public List<String> getDefinitions() { 
        return definitions; 
    }

    public void addDefinition(String def) {
        definitions.add(def);
    }

    @Override
    public String toString() {
        return word + " = " + String.join("|", definitions);
    }
    
}
