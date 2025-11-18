package main;
import java.util.*;

import model.SlangEntry;

public class DictionaryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            SlangDictionary dict = new SlangDictionary("data/slang_saved.txt");

            while (true) {
                System.out.println("\n========== SLANG DICTIONARY ==========");
                System.out.println("1. Search by slang word");
                System.out.println("2. Search by definition");
                System.out.println("3. View search history");
                System.out.println("4. Add a slang word");
                System.out.println("5. Edit a slang word");
                System.out.println("6. Delete a slang word");
                System.out.println("7. Reset to original slang list");
                System.out.println("8. Random slang word");
                System.out.println("9. Quiz: choose correct definition");
                System.out.println("10. Quiz: choose correct slang word");
                System.out.println("0. Exit");
                System.out.print("Choose option: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1": 
                        System.out.print("Enter slang word: ");
                        String slang = scanner.nextLine();
                        SlangEntry result = dict.searchBySlang(slang);
                        if (result != null)
                            System.out.println(result);
                        else
                            System.out.println("Not found.");
                        break;

                    case "2":  
                        System.out.print("Enter definition keyword: ");
                        String def = scanner.nextLine();
                        List<String> found = dict.searchByDefinition(def);
                        if (found.isEmpty())
                            System.out.println("Not found.");
                        else
                            found.forEach(System.out::println);
                        break;

                    case "3":  
                        dict.printHistory();
                        break;

                    case "4":  
                        System.out.print("Enter new slang word: ");
                        String newSlang = scanner.nextLine();
                        System.out.print("Enter definitions (use | to separate): ");
                        String defs = scanner.nextLine();
                        dict.addSlang(scanner, newSlang, Arrays.asList(defs.split("\\|")));
                        break;

                    case "5":  
                        System.out.print("Enter slang to edit: ");
                        String editSlang = scanner.nextLine();
                        System.out.print("Enter new definitions (use | to separate): ");
                        List<String> newDefs = Arrays.asList(scanner.nextLine().split("\\|"));
                        dict.editSlang(editSlang, newDefs);
                        break;

                    case "6":  
                        System.out.print("Enter slang to delete: ");
                        String delSlang = scanner.nextLine();
                        dict.deleteSlang(scanner, delSlang);
                        break;

                    case "7":  
                        dict.reset();
                        break;

                    case "8":  
                        SlangEntry randomOfDay = dict.randomSlangOfDay();
                        System.out.println("Random slang of day: ");
                        System.out.println(randomOfDay);
                        SlangEntry random = dict.randomSlang();
                        System.out.println("Random slang: ");
                        System.out.println(random);
                        break;

                    case "9": 
                        dict.quizSlangToDefinition(scanner);
                        break;

                    case "10": 
                        dict.quizDefinitionToSlang(scanner);
                        break;

                    case "0": 
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Try again!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
