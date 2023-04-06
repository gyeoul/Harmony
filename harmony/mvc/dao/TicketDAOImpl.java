package mvc.dao;

import mvc.common.DBManager;
import mvc.dto.MusicalTicketDTO;
import mvc.dto.TicketDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    /**
     * 싱글톤 객체 생성
     */
    private static final TicketDAO instance = new TicketDAOImpl();


    /**
     * 싱글톤 객체 생성을 위해 생성자 private으로 선언
     */
    private TicketDAOImpl() {
    }

    /**
     * 싱글톤 객체 반환
     */
    public static TicketDAO getInstance() {
        return instance;
    }

    /**
     * 예매 등록
     * 작성자 : 박창현
     **/
    @Override
    public int ticketInsert(TicketDTO ticket) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into TICKET (TICKET_ID, USER_ID, SEATNUM, MUSICAL_ID, ISSUE) values (TICKET_ID_SEQ.nextval,?,?,?,SYSDATE)";
        int result = 0;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ticket.getUserId());
            ps.setString(2, ticket.getSeatNum());
            ps.setInt(3, ticket.getMusicalId());
            result = ps.executeUpdate();
            updateSeat(con, ticket.getSeatNum(), ticket.getMusicalId(), 'Y');
        } catch (SQLException e) {
            throw new DMLException("뮤지컬 예매 중 오류가 발생했습니다.");
        } finally {
            DBManager.releaseConnection(con, ps);
        }
        return result;
    }

    /**
     * 예매 취소
     **/
    @Override
    public int ticketDelete(int ticketID, String userID) {
        Connection con = null;
        PreparedStatement ps = null;

        StringBuilder sql = new StringBuilder();
        sql.append("delete from ticket ");
        sql.append("where (user_id = ?) ");
        sql.append("and (ticket_id = ?) ");
        sql.append("and (to_char((select musical_date ");
        sql.append("from musical m, ticket t ");
        sql.append("where m.musical_id = t.musical_id ");
        sql.append("and ticket_id = ?), 'YYYY-MM-DD HH:MI:SS') ");
        sql.append(">= to_char(sysdate - 1/24/3, 'YYYY-MM-DD HH:MI:SS'))"); // 뮤지컬 공연 시간 20 분 전까지만 취소 가능

        TicketDTO ticketDTO;
        int result = 0;

        try {
            ticketDTO = ticketSelectByTicketId(ticketID);
            String seatNum = ticketDTO.getSeatNum(); // 해당 티켓의 좌석 번호
            int musicalID = ticketDTO.getMusicalId(); // 해당 티켓(예매한 뮤지컬)의 뮤지컬 아이디

            con = DBManager.getConnection();
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, userID);
            ps.setInt(2, ticketID);
            ps.setInt(3, ticketID);

            result = ps.executeUpdate();

            updateSeat(con, seatNum, musicalID, 'N'); // 해당 티켓의 좌석 공석으로 전환
        } catch (SQLException e) {
            throw new DMLException("예매 취소 중 오류가 발생했습니다.");
        } finally {
            DBManager.releaseConnection(con, ps);
        }

        return result;
    }

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 티켓의 상세 정보
     **/
    @Override
    public TicketDTO ticketSelectByTicketId(int ticketID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from TICKET where TICKET_ID = ?";

        TicketDTO ticketDTO = null;

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ticketID);
            rs = ps.executeQuery();

            if (rs.next()) {
                ticketDTO = new TicketDTO(
                        rs.getInt("TICKET_ID"),
                        rs.getString("USER_ID"),
                        rs.getString("SEATNUM"),
                        rs.getInt("MUSICAL_ID"),
                        rs.getString("ISSUE")
                );
            }

        } catch (SQLException e) {
            throw new SearchWrongException("예매 목록 조회 중 오류가 발생했습니다.");
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }

        return ticketDTO;
    }

    /**
     * 개별 유저 예매 내역 조회 - 유저가 예매한 예매 내역 리스트
     **/
    @Override
    public List<TicketDTO> ticketSelectByUserId(String userID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from TICKET where USER_ID = ?";

        List<TicketDTO> ticketDTOList = new ArrayList<>();

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();

            while (rs.next()) {
                ticketDTOList.add(new TicketDTO(
                        rs.getInt("TICKET_ID"),
                        rs.getString("USER_ID"),
                        rs.getString("SEATNUM"),
                        rs.getInt("MUSICAL_ID"),
                        rs.getString("ISSUE")
                ));
            }
        } catch (SQLException e) {
            throw new SearchWrongException("예매 목록 조회 중 오류가 발생했습니다.");
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }

        return ticketDTOList;
    }

    /**
     * 나의 예매 목록 조회
     **/
    @Override
    public List<MusicalTicketDTO> ticketSelectByMine(String userID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MusicalTicketDTO> musicalTicketDTOList = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("select t.user_id, t.ticket_id, t.musical_id, t.seatnum, t.issue, ");
        sql.append("title, hall, musical_date ");
        sql.append("from ticket t, musical m ");
        sql.append("where (t.musical_id = m.musical_id) ");
        sql.append("and user_id = ?");

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, userID);

            rs = ps.executeQuery();

            while (rs.next()) {
                musicalTicketDTOList.add(new MusicalTicketDTO(
                        rs.getInt("ticket_id"),
                        rs.getString("user_id"),
                        rs.getString("seatnum"),
                        rs.getInt("musical_id"),
                        rs.getString("issue"),
                        rs.getString("title"),
                        rs.getString("musical_date"),
                        rs.getString("hall")
                ));
            }
        } catch (SQLException e) {
            throw new SearchWrongException("예매 목록 조회 중 예외가 발생했습니다.");
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }

        return musicalTicketDTOList;
    }

    private void updateSeat(Connection con, String seatNum, int musicalID, char setValue) throws SQLException { // 티켓의 좌석 공석으로 전환
        PreparedStatement ps = null;
        String sql = "update seat set sold = ? where (seatnum = ?) and (musical_id = ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Character.toString(setValue));
            ps.setString(2, seatNum);
            ps.setInt(3, musicalID);

            ps.executeUpdate();
        } finally {
            DBManager.releaseConnection(null, ps);
        }
    }
}