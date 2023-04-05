package mvc.service;

import mvc.dto.MusicalDTO;
import java.util.List;

import mvc.dto.SeatDTO;
import mvc.exception.SearchWrongException;

public interface MusicalService {
    /**
     * 뮤지컬 목록 조회(뮤지컬의 제목 조회)
     * */
    List<String> musicalSelectAll() throws SearchWrongException;

    /**
     * 뮤지컬 상세 조회
     */
    MusicalDTO musicalDetailSelect(int musical_id) throws SearchWrongException;

    /**
     * 해당 뮤지컬의 좌석 현황 조회
     * */
    public List<SeatDTO> musicalSeatSelect(int musical_id) throws SearchWrongException;
}
