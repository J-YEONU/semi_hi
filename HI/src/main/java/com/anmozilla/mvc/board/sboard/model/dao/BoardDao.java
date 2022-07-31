package com.anmozilla.mvc.board.sboard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.anmozilla.mvc.common.jdbc.JDBCTemplate.*;

import com.anmozilla.mvc.member.model.vo.Member;
import com.anmozilla.mvc.board.sboard.model.vo.Board;
import com.anmozilla.mvc.board.sboard.model.vo.Language;
import com.anmozilla.mvc.board.sboard.model.vo.Test;

public class BoardDao {
<<<<<<< HEAD

=======
// !!!!!!!!!!!!! 민주 !!!!!!!!!!!!!!
>>>>>>> PARK
	public Board getsBoardByNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String query = "SELECT s.S_NO, s.S_WRITER_NO, s.S_WRITE_DATE, s.S_TITLE, s.S_CONTENT, s.S_DUE_DATE, CASE s.S_MEMBER WHEN -1 THEN '미정' WHEN 1 THEN s.S_MEMBER || '개월' WHEN 2 THEN s.S_MEMBER || '개월' WHEN 3 THEN s.S_MEMBER || '개월' WHEN 4 THEN s.S_MEMBER || '개월' ELSE s.S_MEMBER || '개월' END AS S_MEMBER, CASE s.S_MEMBER WHEN -1 THEN '미정' WHEN 1 THEN s.S_MEMBER || '명' WHEN 2 THEN s.S_MEMBER || '명' WHEN 3 THEN s.S_MEMBER || '명' WHEN 4 THEN s.S_MEMBER || '명' WHEN 5 THEN s.S_MEMBER || '명' ELSE s.S_MEMBER || '명' END AS S_MEMBER, m.MEM_NICKNAME s_Writer_Nickname, l.L_TYPE, t.TEST_TYPE FROM STUDY s JOIN MEM_LIST m ON s.S_WRITER_NO = m.MEM_NO JOIN LANGUAGE l ON s.L_NO = l.L_NO JOIN TEST t ON s.TEST_NO = t.TEST_NO WHERE s.S_NO = ? AND s.S_STATUS = 'Y'";
		String query = "SELECT \r\n"
				+ "	s.S_NO,\r\n"
				+ "	s.S_WRITER_NO,\r\n"
				+ "	s.S_WRITE_DATE,\r\n"
				+ "	s.S_TITLE,\r\n"
				+ "	s.S_CONTENT,\r\n"
				+ "	s.S_DATE,\r\n"
				+ "	s.S_DUE_DATE,\r\n"
				+ "	CASE s.S_PERIOD \r\n"
				+ "	    WHEN -1 THEN '미정'\r\n"
				+ "		WHEN 1 THEN s.S_PERIOD || '개월'\r\n"
				+ "		WHEN 2 THEN s.S_PERIOD || '개월'\r\n"
				+ "		WHEN 3 THEN s.S_PERIOD || '개월'\r\n"
				+ "		WHEN 4 THEN s.S_PERIOD || '개월'\r\n"
				+ "		ELSE s.S_PERIOD || '개월'\r\n"
				+ "	END AS S_PERIOD,\r\n"
				+ " 	CASE s.S_MEMBER\r\n"
				+ "	 	WHEN -1 THEN '미정'\r\n"
				+ "		WHEN 1 THEN s.S_MEMBER || '명'\r\n"
				+ "		WHEN 2 THEN s.S_MEMBER || '명'\r\n"
				+ "		WHEN 3 THEN s.S_MEMBER || '명'\r\n"
				+ "		WHEN 4 THEN s.S_MEMBER || '명'\r\n"
				+ "		WHEN 5 THEN s.S_MEMBER || '명'\r\n"
				+ "		ELSE s.S_MEMBER || '명'\r\n"
				+ "	END AS S_MEMBER,\r\n"
				+ "	s.S_CONTACT,\r\n"
				+ "	s.S_LEVEL,"
				+ "	m.MEM_NICKNAME s_Writer_Nickname, \r\n"
				+ "	l.L_TYPE, \r\n"
				+ "	t.TEST_TYPE \r\n"
				+ "FROM \r\n"
				+ "	STUDY s JOIN MEM_LIST m \r\n"
				+ "ON s.S_WRITER_NO = m.MEM_NO JOIN LANGUAGE l \r\n"
				+ "ON s.L_NO = l.L_NO JOIN TEST t \r\n"
				+ "ON s.TEST_NO = t.TEST_NO \r\n"
				+ "WHERE \r\n"
				+ "	s.S_NO = ?\r\n"
				+ "AND\r\n"
				+ "s.S_STATUS = 'Y'";

