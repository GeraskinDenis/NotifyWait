package ru.geraskindenis.notifywait;

public class Waiter implements Runnable
{
    private final Message msg;

    public Waiter(Message msg)
    {
        this.msg = msg;
    }

    @Override
    public void run()
    {
        String name = Thread.currentThread().getName();
        synchronized (msg)
        {
            try
            {
                System.out.println(name + " wait for the method notify(): " + System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            System.out.println(name + " called method notify(): " + System.currentTimeMillis());
            System.out.println(name + " : " + msg.getMsg());
        }
    }
}
