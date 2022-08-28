package org.project.dto;
	//DataBase Transfer Object
public class MemberDto {
	
	//필드
	private String userId;
	private String userPw;
	private String userName;
	private String userBirthday;
	private String userPhone;
	
	//생성자
	public MemberDto(String userId, String userPw, String userName, String userBirthday, String userPhone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirthday = userBirthday;
		this.userPhone = userPhone;
	}

	//getter, setter 메소드
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	
}
