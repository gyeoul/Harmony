package mvc.dao;

import mvc.dto.UsersDTO;

public class UserDAOImpl implements UserDAO {
    private static UserDAO instance = new UserDAOImpl();

    /**
     * 외부에서 객체생성 막음
     */
    private UserDAOImpl() {
    }

    public static UserDAO getInstance() {
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
    public UsersDTO userSelect(String user_id){
        return null;
    }

}