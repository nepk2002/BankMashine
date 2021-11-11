package com.company;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, String> currencyMap = new HashMap<>();
    static Map<Integer, User> usersMap = new HashMap<>();
    static boolean isWorking = true;

    public static void main(String[] args) {
        currencyMap.put(1, "USD");
        currencyMap.put(2, "BYN");

        inputThreeUsers();
        User user = usersMap.get((int) (Math.random() * 3));
        BankMachine bm = new BankMachine(user);
        System.out.println("Выбран пользователь: " + user.getName());
        while (true) {
            if (bm.getCountPinCodeInput() < 3) {
                System.out.println("Введите пин код");
                if (bm.checkPinCode(sc.nextInt()) == 0) {
                    break;
                }

            } else System.exit(-1);
        }

        bm.current();

        while (isWorking) {
            System.out.println("Выберите номер операции: 1 - положить деньги на счет," +
                    " 2 - снять деньги со счета, 3 - посмотреть счет, 4 - выход");
            int operationNumber = sc.nextInt();
            isWorking = bm.operation(operationNumber);
        }

    }

    private static void inputThreeUsers() {
        for (int i = 0; i < 3; i++) {
            usersMap.put(i, inputUser());
        }
    }

    private static User inputUser() {
        User user = new User();
        System.out.println("Создайте нового пользователя. Введите имя");
        user.setName(sc.next());

        while (true) {
            int x;
            System.out.println("Введите 4-х значный пин-код");
            x = user.setPinCode(sc.nextInt());
            if ((x <= 9999) & (x > 999)) break;
            else System.out.println("Неверный пин-код");
        }


        int x;
        do {
            System.out.println("Введите текущий баланс");
            while (!sc.hasNextInt() & !sc.hasNext()) {
                System.out.println("Неверно");
                user.setBalance(sc.nextInt());
            }
            x = user.setBalance(sc.nextInt());
        }
        while (x < 0);

        return user;
    }
}