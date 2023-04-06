package mvc.service;

import mvc.dto.MusicalTicketDTO;
import mvc.dto.TicketDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

import java.util.List;

/**
 * 작성자 : 박상희, 박창현
 * 티켓을 생성, 조회, 수정, 삭제하는 서비스
 */
public interface TicketService {
    /**
     * 예매 등록
     * @param ticket 예매하려는 정보를 TicketDTO에 담아 입력
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    void ticketInsert(TicketDTO ticket) throws DMLException;

    /**
     * 예매 취소
     * @param ticketID 예매를 취소하려는 ticketID 입력
     * @param userID 티켓을 보유한 userID 입력
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    void ticketDelete(int ticketID, String userID) throws DMLException;

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 티켓의 상세 정보
     * @param ticketID 검색하려는 ticketID:int 입력
     * @return 조회한 유저의 티켓을 TicketDTO에 담아 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     */
    TicketDTO ticketSelectByTicketId(int ticketID) throws SearchWrongException;

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 예매 내역 리스트
     * @param userID 검색하려는 유저의 userID:String 입력
     * @return 조회한 유저의 티켓을 TicketDTO에 담아 목록을 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     */
    List<TicketDTO> ticketSelectByUserId(String userID) throws SearchWrongException;

    /**
     * 나의 예매 목록 조회
     * @param userID 검색하려는 유저의 userID:String 입력
     * @return 조회한 뮤지컬과 티켓의 정보를 MusicalTicketDTO에 담아 목록을 반티켓
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     */
    List<MusicalTicketDTO> ticketSelectByMine(String userID) throws SearchWrongException;
}
