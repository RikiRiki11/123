package Noel;

import java.util.Scanner;

public class MainMenu {
	private static User currentUser;
    public static void main(String[] args) {
    	UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            
            System.out.println("1. �û���¼");
            System.out.println("2. �û�ע��");
            System.out.println("3. ����Ա��¼");
            System.out.println("4. �˳�ϵͳ");
            System.out.print("��ѡ�����: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // �û���¼����
                	  System.out.print("�������ֻ�����: ");
                      String phoneNumber = scanner.next();
                      System.out.print("����������: ");
                      String password = scanner.next();
                      User loggedInUser = userManager.loginUser(phoneNumber, password);
                      if (loggedInUser != null) {
                          System.out.println("��¼�ɹ�����ӭ " + loggedInUser.getUsername());
                          // ���������ִ���û���¼�ɹ���Ĳ���
                          UserLoggedInMenu.showMenu();
                      } else {
                          System.out.println("��¼ʧ�ܣ��ֻ���������벻��ȷ");
                      }
                      
                     break;
                case 2:
                    // �û�ע�Ṧ��
                	System.out.print("�������û���: ");
                    String username = scanner.next();
                    System.out.print("�������ֻ�����: ");
                    String phoneNumber1 = scanner.next();
                    System.out.print("����������: ");
                    String password1 = scanner.next();
                   UserManager.registerUser(username, phoneNumber1, password1);
                    break;
                case 3:
                    // ����Ա��¼����
                    System.out.println("����Ա��¼������δʵ�֡�");
                    break;
                case 4:
                    // �˳�ϵͳ
                    System.out.println("ллʹ�ã��ټ���");
                    isRunning = false;
                    break;
                default:
                    System.out.println("��Ч��ѡ�������ѡ��");
            }
        }
        scanner.close();
    }
}