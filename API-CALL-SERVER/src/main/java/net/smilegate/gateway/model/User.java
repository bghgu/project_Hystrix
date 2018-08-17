package net.smilegate.gateway.model;

/**
 * Request Model Response Model
 * 가끔 이클립스 Lombok 인식 안되서 Lombok 사용 안함
 * @author dsbae
 *
 */
public class User {

	private int user_idx;
	private String name;
	private String email;

	public User() {
	}

	public User(final int user_idx, final String name, final String email) {
		this.user_idx = user_idx;
		this.name = name;
		this.email = email;
	}

	public User(final String name, final String email) {
		this.user_idx = 0;
		this.name = name;
		this.email = email;
	}

	public int getUseridx() {
		return user_idx;
	}

	public void setUseridx(final int user_idx) {
		this.user_idx = user_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}
}
