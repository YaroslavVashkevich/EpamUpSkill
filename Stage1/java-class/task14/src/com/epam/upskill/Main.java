package com.epam.upskill;

import java.util.Scanner;

//4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета.
// Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по всем счетам,
// имеющим положительный и отрицательный балансы отдельно.

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Иван", "Иванов", new BankAccount("5555555555"));
        client.addBankAccount(new BankAccount("1111111111"), client.getBankAccounts());
        client.addBankAccount(new BankAccount("2222222222"), client.getBankAccounts());
        client.addBankAccount(new BankAccount("3333333333"), client.getBankAccounts());
        client.addBankAccount(new BankAccount("4444444444"), client.getBankAccounts());

        client.addCashSystem("1111111111", client.getBankAccounts(), 500);
        client.addCashSystem("2222222222", client.getBankAccounts(), 200);
        client.addCashSystem("3333333333", client.getBankAccounts(), -100);
        client.addCashSystem("4444444444", client.getBankAccounts(), -50);

        System.out.println("1-Поиск счета; 2-сортировка счетов; 3-общая сумма; 4 - положить на счет\n5-снять со счета; 6-разблокировать; 7-заблокировать; 8-закончить");
        while (true) {
            int run = 0;
            System.out.print("Введите необходимый номер: ");

            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    System.out.println(client.searchBankAccount(client.getBankAccounts()));
                    break;
                case 2:
                    client.sortAccount(client.getBankAccounts());
                    break;
                case 3:
                    client.sumMoney(client.getBankAccounts());
                    break;
                case 4:
                    client.addCash(client.getBankAccounts());
                    break;
                case 5:
                    client.dissCash(client.getBankAccounts());
                    break;
                case 6:
                    client.unlockAccount(client.getBankAccounts());
                    break;
                case 7:
                    client.blockAccount(client.getBankAccounts());
                    break;
                case 8:
                    run = 1;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
            }
            if (run == 1) break;
        }
    }
}