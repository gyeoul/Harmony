package mvc.service;

import mvc.dto.TicketDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

import java.util.List;

public interface TicketService {
    /**
     * 예매 등록
     **/
    void ticketInsert(TicketDTO ticket) throws DMLException;

    /**
     * 예매 취소
     **/
    void ticketDelete(int ticketID) throws DMLException;

    /**
     * 개별 유저 예매 내역 조회
     **/
    TicketDTO ticketSelectByTicketId(int ticketID) throws SearchWrongException;


    List<TicketDTO> ticketSelectByUserId(String userId) throws SearchWrongException;
}
