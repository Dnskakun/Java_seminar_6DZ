/*
 * Подумать над структурой класса Ноутбук для магазина техники -
 * выделить поля и методы.
 * Реализовать в java. Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий
 * (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру.
 * Критерии фильтрации можно хранить в Map.
 * Например: “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * Далее нужно запросить минимальные значения для указанных критериев -
 * сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки из первоначального множества и вывести
 * проходящие по условиям.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task_1 {
    public static void main(String[] args) {
        
        Notebook notebook1 = new Notebook("Office lite", 4, 250, "windows", "black");
        Notebook notebook2 = new Notebook("Office optima", 6, 500, "windows", "gold");
        Notebook notebook3 = new Notebook("Office linux", 4, 500, "linux", "gold");
        Notebook notebook4 = new Notebook("Office max", 12, 750, "windows", "blue");
        Notebook notebook5 = new Notebook("Home expert", 8, 500, "linux", "black");
        Notebook notebook6 = new Notebook("Home optima", 6, 1000, "windows", "grey");
        Notebook notebook7 = new Notebook("Home gamer", 12, 1000, "windows", "grey");

        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        notebooks.add(notebook6);
        notebooks.add(notebook7);
        
        filterNotebooks(notebooks);

    }

    static void filterNotebooks(Set<Notebook> notebooks) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:" + 
        "\n1 - ОЗУ;\n2 - Объем ЖД;\n3 - Операционная система;\n4 - Цвет." +
        "\nПосле ввода требуемых критериев введите цифру 0.");
        System.out.println("Введите первый параметр: ");
        
        Map<Integer, String> parameters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int criterian = scanner.nextInt();
            switch (criterian) {
                case 1:
                    System.out.print("Введите минимальное количество ОЗУ (от 1 Гб): ");
                    Scanner scanner_ram = new Scanner(System.in);
                    String ram = scanner_ram.next();
                    parameters.put(1, ram);
                    System.out.print("Введите следующий параметр или 0 для формирования списка ноутбуков: ");
                    //scanner_ram.close();
                    break;
                case 2:
                    System.out.print("Введите минимальный размер HDD (от 1 Гб): ");
                    Scanner scanner_hdd = new Scanner(System.in);
                    String hdd = scanner_hdd.nextLine();
                    //scanner_hdd.close();
                    parameters.put(2, hdd);
                    System.out.print("Введите следующий параметр или 0 для формирования списка ноутбуков: ");
                    break;
                case 3:
                    System.out.print("Введите название операционной системы (windows или linux): ");
                    Scanner scanner_os = new Scanner(System.in);
                    String os = scanner_os.nextLine();
                    //scanner_os.close();
                    parameters.put(3, os);
                    System.out.print("Введите следующий параметр или 0 для формирования списка ноутбуков: ");
                    break;
                case 4:
                    System.out.print("Введите цвет ноутбука (black, gold, blue, grey): ");
                    Scanner scanner_color = new Scanner(System.in);
                    String color = scanner_color.nextLine();
                    //scanner_color.close();
                    parameters.put(4, color);
                    System.out.print("Введите следующий параметр или 0 для формирования списка ноутбуков: ");
                    break;
                case 0:
                    System.out.println();
                    flag = false;
                    break;
                default:
                    System.out.println("Введите цифру, соответствующую критерию!");
                    break;
            }
        }
        
        //System.out.println(parameters);
        scanner.close();
        
        Set<String> set_os = new HashSet<>();
        Set<String> set_colors = new HashSet<>();

        for (Notebook notebook: notebooks) {
            set_os.add(notebook.getOs());
            set_colors.add(notebook.getColor());
        }

        if (!parameters.containsKey(1)) {
            parameters.put(1, "0");
        }

        if (!parameters.containsKey(2)) {
            parameters.put(2, "0");
        }

        if (!parameters.containsKey(3)) {
            parameters.put(3, set_os.toString());
        }

        if (!parameters.containsKey(4)) {
            parameters.put(4, set_colors.toString());
        }

        for (Notebook notebook: notebooks) {
            if (notebook.getRam_gb() >= Integer.parseInt(parameters.get(1)) &&
            notebook.getHdd_gb() >= Integer.parseInt(parameters.get(2)) &&
            parameters.get(3).contains(notebook.getOs()) &&
            parameters.get(4).contains(notebook.getColor())) {
                System.out.println(notebook.toStringNB());
            }
        }
        
    }
    
}