package mvc.view;

import mvc.dto.*;

import java.util.List;

public class SuccessView {
    /**
     * 성공 메시지 출력
     **/
    public static void messagePrint(String message) {
        System.out.println(message);
    }

    /**
     * 성공한 유저 정보 출력
     **/
    public static void selectByUserIdPrint(UsersDTO userDTO) {
        System.out.println(userDTO);
    }

    /**
     * 뮤지컬 목록 출력
     **/
    public static void selectPrint(List<String> list) {
        System.out.println("\n================================ 뮤지컬 목록 ===================================");
        for(String title  : list) {
            System.out.println(" ▶ " + title);
        }
    }

    /**
     * 뮤지컬 상세 조회
     **/
    public static void selectMusicalDetailPrint(MusicalDTO musicalDTO) {
        System.out.printf("\n============================= 상세 정보 ================================\n");
        System.out.println(musicalDTO);
    }


    /**
     * 티켓 상세 출력
     **/
    public static void selectTicketDetailPrint(TicketDTO ticketDTO) {
        System.out.printf("\n============================= %s 상세 조회 ================================\n", ticketDTO.getTicketId());
        System.out.println(ticketDTO);
    }

    /**
     * 티켓 목록 출력
     **/
    public static void selectTicketListPrint(List<TicketDTO> ticketDTOS) {
        System.out.println("\n================================ 티켓 목록 ===================================");
        for (TicketDTO ticket :
                ticketDTOS) {
            System.out.println(ticket);
        }
    }
    
    /**
     * 좌석 정보 출력 - 5 * 5 좌석표
     **/
    public static void selectSeatListPrint(List<SeatDTO> seatDTOS){
        System.out.println("\n================================ 좌석 정보 ===================================");
        System.out.println(":--------------------------------------------------:");
        for(int i=0; i<5; i++){
            StringBuilder sb = new StringBuilder();
            sb.append("|  ");
            for(int j=0; j<5; j++){
                int idx = 5 * i + j;
                char sold = seatDTOS.get(idx).getSold();
                if(sold == 'Y') sb.append("XX");
                else if(sold == 'N') sb.append(seatDTOS.get(idx).getSeatnum());

                sb.append("  |  ");
            }
            System.out.println(sb.toString());
            System.out.println(":--------------------------------------------------:");
        }
    }

    /**
     * 나의 예매 목록 조회
     **/
    public static void selectMyTicketListPrint(List<MusicalTicketDTO> musicalTicketDTOS) {
        System.out.println("\n================================ 예매 정보 ===================================");

        for (MusicalTicketDTO musicalTicket : musicalTicketDTOS) {
            System.out.println(musicalTicket);
        }
    }

    /**
     * 예매 목록(티켓 예매 번호, 제목) 조회
     **/
    public static void selectMyTicketMusicalTitlePrint(List<MusicalTicketDTO> musicalTicketDTOS) {
        System.out.println("\n================================ 예매 내역 ===================================");

        for (MusicalTicketDTO musicalTicket : musicalTicketDTOS) {
            System.out.println(musicalTicket.getTicketId() + ". " + musicalTicket.getTitle());
        }
    }
}
