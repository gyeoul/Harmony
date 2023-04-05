package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.common.DBManager;
import mvc.dto.UsersDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

public class UsersDAOImpl implements UsersDAO {
    private static UsersDAO instance = new UsersDAOImpl();

    /**
     * 외부에서 객체생성 막음
     */
    private UsersDAOImpl() {
    }

    public static UsersDAO getInstance() {
        return instance;
    }

    /**
     * 회원 가입
     * */
    @Override
    public int userInsert(UsersDTO userDTO) throws DMLException{
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into users (user_id, user_pw, email, name, age, gender, card)")
           .append("values(?, ?, ?, ?, ?, ?, ?)");
        
        try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql.toString());
			
			ps.setString(1, userDTO.getUser_id());
			ps.setString(2, userDTO.getUser_pw());
			ps.setString(3, userDTO.getEmail());
			ps.setString(4, userDTO.getName());
			ps.setInt(5, userDTO.getAge());
			ps.setString(6, userDTO.getGender());
			ps.setString(7, userDTO.getCard());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new DMLException("등록하는데 오류가 발생하여 등록되지 않았습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
    	return result;
    }

    /**
     * 카드 변경
     * */
    @Override
    public int userCardUpdate(String user_id, String card) throws DMLException{
    	Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update users set card = ? where user_id = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, card);
			ps.setString(2, user_id);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new DMLException("카드번호 수정하는데 문제가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
    	return result;
    }

    /**
     * 개인 정보 조회
     */
    @Override
    public UsersDTO userSelect(String user_id) {
        return null;
    }

	/**
	 * 로그인
	 */
	@Override
	public int login(String user_id, String user_pw) throws DMLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "select * from users where user_id = ? and user_pw = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_pw);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
// 			e.printStackTrace();
			throw new DMLException("로그인에 문제가 발생했습니다.");
			
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}
    
}