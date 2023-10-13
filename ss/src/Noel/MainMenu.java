package Noel;

import java.util.Scanner;

public class MainMenu {
	private static User currentUser;
    public static void main(String[] args) {
    	UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            
            System.out.println("1. 用户登录");
            System.out.println("2. 用户注册");
            System.out.println("3. 管理员登录");
            System.out.println("4. 退出系统");
            System.out.print("请选择操作: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // 用户登录功能
                	  System.out.print("请输入手机号码: ");
                      String phoneNumber = scanner.next();
                      System.out.print("请输入密码: ");
                      String password = scanner.next();
                      User loggedInUser = userManager.loginUser(phoneNumber, password);
                      if (loggedInUser != null) {
                          System.out.println("登录成功，欢迎 " + loggedInUser.getUsername());
                          // 在这里可以执行用户登录成功后的操作
                          UserLoggedInMenu.showMenu();
                      } else {
                          System.out.println("登录失败，手机号码或密码不正确");
                      }
                      
                     break;
                case 2:
                    // 用户注册功能
                	System.out.print("请输入用户名: ");
                    String username = scanner.next();
                    System.out.print("请输入手机号码: ");
                    String phoneNumber1 = scanner.next();
                    System.out.print("请输入密码: ");
                    String password1 = scanner.next();
                   UserManager.registerUser(username, phoneNumber1, password1);
                    break;
                case 3:
                    // 管理员登录功能
                    System.out.println("管理员登录功能尚未实现。");
                    break;
                case 4:
                    // 退出系统
                    System.out.println("谢谢使用，再见！");
                    isRunning = false;
                    break;
                default:
                    System.out.println("无效的选项，请重新选择。");
            }
        }
        scanner.close();
    }
}