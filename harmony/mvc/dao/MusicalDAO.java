package mvc.dao;

import mvc.dto.MusicalDTO;
import java.util.List;

public interface MusicalDAO {
    /**
     * 뮤지컬 목록 조회(뮤지컬의 제목 조회)
     * */
    List<Integer> musicalSelectAll();

    /**
     * 뮤지컬 상세 조회
     */
    MusicalDTO musicalDetailSelect(int musical_id);

}