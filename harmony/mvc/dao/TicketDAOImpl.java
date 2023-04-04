package mvc.dao;

import mvc.dto.TicketDTO;

import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    private static TicketDAO instance = new TicketDAOImpl();

    /**
     * 외부에서 객체생성 막음
     */
    private TicketDAOImpl() {
    }

    public static TicketDAO getInstance() {
        return instance;
    }

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
    public int ticketDelete(String user_id, int musical_id, String seatNum){
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