package com.example.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends Repository<User, String> {

	@Modifying
	@Query("INSERT INTO user (id, pw, name, phone, address, role) VALUES(:id, :pw , :name, :phone, :address, :role)")
	@Transactional
	User save(@Param("id") String id, @Param("pw") String pw, @Param("name") String name, @Param("phone") String phone, @Param("address") String address, @Param("role") String role);

}
