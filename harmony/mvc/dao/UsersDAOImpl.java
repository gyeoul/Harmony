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
    public int userInsert(UsersDTO userDTO){
        return 0;
    }

    /**
     * 카드 변경
     * */
    @Override
    public int userCardUpdate(String user_id, String card){
        return 0;
    }

    /**
     * 개인 정보 조회
     */
    @Override
    public UsersDTO userSelect(String user_id) {
        return null;
    }

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