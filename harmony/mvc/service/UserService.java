package mvc.service;

import mvc.dto.UsersDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

public interface UserService {
    /**
     * 회원 가입
     * @param userDto 회원등록을 시도하는 유저의 정보를 userDTO에 담아 입력
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    void userInsert(UsersDTO userDto) throws DMLException;

    /**
     * 카드 등록/수정
     * @param userID 카드 정보를 수정할 유저의 userID 입력
     * @param card 변경할 카드 값 입력
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    void cardUpdateByUserID(String userID, String card) throws DMLException;

    /**
     * 로그인
     * @param userID 로그인을 시도하는 userID 입력
     * @param userPW 로그인을 시도하는 userPW 입력
     * @throws DMLException DML 쿼리문 실패 Exception
     */
	void login(String userID, String userPW) throws DMLException;

    /**
     * 개인 정보 조회
     * @param userID 조회할 유저의 userID 입력
     * @return 검색한 유저의 정보를 UsersDTO에 담아 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     */
    UsersDTO userInfoSelectByUserID(String userID) throws SearchWrongException;

    /**
     * 비밀번호 변경
     * @param userID 비밀번호를 변경할 유저의 userID 입력
     * @param newPW 변경할 비밀번호 입력
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    void userPWUpdate(String userID, String newPW) throws DMLException;

    /**
     * 유저 이름 변경
     * @param userID 이름을 변경할 유저의 userID 입력
     * @param newName 변경할 이름 입력
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    void userNameUpdateByUserID(String userID, String newName)throws DMLException;
}
