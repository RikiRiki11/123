package ss;


import java.util.concurrent.locks.ReentrantLock;

public class Huochepiao {
    public int availableTickets;
    public final ReentrantLock lock = new ReentrantLock();
    public boolean ticketsAvailable = true; // 新增一个标志变量

    public Huochepiao(int totalTickets) {
        availableTickets = totalTickets;
    }

    public void bookTicket(String passengerName, int numTickets) {
        lock.lock(); // 获得锁
        try {
            if (ticketsAvailable && availableTickets >= numTickets) {
                System.out.println(passengerName + " 购买了 " + numTickets + " 张票");
                availableTickets -= numTickets;
                System.out.println("剩余票数: " + availableTickets);
                
                if (availableTickets == 0) {
                    ticketsAvailable = false; // 标志票售完
                }
            } else {
                System.out.println(passengerName + " 票数不足，购买失败");
            }
        } finally {
            lock.unlock(); // 释放锁
        }
    }

}
