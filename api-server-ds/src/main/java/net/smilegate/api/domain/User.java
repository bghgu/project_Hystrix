package net.smilegate.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Spring Data JPA
 * User Domain
 * Table name = user
 * 자주 이클립스가 Lombok lib를 찾지 못해 아예 Lombok을 사용하지 않음
 * @author dsbae
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_idx;
	
	private String name;
	private String email;
	
	public User() {}
	
	public User(final String name, final String email) {
		this.user_idx = 0;
		this.name = name;
		this.email = email;
	}
	
	public int getuser_idx() {
		return user_idx;
	}
	
	public void setuser_idx(final int user_idx) {
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
