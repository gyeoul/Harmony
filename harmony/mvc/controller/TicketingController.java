package mvc.controller;

import mvc.dto.MusicalDTO;
import mvc.exception.SearchWrongException;
import mvc.service.MusicalService;
import mvc.service.MusicalServiceImpl;
import mvc.view.FailView;

import java.util.List;

public class TicketingController {
    private static final MusicalService musicalService = MusicalServiceImpl.getInstance();

    /**
     * 뮤지컬 목록을 선택할 수 있도록 목록 제공하는 메소드
     * 작성: 박창현
     * @param title 검색할 title:String을 입력
     */
    public static void searchByTitle(String title) {
        try {
            List<MusicalDTO> musicalDTOList = musicalService.musicalSelectByTitle(title);
            int row = 1;
            for (MusicalDTO dto : musicalDTOList) {
                System.out.printf("%d: %s %s\n", row++, dto.getTitle(), dto.getDate());
            }
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 목록에서 번호를 입력받아 뮤지컬 id를 제공하는 메소드
     * 작성: 박창현
     * @param rownum :int searchByTitle에서 제공된 목록중 선택한 번호
     * @param title 검색할 title:String을 입력
     * @return MusicalID:int
     */
    public static int seatSearchByRownumWithTitle(int rownum, String title) {
        List<MusicalDTO> musicalDTOList = musicalService.musicalSelectByTitle(title);
        return musicalDTOList.get(rownum - 1).getMusical_id();
    }
}
