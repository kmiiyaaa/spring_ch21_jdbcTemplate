package com.kmii.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kmii.member.dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired // DI -> 컨테이너에 생성된 bean(객체)를 자동 주입
	JdbcTemplate jdbcTemplate ; // template라고도 쓴다
	
	//insert문 구현 = 회원추가
	public void insertMember(String memberid, String memberpw, String membername, int memberage) {  //DB에 회원 추가 // void대신 int넣고
		String sql = "INSERT INTO membertbl VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, memberid,memberpw,membername,memberage);  // int result = ~ 으로 해도됨
		
		
	}
	
	//delete문 구현 = 회원삭제
	public void deleteMember(String memberid) {  
		String sql = "DELETE FROM membertbl WHERE memberid = ?";
		jdbcTemplate.update(sql, memberid); 
		//삭제성공하면1, 실패하면0
	}
	
	
	//update문 구현 = 회원정보 수정
	public void updateMember(String memberid, String memberpw, String membername, int memberage) {
		String sql = "UPDATE membertbl SET memberpw=?, membername=? , memberage=? WHERE memberid = ?";
		jdbcTemplate.update(sql, memberid,memberpw, membername, memberage);
		// 정보수정한 레코드 수를 반환 (기본키로 검색 -> 성공1, 실패0)
	}
	
	//select문 구현 = 회원한명 가져오기
	public MemberDto searchMember(String memberid) {
		String sql = "SELECT * FROM membertbl WHERE memberid=?";
		MemberDto mDto = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class),memberid);  //이렇게 하려면 필드이름과 dto의 이름이 같아야한다
		return mDto;               //한명은 queryForObject
		
		//위 두줄 대신 / return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class),memberid); 해도된다.
		
	}
	
	
	//Select문 구현 - 전체 회원 가져오기
		public List<MemberDto> searchMembers() {
			String sql = "SELECT * FROM membertbl";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class));
			//return mDto;
		}
	

}
