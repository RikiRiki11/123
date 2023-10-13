package Noel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
	
	private static  List<User> users;
	private String phoneNumber;
    private String password;
    public UserManager() {
        users = new ArrayList<>();
        User newUser1 = new User("jack", "123", "123");
        User newUser2 = new User("Riki", "12345", "123");
        users.add(newUser1);
        users.add(newUser2);
    }
    public  List<User> getUsers() {
        return users;
    }
    
    public UserManager(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public User loginUser(String phoneNumber, String password) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                return user; // ����ƥ����û�
            } 
       
        // �û������ڻ����벻ƥ��
        }
       return null;
    }
	 public static void adminLogin(Scanner scanner) {
		 
	 }
	 public static void registerUser(String username, String phoneNumber, String password) {
	        // ���ȣ�����ֻ����Ƿ��Ѵ���
	        if (isPhoneNumberTaken(phoneNumber)) {
	            System.out.println("�ֻ������ѱ�ע�ᣬ��ʹ���������롣");
	        } else {
	            // �������û�����ӵ��û��б�
	            User newUser = new User(username, phoneNumber, password);
	            users.add(newUser);
	            System.out.println("�û�ע��ɹ���");
	        }
	    }

	    private static boolean isPhoneNumberTaken(String phoneNumber) {
	        for (User user : users) {
	            if (user.getPhoneNumber().equals(phoneNumber)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    public static void changeUserInformation(User loggedInUser) {
		 Scanner scanner = new Scanner(System.in);

	        System.out.println("1. �޸�����");
	        System.out.println("2. �޸��ֻ�����");
	        System.out.print("��ѡ��Ҫ�޸ĵ���Ŀ: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // ���Ļ��з�

	        switch (choice) {
	            case 1:
	                // �޸�����
	                System.out.print("������������: ");
	                String newPassword = scanner.next();
	                loggedInUser.changePassword(newPassword);
	                System.out.println("�������޸ġ�");
	                break;
	            case 2:
	                // �޸��ֻ�����
	                System.out.print("���������ֻ�����: ");
	                String newPhoneNumber = scanner.next();
	                boolean success = loggedInUser.changePhoneNumber(newPhoneNumber, users);
	                if (success) {
	                    System.out.println("�ֻ��������޸ġ�");
	                } else {
	                    System.out.println("���ֻ������������û����ֻ������ظ����޸�ʧ�ܡ�");
	                }
	                break;
	            default:
	                System.out.println("��Ч��ѡ�����������롣");
	                break;
	        }
	       
	    }
	public void viewUserShelf( Scanner scanner){
		System.out.println("���Ʋ��");
	}
}