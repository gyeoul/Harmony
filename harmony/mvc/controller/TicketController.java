package mvc.controller;

import mvc.dto.MusicalTicketDTO;
import mvc.dto.TicketDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;
import mvc.service.TicketService;
import mvc.service.TicketServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

import java.util.List;

public class TicketController {
    private static final TicketService ticketService = TicketServiceImpl.getInstance();

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
     **/
    public static void ticketDelete(int ticketID, String userID) {
        try{
            ticketService.ticketDelete(ticketID, userID);
            SuccessView.messagePrint("예매가 취소되었습니다");
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 티켓의 상세 정보
     **/
    public static void ticketSelectByTicketId(int ticketID) {
        try {
            TicketDTO ticketDTO = ticketService.ticketSelectByTicketId(ticketID);
            SuccessView.selectTicketDetailPrint(ticketDTO);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 예매 내역 리스트
     **/
    public static void ticketSelectByUserId(String userID) {
        try{
            List<TicketDTO> ticketList = ticketService.ticketSelectByUserId(userID);
            SuccessView.selectTicketListPrint(ticketList);
        } catch (SearchWrongException e){
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 나의 예매 목록 조회
     **/
    public static void ticketSelectByMine(String userID) {
        try {
            List<MusicalTicketDTO> musicalTicketDTOList = ticketService.ticketSelectByMine(userID);
            SuccessView.selectMyTicketListPrint(musicalTicketDTOList);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 예매 목록(티켓 예매 번호, 제목) 조회
     **/
    public static void ticketSelectMusicalTitle(String userID) {
        try {
            List<MusicalTicketDTO> musicalTicketDTOList = ticketService.ticketSelectByMine(userID);
            SuccessView.selectMyTicketMusicalTitlePrint(musicalTicketDTOList);
         } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
}
