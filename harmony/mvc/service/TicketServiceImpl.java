package mvc.service;

import mvc.dao.TicketDAO;
import mvc.dao.TicketDAOImpl;
import mvc.dto.TicketDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;
import mvc.view.FailView;
import mvc.view.SuccessView;

import java.util.List;

public class TicketServiceImpl implements TicketService{
    private static final TicketService instance = new TicketServiceImpl();

    private final TicketDAO ticketDAO = TicketDAOImpl.getInstance();

    private TicketServiceImpl() {}
    public static TicketService getInstance() {
        return instance;
    }

    /**
     * 예매 등록
     * */
    @Override
    public void ticketInsert(TicketDTO ticket)  {
        try {
            SuccessView.messagePrint(ticketDAO.ticketInsert(ticket) > 0 ? "성공" : "실패");
        } catch (DMLException e){
            FailView.errorMessage(e.getMessage());
        }
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
