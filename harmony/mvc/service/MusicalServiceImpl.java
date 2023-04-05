package mvc.service;

import mvc.dao.MusicalDAO;
import mvc.dao.MusicalDAOImpl;
import mvc.dto.MusicalDTO;
import mvc.exception.SearchWrongException;

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
        return null;
    }

    @Override
    public MusicalDTO musicalDetailSelect(int musical_id) throws SearchWrongException {
        return null;
    }
}
