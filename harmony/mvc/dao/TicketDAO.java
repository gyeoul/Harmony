package mvc.dao;

import mvc.dto.MusicalTicketDTO;
import mvc.dto.TicketDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

import java.util.List;

/**
 * 티켓과 관련된 데이터에 접근하기 위한 DAO 객체
 */
public interface TicketDAO {
    /**
     * 예매 등록
     * @param ticket 예매를 시도할 정보를 담은 객체 입력
     * @return 쿼리문의 결과를 int로 반환
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    int ticketInsert(TicketDTO ticket) throws DMLException;

    /**
     * 예매 취소
     * @param ticketID 예매 취소를 시도하는 ticketID 입력
     * @param userID 예매 취소를 시도하는 userID 입력
     * @return 쿼리문의 결과를 int로 반환
     * @throws DMLException DML 쿼리문 실패 Exception
     */
    int ticketDelete(int ticketID, String userID) throws DMLException;

    /**
     * 상세 예매 내역 조회
     * @param ticketID 검색할 ticketID 입력
     * @return 검색한 결과를 TicketDTO
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     */
    TicketDTO ticketSelectByTicketId(int ticketID) throws SearchWrongException;

    /**
     * 유저ID를 통한 예매 내역 조회
     * @param userId 검색할 티켓을 소유한 userID 입력
     * @return List&lt;TicketDTO&gt; 검색 결과들을 TicketDTO에 담아 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     */
    List<TicketDTO> ticketSelectByUserId(String userId) throws SearchWrongException;

    /**
     * 나의 예매 목록 조회
     * @param userID 티켓을 소유한 userID 입력
     * @return List&lt;MusicalTicketDTO&gt; 검색 결과들을 MusicalTicketDTO에 담아 반환
     * @throws SearchWrongException SELECT 쿼리문 실패 Exception
     */
    List<MusicalTicketDTO> ticketSelectByMine(String userID) throws SearchWrongException;
}