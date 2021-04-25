package ru.geraskindenis.notifywait;

public class Main
{
    public static void main(String[] args)
    {
        Message msg = new Message("Process");

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "#Waiter1").start();

        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "#Waiter2").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "#Notifier").start();
        System.out.println("Started all threads.");
    }
}