		Board board = null;
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new Board();
				
				board.setSNo(rs.getInt("S_NO"));
				
				Member member = new Member();
				member.setNo(rs.getInt("S_WRITER_NO"));
				
				board.setSWriteDate(rs.getDate("S_WRITE_DATE"));
				board.setSTitle(rs.getString("S_TITLE"));
				board.setSContent(rs.getString("S_CONTENT"));
				board.setSDate(rs.getDate("S_DATE"));
				board.setSDueDate(rs.getDate("S_DUE_DATE"));
				board.setSPeriod(rs.getString("S_PERIOD"));
				board.setSMember(rs.getString("S_MEMBER"));
				board.setSContact(rs.getString("S_CONTACT"));
				board.setSLevel(rs.getString("S_LEVEL"));
				board.setSStatus(rs.getString("S_STATUS"));
				member.setNickName(rs.getString("s_Writer_Nickname"));
				board.setMember(member);
				
				
				Language language = new Language();
				language.setLType(rs.getString("L_TYPE"));
				board.setLanguage(language);
				
				Test test = new Test();
				test.setTestType(rs.getString("TEST_TYPE"));
				board.setTest(test);

	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return board;
	}

	public int insertStudy(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO STUDY (\r\n"
				+ "    S_NO,\r\n"
				+ "    S_WRITER_NO,\r\n"
				+ "    S_WRITE_DATE,\r\n"
				+ "    S_TITLE,\r\n"
				+ "    S_CONTENT,\r\n"
				+ "    S_DATE,\r\n"
				+ "    S_DUE_DATE,\r\n"
				+ "    S_MEMBER,\r\n"
				+ "    S_PERIOD,\r\n"
				+ "    S_CONTACT,\r\n"
				+ "    S_LEVEL,\r\n"
				+ "    S_STATUS,\r\n"
				+ "    L_NO,\r\n"
				+ "    TEST_NO\r\n"
				+ ") VALUES ( \r\n"
				+ "    SEQ_STUDY_NO.NEXTVAL,\r\n"
				+ "    ?,\r\n"
				+ "    DEFAULT,\r\n"
				+ "    ?,\r\n"
				+ "    ?,\r\n"
				+ "    to_date(?, 'yyyy-mm-dd'),\r\n"
				+ "    to_date(?, 'yyyy-mm-dd'),\r\n"
				+ "    ?,\r\n"
				+ "    ?,\r\n"
				+ "    ?,\r\n"
				+ "    ?,\r\n"
				+ "    DEFAULT,\r\n"
				+ "    ?,\r\n"
				+ "    ?\r\n"
				+ ")";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getMember().getNo());
			pstmt.setString(2, board.getSTitle());
			pstmt.setString(3, board.getSContent());
			
//			pstmt.setDate(4, (java.sql.Date) board.getSDate());
//			pstmt.setDate(5, (java.sql.Date) board.getSDueDate());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sDate = sdf.format(board.getSDate());
			String sDueDate = sdf.format(board.getSDueDate());
			pstmt.setString(4, sDate);
			pstmt.setString(5, sDueDate);
			
			pstmt.setString(6, board.getSMember());
			pstmt.setString(7, board.getSPeriod());
			pstmt.setString(8, board.getSContact());
			pstmt.setString(9, board.getSLevel());
			pstmt.setInt(10, board.getLanguage().getLNo());
			pstmt.setInt(11, board.getTest().getTestNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE STUDY SET S_STATUS = 'N' WHERE S_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public List<Board> selectAllBoard(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String query = "SELECT \r\n"
				+ "	s.S_NO,\r\n"
				+ "	s.S_WRITER_NO,\r\n"
				+ "	s.S_WRITE_DATE,\r\n"
				+ "	s.S_TITLE,\r\n"
				+ "	s.S_CONTENT,\r\n"
				+ "	s.S_DATE,\r\n"
				+ "	s.S_DUE_DATE,\r\n"
				+ "	CASE s.S_PERIOD \r\n"
				+ "	    WHEN -1 THEN '미정'\r\n"
				+ "		WHEN 1 THEN s.S_PERIOD || '개월'\r\n"
				+ "		WHEN 2 THEN s.S_PERIOD || '개월'\r\n"
				+ "		WHEN 3 THEN s.S_PERIOD || '개월'\r\n"
				+ "		WHEN 4 THEN s.S_PERIOD || '개월'\r\n"
				+ "		ELSE s.S_PERIOD || '개월'\r\n"
				+ "	END AS S_PERIOD,\r\n"
				+ " CASE s.S_MEMBER\r\n"
				+ "	 	WHEN -1 THEN '미정'\r\n"
				+ "		WHEN 1 THEN s.S_MEMBER || '명'\r\n"
				+ "		WHEN 2 THEN s.S_MEMBER || '명'\r\n"
				+ "		WHEN 3 THEN s.S_MEMBER || '명'\r\n"
				+ "		WHEN 4 THEN s.S_MEMBER || '명'\r\n"
				+ "		WHEN 5 THEN s.S_MEMBER || '명'\r\n"
				+ "		ELSE s.S_MEMBER || '명'\r\n"
				+ "	END AS S_MEMBER,\r\n"
				+ "	s.S_CONTACT,\r\n"
				+ "	s.S_LEVEL,"
				+ "	m.MEM_NICKNAME s_Writer_Nickname, \r\n"
				+ "	l.L_TYPE, \r\n"
				+ "	t.TEST_TYPE \r\n"
				+ "FROM \r\n"
				+ "	STUDY s JOIN MEM_LIST m \r\n"
				+ "ON s.S_WRITER_NO = m.MEM_NO JOIN LANGUAGE l \r\n"
				+ "ON s.L_NO = l.L_NO JOIN TEST t \r\n"
				+ "ON s.TEST_NO = t.TEST_NO \r\n"
				+ "WHERE \r\n"
				+ "s.S_STATUS = 'Y' \r\n"
				+ "ORDER BY \r\n"
				+ "s.S_WRITE_DATE ASC";
		Board board = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new Board();
				board.setSNo(rs.getInt("S_NO"));
				
				Member member = new Member();
				member.setNo(rs.getInt("S_WRITER_NO"));
				
				board.setSWriteDate(rs.getDate("S_WRITE_DATE"));
				board.setSTitle(rs.getString("S_TITLE"));
				board.setSContent(rs.getString("S_CONTENT"));
				board.setSDate(rs.getDate("S_DATE"));
				board.setSDueDate(rs.getDate("S_DUE_DATE"));
				board.setSPeriod(rs.getString("S_PERIOD"));
				board.setSMember(rs.getString("S_MEMBER"));
				board.setSContact(rs.getString("S_CONTACT"));
				board.setSLevel(rs.getString("S_LEVEL"));
				board.setSStatus(rs.getString("S_STATUS"));
				member.setNickName(rs.getString("s_Writer_Nickname"));
				board.setMember(member);
				
				
				Language language = new Language();
				language.setLType(rs.getString("L_TYPE"));
				board.setLanguage(language);
				
				Test test = new Test();
				test.setTestType(rs.getString("TEST_TYPE"));
				board.setTest(test);
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	

}