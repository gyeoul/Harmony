package mvc.dao;

import mvc.dto.UsersDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

public interface UsersDAO {
    /**
     * 회원 가입
     * */
    int userInsert(UsersDTO userDTO) throws DMLException;

    /**
     * 카드 등록/수정
     * */
    int cardUpdateByUserID(String userID, String card) throws DMLException;

    /**
     * 로그인
     */
    int login(String userID, String userPW) throws DMLException;

    /**
     * 개인 정보 조회
     * */
    UsersDTO userInfoSelectByUserID(String userID) throws SearchWrongException;

    /**
     * 비밀번호 변경
     * */
    int userPWUpdate(String userID, String newPW) throws DMLException;

    /**
     * 이름 변경
     * */
    int userNameUpdate(String userID, String newName) throws DMLException;


}