package mvc.dao;

import mvc.dto.MusicalDTO;
import mvc.dto.SeatDTO;

import java.util.List;

/**
 * 뮤지컬과 관련된 데이터에 접근하기 위한 DAO 객체
 * 작성자 : 이지은, 전상희
 */
public interface MusicalDAO {
    /**
     * 뮤지컬 목록 조회(뮤지컬의 제목 조회)
     * @return List&lt;String&gt; 조회한 뮤지컬의 제목을 반환
     * */
    List<String> musicalSelectAll();

    /**
     * 뮤지컬 상세 조회
     * @param title 조회할 뮤지컬의 이름 입력
     * @return MusicalDTO 조회한 뮤지컬의 DTO객체를 반환
     */
    MusicalDTO musicalDetailSelect(String title);


    /**
     * 해당 뮤지컬의 좌석 현황 조회
     * @param musical_id 조회할 뮤지컬의 id값 입력
     * @return List&lt;SeatDTO&gt; 조회한 좌석 목록 전체를 SeatDTO에 담아 반환
     * */
    List<SeatDTO> musicalSeatSelect(int musical_id);

    /**
     *
     * @param title 검색할 뮤지컬 제목값 입력
     * @return List&lt;MusicalDTO&gt; 검색된 뮤지컬들의 목록을 MusicalDTO에 담아 반환
     */
    List<MusicalDTO> musicalSelectByTitle(String title);
}