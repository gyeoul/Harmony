package mvc.service;

import mvc.dto.MusicalTicketDTO;
import mvc.dto.TicketDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

import java.util.List;

public interface TicketService {
    /**
     * 예매 등록
     * @param ticket 구매할 티켓값이 입력된 TicketDTO
     * @throws DMLException insert 오류
     **/
    void ticketInsert(TicketDTO ticket) throws DMLException;

    /**
     * 예매 취소
     * @param ticketID
     * @param userID
     **/
    void ticketDelete(int ticketID, String userID) throws DMLException;

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 티켓의 상세 정보
     **/
    TicketDTO ticketSelectByTicketId(int ticketID) throws SearchWrongException;

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 예매 내역 리스트
     **/
    List<TicketDTO> ticketSelectByUserId(String userID) throws SearchWrongException;

    /**
     * 나의 예매 목록 조회
     **/
    List<MusicalTicketDTO> ticketSelectByMine(String userID) throws SearchWrongException;
}
