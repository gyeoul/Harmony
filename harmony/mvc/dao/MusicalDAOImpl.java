package mvc.dao;

import mvc.dto.MusicalDTO;

import java.util.List;

public class MusicalDAOImpl implements MusicalDAO {
    /**
     * 뮤지컬 목록 조회
     * */
    @Override
    public List<MusicalDTO> musicalSelectAll(){
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