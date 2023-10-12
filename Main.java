
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Создание множества ноутбуков
        Set<Laptop> laptops = new HashSet<>();

        // Добавление ноутбуков в множество
        laptops.add(new Laptop("HP", 8, 1000, "Windows 10", "Серый"));
        laptops.add(new Laptop("Apple", 16, 512, "macOS", "Серебристый"));
        laptops.add(new Laptop("Lenovo", 12, 2000, "Windows 10", "Черный"));
        laptops.add(new Laptop("Dell", 8, 500, "Windows 10", "Черный"));
        laptops.add(new Laptop("Asus", 16, 1000, "Windows 10", "Красный"));

        // Метод для фильтрации и вывода ноутбуков
        filterLaptops(laptops);
    }

    public static void filterLaptops(Set<Laptop> laptops) {
        // Создание Map с критериями фильтрации и их минимальными значениями
        Map<String, String> criteria = new HashMap<>();
        criteria.put("1", "ОЗУ");
        criteria.put("2", "Объем ЖД");
        criteria.put("3", "Операционная система");
        criteria.put("4", "Цвет");

        // Запрос критерия фильтрации у пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        String userInput = scanner.nextLine();

        // Если критерий существует
        if (criteria.containsKey(userInput)) {
            String selectedCriteria = criteria.get(userInput);
            System.out.println("Введите минимальное значение для " + selectedCriteria + ":");
            String minValue = scanner.nextLine();

            // Фильтрация ноутбуков по выбранному критерию и его минимальному значению
            Set<Laptop> filteredLaptops = new HashSet<>();
            switch (selectedCriteria) {
                case "ОЗУ":
                    int minRam = Integer.parseInt(minValue);
                    for (Laptop laptop : laptops) {
                        if (laptop.getRam() >= minRam) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;
                case "Объем ЖД":
                    int minHddSize = Integer.parseInt(minValue);
                    for (Laptop laptop : laptops) {
                        if (laptop.getHdd() >= minHddSize) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;
                case "Операционная система":
                    for (Laptop laptop : laptops) {
                        if (laptop.getOs().equalsIgnoreCase(minValue)) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;
                case "Цвет":
                    for (Laptop laptop : laptops) {
                        if (laptop.getColor().equalsIgnoreCase(minValue)) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;
                default:
                    System.out.println("Некорректный ввод критерия!");
                    return;
            }

            // Вывод отфильтрованных ноутбуков
            if (filteredLaptops.isEmpty()) {
                System.out.println("Ноутбуки, удовлетворяющие условиям фильтрации, не найдены.");
            } else {
                for (Laptop laptop : filteredLaptops) {
                    System.out.println(laptop);
                }
            }

        } else {
            System.out.println("Некорректный ввод критерия!");
        }
    }
}

