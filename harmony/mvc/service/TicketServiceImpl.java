package mvc.service;

import mvc.dao.TicketDAO;
import mvc.dao.TicketDAOImpl;
import mvc.dto.MusicalTicketDTO;
import mvc.dto.TicketDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

import java.util.List;

public class TicketServiceImpl implements TicketService {
    /**
     * 싱글톤 객체 생성
     */
    private static final TicketService instance = new TicketServiceImpl();

    /**
     * 싱글톤 객체 생성을 위해 생성자 private으로 선언
     */
    private final TicketDAO ticketDAO = TicketDAOImpl.getInstance();

    /**
     * 싱글톤 객체 반환
     */
    private TicketServiceImpl() {
    }

    public static TicketService getInstance() {
        return instance;
    }

    /**
     * 예매 등록
     * 작성자 : 박창현
     **/
    @Override
    public void ticketInsert(TicketDTO ticket) throws DMLException {
        int result = ticketDAO.ticketInsert(ticket);

        if (result == 0) {
            throw new DMLException("예매에 실패했습니다.");
        }
    }

    /**
     * 예매 취소
     **/
    @Override
    public void ticketDelete(int ticketID, String userID) throws DMLException {
        int result = ticketDAO.ticketDelete(ticketID, userID);

        if (result == 0) {
            throw new DMLException("예매 취소에 실패했습니다.");
        }
    }

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 티켓의 상세 정보
     * 작성자 : 박상희
     **/
    @Override
    public TicketDTO ticketSelectByTicketId(int ticketID) {
        TicketDTO ticketDTO = ticketDAO.ticketSelectByTicketId(ticketID);

        if (ticketDTO == null) {
            throw new SearchWrongException("예매 번호와 일치하는 예매 내역이 없습니다.");
        }

        return ticketDTO;
    }

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 예매 내역 리스트
     **/
    @Override
    public List<TicketDTO> ticketSelectByUserId(String userId) throws SearchWrongException {
        List<TicketDTO> ticketDTOList = ticketDAO.ticketSelectByUserId(userId);

        if (ticketDTOList.size() == 0) {
            throw new SearchWrongException("사용자 정보와 일치하는 예매 내역이 없습니다.");
        }

        return ticketDTOList;
    }

    /**
     * 나의 예매 목록 조회
     * 작성자 : 박상희
     **/
    @Override
    public List<MusicalTicketDTO> ticketSelectByMine(String userID) throws SearchWrongException {
        List<MusicalTicketDTO> musicalTicketDTOList = ticketDAO.ticketSelectByMine(userID);

        if (musicalTicketDTOList.size() == 0) {
            throw new SearchWrongException("예매 정보가 없습니다.");
        }

        return musicalTicketDTOList;
    }
}
