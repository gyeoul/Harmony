package mvc.service;

import mvc.dao.UsersDAO;
import mvc.dao.UsersDAOImpl;
import mvc.dto.UsersDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

public class UserServiceImpl implements UserService {
    /**
     * 싱글톤 객체 생성
     */
    private static final UserService instance = new UserServiceImpl();

    /**
     * 싱글톤 객체 생성을 위해 생성자 private으로 선언
     */
    private final UsersDAO userDAO = UsersDAOImpl.getInstance();  //가져와서 사용

    /**
     * 싱글톤 객체 반환
     */
    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        return instance;
    }

    /**
     * 회원 가입
     * 작성자 : 이지은
     */
    @Override
    public void userInsert(UsersDTO userDTO) throws DMLException {
        int result = userDAO.userInsert(userDTO);
        if (result == 0)
            throw new DMLException("회원가입에 실패했습니다");
    }

    /**
     * 카드 등록/수정
     * 작성자 :
     */
    @Override
    public void cardUpdateByUserID(String userID, String card) throws DMLException {
        int result = userDAO.cardUpdateByUserID(userID, card);
        if (result == 0)
            throw new DMLException("카드 변경에 실패했습니다");
    }

    /**
     * 로그인
     */
    @Override
    public void login(String userID, String userPW) throws DMLException {
        int result = userDAO.login(userID, userPW);
        if (result == 0) throw new DMLException("회원 정보가 존재하지 않습니다.");
    }

    /**
     * 개인 정보 조회
     */
    @Override
    public UsersDTO userInfoSelectByUserID(String userID) throws SearchWrongException {
        UsersDTO usersDTO = userDAO.userInfoSelectByUserID(userID);
        if (usersDTO == null)
            throw new SearchWrongException("정보가 없습니다.");
        return usersDTO;
    }

    /**
     * 비밀번호 변경
     */
    @Override
    public void userPWUpdate(String userID, String newPW) throws DMLException {
        int result = userDAO.userPWUpdate(userID, newPW);
        if (result == 0)
            throw new DMLException("비밀번호 변경에 실패했습니다");
    }

    /**
     * 이름 변경
     */
    @Override
    public void userNameUpdateByUserID(String userID, String newName) throws DMLException {
        int result = userDAO.userNameUpdate(userID, newName);
        if (result == 0)
            throw new DMLException("이름 변경에 실패했습니다");
    }

}
