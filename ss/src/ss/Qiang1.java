package ss;

public class Qiang1  {
	
		
		// TODO �Զ����ɵĹ��캯�����
	

	 public static void main(String[] args) {
	        Huochepiao ticketSystem = new Huochepiao(100); // �ܹ���10��Ʊ

	        // ��������˿��߳�
	        Thread passenger1 = new Thread(() -> {
	            while (true) {
	                ticketSystem.bookTicket("�˿�1", 1);
	                if (!ticketSystem.ticketsAvailable) {
	                    break; // ��Ʊ����ʱ�˳�ѭ��
	                }
	            }
	        });

	        Thread passenger2 = new Thread(() -> {
	            while (true) {
	                ticketSystem.bookTicket("�˿�2", 1);
	                if (!ticketSystem.ticketsAvailable) {
	                    break; // ��Ʊ����ʱ�˳�ѭ��
	                }
	            }
	        });

	        Thread passenger3 = new Thread(() -> {
	            while (true) {
	                ticketSystem.bookTicket("�˿�3", 1);
	                if (!ticketSystem.ticketsAvailable) {
	                    break; // ��Ʊ����ʱ�˳�ѭ��
	                }
	            }
	        });

	        // �����߳�
	        passenger1.start();
	        passenger2.start();
	        passenger3.start();
	    }
	}

