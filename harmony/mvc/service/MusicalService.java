package mvc.service;

import mvc.dto.MusicalDTO;
import java.util.List;

import mvc.dto.SeatDTO;
import mvc.exception.SearchWrongException;

/**
 * 뮤지컬을 조회하는 서비스
 */
public interface MusicalService {
    /**
     * 뮤지컬 목록 조회(뮤지컬의 제목 조회)
     * @return List&lt;String&gt; 모든 뮤지컬들의 이름을 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     * */
    List<String> musicalSelectAll() throws SearchWrongException;

    /**
     * 뮤지컬 제목을 기준으로 목록 조회
     * @param title 조회하려는 뮤지컬의 이름을 입력
     * @return List&lt;MusicalDTO&gt; 조회한 뮤지컬들의 정보를 MusicalDTO에 담아 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     * */
    List<MusicalDTO> musicalSelectByTitle(String title) throws SearchWrongException;

    /**
     * 뮤지컬 상세 조회
     * @param title 상세조회하려는 뮤지컬의 이름을 입력
     * @return 조회한 뮤지컬의 정보를 MusicalDTO에 담아 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     */
    MusicalDTO musicalDetailSelect(String title) throws SearchWrongException;

    /**
     * 해당 뮤지컬의 좌석 현황 조회
     * @param musical_id 검색하려는 musical_id를 입력
     * @return List&lt;SeatDTO&gt; 검색한 좌석의 정보를 SeatDTO에 담아 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     * */
    List<SeatDTO> musicalSeatSelect(int musical_id) throws SearchWrongException;
}
