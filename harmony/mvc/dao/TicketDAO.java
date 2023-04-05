package mvc.dao;

import mvc.dto.TicketDTO;

import java.util.List;

public interface TicketDAO {
    /**
     * 예매 등록
     * String user_id, int musical_id, String seatNum
     * */
    int ticketInsert(TicketDTO ticket);

    /**
     * 예매 취소
     * String user_id, int musical_id, String seatNum
     */
    int ticketDelete(int ticketID);

    /**
     * 예매 내역 조회
     * */
    TicketDTO ticketSelectByTicketId(int ticketID);

    /**
     * 예매 내역 조회
     * */
    List<TicketDTO> ticketSelectByUserId(String userId);


}