package mvc.dao;

import mvc.dto.TicketDTO;

import java.util.List;

public class TickectDAOImpl implements TickectDAO{
    /**
     * 예매 등록
     * */
    @Override
    public int ticketInsert(String user_id, int musical_id, String seatNum){
        return 0;
    }

    /**
     * 예매 취소
     */
    @Override
    public int deletet(String user_id, int musical_id, String seatNum){
        return 0;
    }

    /**
     * 예매 내역 조회
     * */
    @Override
    public List<TicketDTO> ticketSelectAll(){
        return null;
    }

}