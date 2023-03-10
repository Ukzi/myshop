package com.myshop.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.myshop.constant.ItemSellStatus;
import com.myshop.constant.Role;
import com.myshop.dto.MemberFormDto;

import lombok.*;


@Entity
@Table(name="member") //테이블 명 설정
@Getter
@Setter
@ToString
public class Member {
	
	@Id
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String address;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		member.setAddress(memberFormDto.getAddress());
		
		String password = passwordEncoder.encode(memberFormDto.getPassword()); //비밀번호 암호화
		member.setPassword(password);
		member.setRole(Role.USER);
		
		return member;
		
	}
}
