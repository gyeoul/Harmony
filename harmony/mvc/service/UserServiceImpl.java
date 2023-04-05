package mvc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.common.DBManager;
import mvc.dao.UsersDAO;
import mvc.dao.UsersDAOImpl;
import mvc.dto.UsersDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

public class UserServiceImpl implements UserService{
    private static UserService instance = new UserServiceImpl();

    private UsersDAO userDAO = UsersDAOImpl.getInstance();  //가져와서 사용

    private UserServiceImpl() {}
    public static UserService getInstance() {
        return instance;
    }

    /**
     * 회원 가입
     * */
    @Override
    public void userInsert(UsersDTO userDTO) throws DMLException {
        int result = userDAO.userInsert(userDTO);
        if(result == 0)
            throw new DMLException("회원가입에 실패했습니다");
    }

    /**
     * 카드 변경
     * */
    @Override
    public void userCardUpdate(String user_id, String card) throws DMLException{
        int result = userDAO.userCardUpdate(user_id, card);
        if(result == 0)
            throw new DMLException("카드 변경에 실패했습니다");
    }

    /**
     * 개인 정보 조회
     */
    @Override
    public UsersDTO userSelect(String user_id) throws SearchWrongException {
       return null;
    }
    
    
    /**
     * 로그인
     */
    @Override
    public void login(String user_id, String user_pw) throws DMLException{
    	int result = userDAO.login(user_id, user_pw);
    	if(result == 0) throw new DMLException("회원 정보가 존재하지 않습니다.");
	}
}
