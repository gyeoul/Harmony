package mvc.dao;

import mvc.dto.TicketDTO;

import java.util.List;

public interface TickectDAO {
    /**
     * 예매 등록
     * */
    int ticketInsert(String user_id, int musical_id, String seatNum);

    /**
     * 예매 취소
     */
    int ticketDelete(String user_id, int musical_id, String seatNum);

    /**
     * 예매 내역 조회
     * */
    List<TicketDTO> ticketSelectAll();

}