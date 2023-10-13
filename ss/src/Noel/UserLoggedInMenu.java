package Noel;

import java.util.Scanner;

public class UserLoggedInMenu {
    private static  User loggedInUser;
    private  UserManager userManager;
    
 // 在 UserLoggedInMenu 中修改密码和手机号的部分
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
            System.out.println("1. 用户资料修改");
            System.out.println("2. 查看我的书架");
            System.out.println("3. 浏览全部小说");
            System.out.println("4. 注销");
            System.out.print("请选择操作: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    // 调用修改密码和手机号码的方法
                	
                	UserManager.changeUserInformation( loggedInUser);
                    break;
                case 2:
                    // 查看书架
                    break;
                case 3:
                    // 浏览小说
                    break;
                case 4:
                    System.out.println("注销成功，返回前台界面。");
                    return; // 返回前台界面
                default:
                    System.out.println("无效的选择，请重新输入。");
                    break;
            }
        }
    }

    // 添加修改用户信息的方法
   
}
