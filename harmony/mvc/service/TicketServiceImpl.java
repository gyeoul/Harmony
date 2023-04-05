package mvc.service;

import mvc.dao.TicketDAO;
import mvc.dao.TicketDAOImpl;
import mvc.dto.TicketDTO;
import mvc.exception.SearchWrongException;

import java.util.List;

public class TicketServiceImpl implements TicketService{
    private static TicketService instance = new TicketServiceImpl();

    private TicketDAO ticketDAO = TicketDAOImpl.getInstance();

    private TicketServiceImpl() {}
    public static TicketService getInstance() {
        return instance;
    }

    /**
     * 예매 등록
     * */
    @Override
    public void ticketInsert(TicketDTO ticket)  {

    }

    /**
     * 예매 취소
     */
    @Override
    public void ticketDelete(int ticketID) {

    }

    /**
     * 개별 유저 예매 내역 조회
     * */
    @Override
    public List<TicketDTO> ticketSelectById(int ticketID){
        return null;
    }
}
