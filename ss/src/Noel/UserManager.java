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
                return user; // 返回匹配的用户
            } 
       
        // 用户不存在或密码不匹配
        }
       return null;
    }
	 public static void adminLogin(Scanner scanner) {
		 
	 }
	 public static void registerUser(String username, String phoneNumber, String password) {
	        // 首先，检查手机号是否已存在
	        if (isPhoneNumberTaken(phoneNumber)) {
	            System.out.println("手机号码已被注册，请使用其他号码。");
	        } else {
	            // 创建新用户并添加到用户列表
	            User newUser = new User(username, phoneNumber, password);
	            users.add(newUser);
	            System.out.println("用户注册成功！");
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

	        System.out.println("1. 修改密码");
	        System.out.println("2. 修改手机号码");
	        System.out.print("请选择要修改的项目: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // 消耗换行符

	        switch (choice) {
	            case 1:
	                // 修改密码
	                System.out.print("请输入新密码: ");
	                String newPassword = scanner.next();
	                loggedInUser.changePassword(newPassword);
	                System.out.println("密码已修改。");
	                break;
	            case 2:
	                // 修改手机号码
	                System.out.print("请输入新手机号码: ");
	                String newPhoneNumber = scanner.next();
	                boolean success = loggedInUser.changePhoneNumber(newPhoneNumber, users);
	                if (success) {
	                    System.out.println("手机号码已修改。");
	                } else {
	                    System.out.println("新手机号码与其他用户的手机号码重复，修改失败。");
	                }
	                break;
	            default:
	                System.out.println("无效的选择，请重新输入。");
	                break;
	        }
	       
	    }
	public void viewUserShelf( Scanner scanner){
		System.out.println("斗破苍穹");
	}
}