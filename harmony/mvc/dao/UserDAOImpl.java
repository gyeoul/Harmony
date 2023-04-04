package mvc.dao;

import mvc.dto.UsersDTO;

public class UserDAOImpl implements UserDAO {
    /**
     * 회원 가입
     * */
    @Override
    public int userInsert(UsersDTO userDto){
        return 0;
    }

    /**
     * 카드 변경
     * */
    @Override
    public int userCardUpdate(UsersDTO userDto){
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