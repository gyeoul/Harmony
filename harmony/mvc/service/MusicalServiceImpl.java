package mvc.service;

import mvc.dao.MusicalDAO;
import mvc.dao.MusicalDAOImpl;
import mvc.dto.MusicalDTO;
import mvc.dto.SeatDTO;
import mvc.exception.SearchWrongException;

import java.util.List;

public class MusicalServiceImpl implements MusicalService {
    /**
     * 싱글톤 객체 생성
     */
    private static final MusicalService instance = new MusicalServiceImpl();

    /**
     * 싱글톤 객체 생성을 위해 생성자 private으로 선언
     */
    private final MusicalDAO musicalDAO = MusicalDAOImpl.getInstance();

    /**
     * 싱글톤 객체 반환
     */
    private MusicalServiceImpl() {
    }

    public static MusicalService getInstance() {
        return instance;
    }

    /**
     * 작성자 : 전상희
     * 뮤지컬 차트 조회 - 현재 예매 가능한 뮤지컬 목록
     */
    @Override
    public List<String> musicalSelectAll() throws SearchWrongException {
        List<String> musicalList = musicalDAO.musicalSelectAll();
        if (musicalList.size() == 0) {
            throw new SearchWrongException("조회할 수 있는 뮤지컬이 존재하지 않습니다.");
        }
        return musicalList;

    }

    /**
     * 작성자 : 박창현
     * 뮤지컬의 상세 정보 조회 - 모든 뮤지컬 리스트 반환
     * */
    @Override
    public List<MusicalDTO> musicalSelectByTitle(String title) throws SearchWrongException {
        List<MusicalDTO> musicalList = musicalDAO.musicalSelectByTitle(title);
        if (musicalList.size() == 0) {
            throw new SearchWrongException("조회할 수 있는 뮤지컬이 존재하지 않습니다.");
        }
        return musicalList;

    }

    /**
     * 작성자 : 전상희
     * 뮤지컬의 상세 정보 조회 - 한 개의 뮤지컬의 정보 반환
     */
    @Override
    public MusicalDTO musicalDetailSelect(String title) throws SearchWrongException {
        MusicalDTO musical = musicalDAO.musicalDetailSelect(title);
        if (musical == null) {
            throw new SearchWrongException("입력에 해당하는 뮤지컬이 존재하지 않습니다.");
        }

        return musical;
    }

    /**
     * 작성자 : 전상희
     * 좌석 현황 조회 - 선택한 뮤지컬의 현재 좌석 정보 조회
     */
    @Override
    public List<SeatDTO> musicalSeatSelect(int musical_id) throws SearchWrongException {
        List<SeatDTO> seatList = musicalDAO.musicalSeatSelect(musical_id);
        if (seatList.size() == 0) {
            throw new SearchWrongException(musical_id + "에 해당하는 좌석 정보가 존재하지 않습니다.");
        }

        return seatList;
    }
}
