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
     * 뮤지컬 상세 조회
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

    public static int seatSearchByRownumWithTitle(int rownum,String title) {
        List<MusicalDTO> musicalDTOList = musicalService.musicalSelectByTitle(title);
        return musicalDTOList.get(rownum-1).getMusical_id();
    }
}
