package mvc.dao;

import mvc.dto.UsersDTO;

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

}