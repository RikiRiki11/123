package Noel;

import java.util.Scanner;

public class UserLoggedInMenu {
    private static  User loggedInUser;
    private  UserManager userManager;
    
 // �� UserLoggedInMenu ���޸�������ֻ��ŵĲ���
    public UserLoggedInMenu(User loggedInUser, UserManager userManager) {
        this.loggedInUser = loggedInUser;
        this.userManager = userManager;
        
    }

    public UserLoggedInMenu(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. �û������޸�");
            System.out.println("2. �鿴�ҵ����");
            System.out.println("3. ���ȫ��С˵");
            System.out.println("4. ע��");
            System.out.print("��ѡ�����: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // ���Ļ��з�

            switch (choice) {
                case 1:
                    // �����޸�������ֻ�����ķ���
                	
                	UserManager.changeUserInformation( loggedInUser);
                    break;
                case 2:
                    // �鿴���
                    break;
                case 3:
                    // ���С˵
                    break;
                case 4:
                    System.out.println("ע���ɹ�������ǰ̨���档");
                    return; // ����ǰ̨����
                default:
                    System.out.println("��Ч��ѡ�����������롣");
                    break;
            }
        }
    }

    // ����޸��û���Ϣ�ķ���
   
}
