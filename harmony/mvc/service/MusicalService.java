package mvc.service;

import mvc.dto.MusicalDTO;
import java.util.List;

import mvc.dto.SeatDTO;
import mvc.exception.SearchWrongException;

public interface MusicalService {
    /**
     * 뮤지컬 목록 조회(뮤지컬의 제목 조회)
     * @throws SearchWrongException;
     * @return List&lt;String&gt;
     * */
    List<String> musicalSelectAll() throws SearchWrongException;

    /**
     * 뮤지컬 제목을 기준으로 목록 조회
     * @param title String
     * @throws SearchWrongException;
     * @return List&lt;MusicalDTO&gt;
     * */
    List<MusicalDTO> musicalSelectByTitle(String title) throws SearchWrongException;

    /**
     * 뮤지컬 상세 조회
     * @param title String
     * @throws SearchWrongException;
     * @return MusicalDTO
     */
    MusicalDTO musicalDetailSelect(String title) throws SearchWrongException;

    /**
     * 해당 뮤지컬의 좌석 현황 조회
     * @param musical_id 검색할 뮤지컬id값(int)
     * @throws SearchWrongException;
     * @return List&lt;SeatDTO&gt;
     * */
    List<SeatDTO> musicalSeatSelect(int musical_id) throws SearchWrongException;
}
