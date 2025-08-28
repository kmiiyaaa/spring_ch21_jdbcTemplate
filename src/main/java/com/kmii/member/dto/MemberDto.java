package com.kmii.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MemberDto {
	
	private String memeberid;
	private String memberpw;
	private String membername;
	private int memberage;

}
