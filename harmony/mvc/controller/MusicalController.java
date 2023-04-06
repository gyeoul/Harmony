package mvc.controller;

import mvc.dto.MusicalDTO;
import mvc.dto.SeatDTO;
import mvc.exception.SearchWrongException;
import mvc.service.MusicalService;
import mvc.service.MusicalServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

import java.util.List;

public class MusicalController {
    private static final MusicalService musicalService = MusicalServiceImpl.getInstance();

    /**
     * 뮤지컬 목록 조회
     * */
    public static void musicalSelectAll(){
        try{
            List<String> musicalList = musicalService.musicalSelectAll();
            SuccessView.selectPrint(musicalList);
        }catch(SearchWrongException e){
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 뮤지컬 상세 조회
     * */
    public static void musicalDetailSelect(String title) {
        try {
            MusicalDTO dto = musicalService.musicalDetailSelect(title);
            SuccessView.selectMusicalDetailPrint(dto);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void musicalSeatSelect(int musical_id){
        try{
            List<SeatDTO> dto = musicalService.musicalSeatSelect(musical_id);
            SuccessView.selectSeatListPrint(dto);
        } catch (SearchWrongException e){
            FailView.errorMessage(e.getMessage());
        }
    }
}
