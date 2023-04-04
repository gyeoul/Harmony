package mvc.dao;

import mvc.dto.UsersDTO;

public interface UserDAO {
    /**
     * 회원 가입
     * */
    int userInsert(UsersDTO userDto);

    /**
     * 카드 변경
     * */
    int userCardUpdate(String user_id, String card);

    /**
     * 개인 정보 조회
     */
    UsersDTO userSelect(String user_id);

}