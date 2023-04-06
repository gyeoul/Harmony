package mvc.dao;

import mvc.dto.UsersDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

public interface UsersDAO {
    /**
     * 회원 가입
     * @param userDTO 회원가입을 시도하는 회원의 정보를 객체로 입력
     * @return 쿼리문의 결과를 int로 반환
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    int userInsert(UsersDTO userDTO) throws DMLException;

    /**
     * 카드 등록/수정
     * @param userID 카드 정보를 수정할 유저 id
     * @param card 수정할 카드 정보(String)
     * @return 쿼리문의 결과를 int로 반환
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    int cardUpdateByUserID(String userID, String card) throws DMLException;

    /**
     * 로그인
     * @param userID 로그인을 시도하는 유저 id
     * @param userPW 로그인을 시도하는 유저 password
     * @return 쿼리문의 결과를 int로 반환
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    int login(String userID, String userPW) throws DMLException;

    /**
     * 개인 정보 조회
     * @param userID 정보를 조회할 유저 id
     * @return 쿼리문의 결과를 int로 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     */
    UsersDTO userInfoSelectByUserID(String userID) throws SearchWrongException;

    /**
     * 비밀번호 변경
     * @param userID 비밀번호를 수정할 유저 id
     * @param newPW 수정할 비밀번호 값
     * @return 쿼리문의 결과를 int로 반환
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    int userPWUpdate(String userID, String newPW) throws DMLException;

    /**
     * 이름 변경
     * */
    int userNameUpdate(String userID, String newName) throws DMLException;


}