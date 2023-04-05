package mvc.dao;

import mvc.dto.MusicalDTO;
import mvc.dto.SeatDTO;

import java.util.List;

public interface MusicalDAO {
    /**
     * 뮤지컬 목록 조회(뮤지컬의 제목 조회)
     * */
    List<String> musicalSelectAll();

    /**
     * 뮤지컬 상세 조회
     */
    MusicalDTO musicalDetailSelect(String title);


    /**
     * 해당 뮤지컬의 좌석 현황 조회
     * */
    List<SeatDTO> musicalSeatSelect(int musical_id);
}