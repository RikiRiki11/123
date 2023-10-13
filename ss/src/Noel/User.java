package Noel;

import java.util.List;

public class User {
	 	private String username;
	    private String phoneNumber;
	    private String password;
	    public String getUsername() {
	        return this.username;
	    }
	    public String getPhoneNumber() {
	        return this.phoneNumber;
	    }
	    public String getPassword() {
	        return this.password;
	    }
	    public User(String username, String phoneNumber, String password) {
	        this.username = username;
	        this.phoneNumber = phoneNumber;
	        this.password = password;
}
	    public  void changePassword(String newPassword) {
	        // 在此处添加逻辑以验证密码强度等
	        this.password = newPassword;
	    }
	    public   boolean changePhoneNumber(String newPhoneNumber, List<User> users) {
	        for (User user : users) {
	            if (user != this && user.getPhoneNumber().equals(newPhoneNumber)) {
	                return false; // 新手机号与其他用户的手机号冲突
	            }
	        }
	        this.phoneNumber = newPhoneNumber;
	        return true;
	    }
}
