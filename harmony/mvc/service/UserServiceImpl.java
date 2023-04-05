package mvc.service;

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
    public void userCardUpdate(String userID, String card) throws DMLException{
        int result = userDAO.userCardUpdate(userID, card);
        if(result == 0)
            throw new DMLException("카드 변경에 실패했습니다");
    }

    /**
     * 개인 정보 조회
     */
    @Override
    public UsersDTO userSelect(String userID) throws SearchWrongException {
       return null;
    }
    
    
    /**
     * 로그인
     */
    @Override
    public void login(String userID, String userPW) throws DMLException{
    	int result = userDAO.login(userID, userPW);
    	if(result == 0) throw new DMLException("회원 정보가 존재하지 않습니다.");
	}

    /**
     * 개인 정보 조회
     * */
    @Override
    public UsersDTO userInfoSelectByUserID(String userID) throws SearchWrongException{
        UsersDTO usersDTO = userDAO.userInfoSelectByUserID(userID);
        if(usersDTO == null)
            throw new SearchWrongException("정보가 없습니다.");
        return usersDTO;
    }

    /**
     * 비밀번호 변경
     * */
    @Override
    public void userPWUpdate(String userID, String newPW) throws DMLException{
        int result = userDAO.userPWUpdate(userID, newPW);
        if(result == 0)
            throw new DMLException("비밀번호 변경에 실패했습니다");
    }

    /**
     * 이름 변경
     * */
    @Override
    public void userNameUpdate(String userID, String newName) throws DMLException{
        int result = userDAO.userPWUpdate(userID, newName);
        if(result == 0)
            throw new DMLException("이름 변경에 실패했습니다");
    }

}
