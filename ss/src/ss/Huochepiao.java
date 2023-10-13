package ss;


import java.util.concurrent.locks.ReentrantLock;

public class Huochepiao {
    public int availableTickets;
    public final ReentrantLock lock = new ReentrantLock();
    public boolean ticketsAvailable = true; // ����һ����־����

    public Huochepiao(int totalTickets) {
        availableTickets = totalTickets;
    }

    public void bookTicket(String passengerName, int numTickets) {
        lock.lock(); // �����
        try {
            if (ticketsAvailable && availableTickets >= numTickets) {
                System.out.println(passengerName + " ������ " + numTickets + " ��Ʊ");
                availableTickets -= numTickets;
                System.out.println("ʣ��Ʊ��: " + availableTickets);
                
                if (availableTickets == 0) {
                    ticketsAvailable = false; // ��־Ʊ����
                }
            } else {
                System.out.println(passengerName + " Ʊ�����㣬����ʧ��");
            }
        } finally {
            lock.unlock(); // �ͷ���
        }
    }

}
