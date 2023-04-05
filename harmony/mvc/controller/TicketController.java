package mvc.controller;


import mvc.dto.TicketDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;
import mvc.service.TicketService;
import mvc.service.TicketServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

import java.util.List;

public class TicketController {
    private static TicketService ticketService = TicketServiceImpl.getInstance();

    /**
     * 예매 등록
     * */
    public static void ticketInsert(TicketDTO ticket)  {
        try{
            ticketService.ticketInsert(ticket);
            SuccessView.messagePrint(ticket.getUserId() +"님, " + ticket.getSeatNum() + " 자리 예매되었습니다");
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 예매 취소
     */
    public static void ticketDelete(int ticketID) {
        try{
            ticketService.ticketDelete(ticketID);
            SuccessView.messagePrint("예매 취소되었습니다");
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 예매 내역 조회
     * */
    public static void ticketSelectById(int ticketID) {
        try{
            List<TicketDTO> ticketList = ticketService.ticketSelectById(ticketID);
            SuccessView.selectTicketByIdPrint(ticketList);
        }catch(SearchWrongException e){
            FailView.errorMessage(e.getMessage());
        }
    }

}
