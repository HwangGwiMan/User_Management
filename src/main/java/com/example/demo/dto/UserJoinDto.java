package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserJoinDto {
	
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
