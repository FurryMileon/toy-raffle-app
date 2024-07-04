import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Добавить игрушку");
            System.out.println("2. Изменить вес игрушки");
            System.out.println("3. Организовать розыгрыш");
            System.out.println("4. Получить призовую игрушку");
            System.out.println("5. Показать все игрушки");
            System.out.println("6. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите ID игрушки: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Введите название игрушки: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите количество: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Введите вес (частоту выпадения): ");
                    double weight = scanner.nextDouble();
                    store.addToy(new Toy(id, name, quantity, weight));
                    break;
                case 2:
                    System.out.print("Введите ID игрушки: ");
                    int toyId = scanner.nextInt();
                    System.out.print("Введите новый вес: ");
                    double newWeight = scanner.nextDouble();
                    store.changeWeight(toyId, newWeight);
                    break;
                case 3:
                    store.organizeRaffle();
                    break;
                case 4:
                    store.getPrizeToy();
                    break;
                case 5:
                    store.displayToys();
                    break;
                case 6:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}