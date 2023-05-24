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


public class Notebook {


    private String model;
    private int ram_gb;
    private int hdd_gb;
    private String os;
    private String color;

    public Notebook(String model, int ram_gb, int hdd_gb, String os, String color) {
        this.model = model;
        this.ram_gb = ram_gb;
        this.hdd_gb = hdd_gb;
        this.os = os;
        this.color = color;
    }


    public String toStringNB() {
        return "Model: \t" + model + ", \tRAM: " + ram_gb + " GB, \tHDD: " + hdd_gb +
        " GB, \tOperating system: " + os + ", \tColor: " + color + ".";
    }

    public int getRam_gb() {
        return ram_gb;
    }

    public int getHdd_gb() {
        return hdd_gb;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

}
