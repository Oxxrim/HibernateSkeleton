package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@Column(name = "login", length = 50)
	private String login;

	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@Column(name = "birth_day")
	private Long birthDay;

	@Column(name = "first_name", length = 100)
	private String firstname;

	@Column(name = "second_name", length = 100)
	private String secondname;

	public Account() {

	}

	public Account(String login, String password, Long birthDay, String firstname, String secondname) {
		this.login = login;
		this.password = password;
		this.birthDay = birthDay;
		this.firstname = firstname;
		this.secondname = secondname;
	}

}
