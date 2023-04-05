package mvc.dao;

import mvc.dto.MusicalDTO;

import java.util.List;

public class MusicalDAOImpl implements MusicalDAO {
    private static MusicalDAO instance = new MusicalDAOImpl();

    /**
     * 외부에서 객체생성 막음
     */
    private MusicalDAOImpl() {
    }

    public static MusicalDAO getInstance() {
        return instance;
    }

    /**
     * 뮤지컬 목록 조회
     * */
    @Override
    public List<String> musicalSelectAll(){
        return null;
    }

    /**
     * 뮤지컬 상세 조회
     */
    @Override
    public MusicalDTO musicalDetailSelect(int musical_id){
        return null;
    }

}