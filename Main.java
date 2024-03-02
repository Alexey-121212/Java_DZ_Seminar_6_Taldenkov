
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Notebook notebook1 = new Notebook(8, 512, 1);
        notebook1.setOs("Ubuntu");
        notebook1.setBrand("HP");
        Notebook notebook2 = new Notebook(16, 512, 2);
        notebook2.setOs("Windows");
        notebook2.setBrand("IBM");
        Notebook notebook3 = new Notebook(32, 1024, 3);
        notebook3.setOs("MacOS");
        notebook3.setBrand("Apple");
        Notebook notebook4 = new Notebook(16, 2048, 4);
        notebook4.setOs("ChromeOS");
        notebook4.setBrand("Unknown");
        Notebook notebook5 = new Notebook(64, 256, 5);
        notebook5.setOs("Unknown");
        notebook5.setBrand("ASUS");

        Set<Notebook> nbset = new HashSet<Notebook>();

        nbset.add(notebook1);
        nbset.add(notebook2);
        nbset.add(notebook3);
        nbset.add(notebook4);
        nbset.add(notebook5);

        printNotebooksByFilter(nbset, getCriterias());

    }

    public static HashMap<String, Integer> getCriterias() {
        HashMap<String, Integer> criterias = new HashMap<String, Integer>();
        String criteria = new String();
        boolean notExit = true;
        Scanner scaninput = new Scanner(System.in);
        while (notExit) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Введите критерий фильтрации для ноутбуков");
            System.out.println("для удаления критерия, нажмите повторно");
            System.out.println("1- ram");
            System.out.println("2- hdd");
            System.out.println("3- weight");
            System.out.println();
            System.out.println("E- enter min values");
            System.out.println();
            System.out.println("Your choice:" + criterias.keySet());
            criteria = scaninput.nextLine();

            switch (criteria) {
                case "1":
                    if (criterias.containsKey("ram")) {
                        criterias.remove("ram");
                    } else {
                        criterias.put("ram", null);
                    }
                    break;
                case "2":
                    if (criterias.containsKey("hdd")) {
                        criterias.remove("hdd");
                    } else {
                        criterias.put("hdd", null);
                    }
                    break;
                case "3":
                    if (criterias.containsKey("weight")) {
                        criterias.remove("weight");
                    } else {
                        criterias.put("weight", null);
                    }
                    break;
                case "E":
                    notExit = false;
                    break;
                case "e":
                    notExit = false;
                    break;
            }
        }

        String criteriaVal = new String();
        int criteriaValInt = 0;

        for (String key : criterias.keySet()) {
            notExit = true;
            while (notExit) {
                if (key == "weight")
                    System.out.println("Введите максимальное значение " + key);
                else
                    System.out.println("Введите минимальное значение " + key);
                criteriaVal = scaninput.nextLine();
                if (isInteger(criteriaVal)) {
                    criteriaValInt = Integer.parseInt(criteriaVal);
                    notExit = false;
                } else {
                    System.out.println("Некорректный ввод");
                }
            }
            switch (key) {
                case "ram":
                    criterias.put("ram", criteriaValInt);
                    break;
                case "hdd":
                    criterias.put("hdd", criteriaValInt);
                    break;
                case "weight":
                    criterias.put("weight", criteriaValInt);
                    break;
            }
        }
        scaninput.close();
        return criterias;
    }

    public static void printNotebooksByFilter(Set<Notebook> sn, HashMap<String, Integer> filter) {

        boolean bram, bhdd, bweight, isemptylist = true;
        System.out.println();
        System.out.print("Список ноутбуков с учетом фильтров");
        for (Notebook notebook : sn) {

            if (filter.get("ram") == null)
                bram = true;
            else
                bram = (notebook.getRam() >= filter.get("ram"));

            if (filter.get("hdd") == null)
                bhdd = true;
            else
                bhdd = (notebook.getHdd() >= filter.get("hdd"));

            if (filter.get("weight") == null)
                bweight = true;
            else
                bweight = (notebook.getWeight() <= filter.get("weight"));

            if (bram & bhdd & bweight) {
                isemptylist = false;
                System.out.println();
                System.out.println("__________________________________");
                System.out.println(notebook);
            }
        }
        if (isemptylist) {
            System.out.println(" пуст, измените фильтр");
            System.out.println();
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
