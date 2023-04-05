package mvc.view;

import mvc.dto.MusicalDTO;
import mvc.dto.SeatDTO;
import mvc.dto.TicketDTO;
import mvc.dto.UsersDTO;

import java.util.List;

public class SuccessView {
    /**
     * 성공 메시지 출력
     * */
    public static void messagePrint(String message) {
        System.out.println(message);
    }

    /**
     * 성공한 유저 정보 출력
     * */
    public static void selectByUserIdPrint(UsersDTO userDTO) {
        System.out.println(userDTO);
    }

    /**
     * 뮤지컬 목록 출력
     * */
    public static void selectPrint(List<String> list) {
        System.out.println("\n================================ 뮤지컬 목록 ===================================");
        for(String title  : list) {
            System.out.println(title);
        }
    }

    /**
     * 뮤지컬 상세 조회
     * */
    public static void selectMusicalDetailPrint(MusicalDTO musicalDTO) {
        System.out.printf("\n============================= %s 상세 조회 ================================\n", musicalDTO.getTitle());
        System.out.println(musicalDTO);
    }


    /**
     * 티켓 상세 출력
     * */
    public static void selectTicketDetailPrint(TicketDTO ticketDTO) {
        System.out.printf("\n============================= %s 상세 조회 ================================\n", ticketDTO.getTicketId());
        System.out.println(ticketDTO);
    }

    /**
     * 티켓 목록 출력
     * */
    public static void selectTicketListPrint(List<TicketDTO> ticketDTOS) {
        System.out.println("\n================================ 티켓 목록 ===================================");
        for (TicketDTO ticket :
                ticketDTOS) {
            System.out.println(ticket);
        }
    }
    
    /**
     * 좌석 정보 출력
     * */
    public static void selectSeatListPrint(List<SeatDTO> seatDTOS){
        System.out.println("\n================================ 좌석 정보 ===================================");
        System.out.println(":--------------------------------------------------:");
        for(int i=0; i<5; i++){
            StringBuilder sb = new StringBuilder();
            sb.append("|  ");
            for(int j=0; j<5; j++){
                int idx = 5 * i + j;
                String seatNum = seatDTOS.get(idx).getSeatnum();
                if(seatNum.equals("Y")) sb.append("XX");
                else if(seatNum.equals("X")) sb.append(seatNum);

                sb.append("  |");
            }
            System.out.println(sb.toString());
            System.out.println(":--------------------------------------------------:");
        }
    }
}
