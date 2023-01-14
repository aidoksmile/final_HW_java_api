import java.util.*;

public class Main {

    public static Integer chooseFilter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбрать категорию для поиска: ");
        System.out.println(
                "1 - бренд\n2 - процессор\n3 - ОЗУ\n4 - объем ЖД\n5 - цвет\n6 - все\n");
        System.out.print("Ваша категория: ");
        return scanner.nextInt();
    }

    public static String doFirstUpper(String word) {
        if (word == null || word.isEmpty())
            return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static void findFilter(Set<Laptop> products, String filter, String input) {
        Integer count = 1;
        Map<String, Laptop> result = new LinkedHashMap<>();
        for (Laptop lapt : products) {
            if (lapt.getInfo(filter).contains(input)) {
                result.put(String.format("\n\nНоутбук № %d", count), lapt);
                count++;
            }
        }
        if (result.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.println("Cписок подходящих ноутбуков:\n" + result);
        }
    }

    public static void main(String[] args) {

        Laptop lapt1 = new Laptop("0001", "Apple", "M1",
                "8 GB", "1 TB", "Серый");
        Laptop lapt2 = new Laptop("0002", "ASUS", "Intel Core i7",
                "16 GB", "1 TB", "Чёрный");
        Laptop lapt3 = new Laptop("0003", "Xiaomi", "Intel Core i7",
                "16 GB", "1 TB", "Чёрный");
        Laptop lapt4 = new Laptop("0004", "HP", "Intel Core i5",
                "16 GB", "1 TB", "Чёрный");
        Laptop lapt5 = new Laptop("0005", "Lenovo", "Intel Core i7",
                "16 GB", "1 TB", "Серый");
        Laptop lapt6 = new Laptop("0006", "HONOR", "AMD Ryzen 7",
                "8 GB", "2 TB", "Белый");

        HashSet<Laptop> products = new HashSet<Laptop>(Arrays.asList(lapt1, lapt2, lapt3, lapt4, lapt5, lapt6));

        Map<Integer, String> filters = new HashMap<>();
        filters.put(1, "brand");
        filters.put(2, "processor");
        filters.put(3, "RAM");
        filters.put(4, "SSD");
        filters.put(5, "сolor");
        filters.put(6, "all");
        Integer choice = chooseFilter();

        Scanner scanner = new Scanner(System.in);

        if (filters.containsKey(choice)) {
            switch (choice) {
                case 1: {
                    System.out.println("Введите наименование бренда ноутбука: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(products, filters.get(1), input);
                    break;
                }
                case 2: {
                    System.out.println("Введите наименование процессора: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(products, filters.get(2), input);
                    break;
                }
                case 3: {
                    System.out.println("Введите объём ОЗУ в ГБ: ");
                    String input = scanner.next();
                    findFilter(products, filters.get(3), input);
                    break;
                }
                case 4: {
                    System.out.println("Введите объём ЖД в ТБ: ");
                    String input = scanner.next();
                    findFilter(products, filters.get(4), input);
                    break;
                }
                case 5: {
                    System.out.println("Введите цвет: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(products, filters.get(5), input);
                    break;
                }
                case 6: {
                    Integer count = 1;
                    System.out.println("\nВсе ноутбуки:");
                    for (Laptop lapt : products) {
                        System.out.println("\nНоутбук №" + count + "\n" + lapt);
                        count++;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        scanner.close();
    }
}