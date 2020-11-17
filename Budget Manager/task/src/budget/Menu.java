package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    final static Scanner scanner = new Scanner(System.in);
    List<Good> goods;
    double balance;
    final static StringParser parser = new StringParser();
    List<Good> food;
    List<Good> clothes;
    List<Good> entertainment;
    List<Good> other;


    Menu() {
        goods = new ArrayList<>();
        balance = 0;
        food = new ArrayList<>();
        clothes = new ArrayList<>();
        entertainment = new ArrayList<>();
        other = new ArrayList<>();
    }

    public void process() {
        int choice;
        while (true) {
            System.out.println("Choose your action:");
            System.out.println("1) Add income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("0) Exit");
            choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addPurchase();
                    break;
                case 3:
                    showListOfPurchases();
                    break;
                case 4:
                    balance();
                    break;
                case 0:
                    System.out.println("Bye!");
                    return;
            }
            System.out.println();

        }
    }

    public void addIncome() {
        System.out.println("Enter income:");
        double income = Integer.parseInt(scanner.nextLine());
        balance += income;
        System.out.println("Income was added!");
    }

    public void addPurchase() {
        while (true) {
            System.out.println("Choose the type of purchase");
            System.out.println("1) Food");
            System.out.println("2) Clothes");
            System.out.println("3) Entertainment");
            System.out.println("4) Other");
            System.out.println("5) Back");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            Category category = null;

            switch (choice) {
                case 1:
                    category = Category.FOOD;
                    break;
                case 2:
                    category = Category.CLOTHES;
                    break;
                case 3:
                    category = Category.ENTERTAINMENT;
                    break;
                case 4:
                    category = Category.OTHER;
                    break;
                case 5:
                    return;
            }
            System.out.println("Enter purchase name:");
            String name = scanner.nextLine();
            System.out.println("Enter its price:");
            double price = Double.parseDouble(scanner.nextLine());

            Good good = new Good(name, price, category);
            goods.add(good);
            switch (category) {
                case FOOD:
                    food.add(good);
                    break;
                case OTHER:
                    other.add(good);
                    break;
                case CLOTHES:
                    clothes.add(good);
                    break;
                case ENTERTAINMENT:
                    entertainment.add(good);
                    break;
            }
            balance -= price;
            System.out.println("Purchase was added!");
            System.out.println();
        }
    }

    public void showListOfPurchases() {
        if (goods.size() == 0) {
            System.out.println("Purchase list is empty");
            return;
        }
        while (true) {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println();
        switch (choice) {
            case 1:
                System.out.println("Food:");
                showList(food);
                break;
            case 2:
                System.out.println("Clothes:");
                showList(clothes);
                break;
            case 3:
                System.out.println("Entertainment:");
                showList(entertainment);
                break;
            case 4:
                System.out.println("Other:");
                showList(other);
                break;
            case 5:
                System.out.println("All:");
                showList(goods);
                break;
            case 6:
                return;
        }
        }
    }

    private double sumOfPurchases(List<Good> list) {
        double answer = 0;
        for (Good g : list) {
            answer += g.price;
        }
        return answer;
    }

    public void balance() {
        if (balance <= 0) {
            System.out.println("Balance: $0.00");
        } else {
            System.out.println("Balance: $" + balance);
        }
    }

    public void showList(List<Good> list) {
        if (list.size() == 0) {
            System.out.println("Purchase list is empty");
        } else {
            for (Good g : list) {
                System.out.println(g);
            }
            double sum = sumOfPurchases(list);
            System.out.println("Total sum: $" + sum);
            System.out.println();
        }
    }
}