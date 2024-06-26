package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String address;
	private String role;
	
	@Override
	public String toString() {
		return "id="+id+
			   ",pw="+pw+
			   ",name="+name+
			   ",phone"+phone+
			   ",address="+address+
			   ",role="+role;
	}
}
