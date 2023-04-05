package mvc.service;

import mvc.dao.MusicalDAO;
import mvc.dao.MusicalDAOImpl;
import mvc.dto.MusicalDTO;
import mvc.dto.SeatDTO;
import mvc.exception.SearchWrongException;
import mvc.view.FailView;
import mvc.view.SuccessView;

import java.util.List;

public class MusicalServiceImpl implements MusicalService{
    private static MusicalService instance = new MusicalServiceImpl();

    private MusicalDAO musicalDAO = MusicalDAOImpl.getInstance();

    private MusicalServiceImpl() {}
    public static MusicalService getInstance() {
        return instance;
    }


    @Override
    public List<String> musicalSelectAll() throws SearchWrongException {
        List<String> musicalList = musicalDAO.musicalSelectAll();
        if(musicalList.size()==0){
            throw new SearchWrongException("조회할 수 있는 뮤지컬이 존재하지 않습니다.");
        }
        return musicalList;

    }

    @Override
    public MusicalDTO musicalDetailSelect(String title) throws SearchWrongException {
        MusicalDTO musical = musicalDAO.musicalDetailSelect(title);
        if(musical == null){
            throw new SearchWrongException("입력에 해당하는 뮤지컬이 존재하지 않습니다.");
        }

        return musical;
    }

    @Override
    public List<SeatDTO> musicalSeatSelect(int musical_id) throws SearchWrongException {
        List<SeatDTO> seatList = musicalDAO.musicalSeatSelect(musical_id);
        if(seatList.size()==0){
            throw new SearchWrongException(musical_id + "에 해당하는 좌석 정보가 존재하지 않습니다.");
        }

        return seatList;
    }
}
