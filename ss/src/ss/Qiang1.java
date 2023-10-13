package ss;

public class Qiang1  {
	
		
		// TODO 自动生成的构造函数存根
	

	 public static void main(String[] args) {
	        Huochepiao ticketSystem = new Huochepiao(100); // 总共有10张票

	        // 创建多个乘客线程
	        Thread passenger1 = new Thread(() -> {
	            while (true) {
	                ticketSystem.bookTicket("乘客1", 1);
	                if (!ticketSystem.ticketsAvailable) {
	                    break; // 当票售完时退出循环
	                }
	            }
	        });

	        Thread passenger2 = new Thread(() -> {
	            while (true) {
	                ticketSystem.bookTicket("乘客2", 1);
	                if (!ticketSystem.ticketsAvailable) {
	                    break; // 当票售完时退出循环
	                }
	            }
	        });

	        Thread passenger3 = new Thread(() -> {
	            while (true) {
	                ticketSystem.bookTicket("乘客3", 1);
	                if (!ticketSystem.ticketsAvailable) {
	                    break; // 当票售完时退出循环
	                }
	            }
	        });

	        // 启动线程
	        passenger1.start();
	        passenger2.start();
	        passenger3.start();
	    }
	}

