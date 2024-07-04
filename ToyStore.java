import java.util.*;
import java.io.*;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void changeWeight(int id, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Игрушка с ID " + id + " не найдена.");
    }

    public void organizeRaffle() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomValue = Math.random() * totalWeight;
        double cumulativeWeight = 0;

        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomValue <= cumulativeWeight && toy.getQuantity() > 0) {
                prizeToys.add(toy);
                toy.setQuantity(toy.getQuantity() - 1);
                System.out.println("Выиграна игрушка: " + toy.getName());
                return;
            }
        }
        System.out.println("Не удалось разыграть игрушку.");
    }

    public void getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);
            try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
                writer.write(prizeToy.getName() + "\n");
                System.out.println("Игрушка " + prizeToy.getName() + " выдана и записана в файл.");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }
        } else {
            System.out.println("Нет призовых игрушек для выдачи.");
        }
    }

    public void displayToys() {
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }
}