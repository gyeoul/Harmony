package mvc.service;

import mvc.dto.UsersDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

public interface UserService {
    /**
     * 회원 가입
     * */
    void userInsert(UsersDTO userDto) throws DMLException;

    /**
     * 카드 변경
     * */
    void userCardUpdate(String user_id, String card) throws DMLException;

    /**
     * 개인 정보 조회
     */
    UsersDTO userSelect(String user_id) throws SearchWrongException;

	/**
	 * 로그인
	 */
	void login(String user_id, String user_pw) throws DMLException;
    
    
}
