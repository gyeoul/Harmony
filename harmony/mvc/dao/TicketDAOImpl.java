package mvc.dao;

import mvc.common.DBManager;
import mvc.dto.TicketDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    private static final TicketDAO instance = new TicketDAOImpl();

    /**
     * 외부에서 객체생성 막음
     */
    private TicketDAOImpl() {
    }

    public static TicketDAO getInstance() {
        return instance;
    }

    /**
     * 예매 등록
     **/
    @Override
    public int ticketInsert(TicketDTO ticket) {
        Connection con = null;
        PreparedStatement ps = null;
//        ResultSet rs = null;
        String sql = "insert into TICKET (TICKET_ID, USER_ID, SEATNUM, MUSICAL_ID, ISSUE) values (?,?,?,?,SYSDATE);";
        int result = 0;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ticket.getTicketId());
            ps.setString(2, ticket.getUserId());
            ps.setString(3, ticket.getSeatNum());
            ps.setInt(4, ticket.getMusicalId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(con, ps);
        }
        return result;
    }

    /**
     * 예매 취소
     **/
    @Override
    public int ticketDelete(int ticketID) {
        Connection con = null;
        PreparedStatement ps = null;
//        String sql = "delete from ticket where musical_id = ?"; // SQL 문 수정 필요
        int result = 0;

        try {
            con = DBManager.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, musical_id);

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(con, ps);
        }

        return result;
    }

    /**
     * 개별 유저 예매 내역 조회
     **/
    @Override
    public TicketDTO ticketSelectByTicketId(int ticketID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from TICKET where TICKET_ID=?";
        TicketDTO result = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ticketID);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = new TicketDTO(
                        rs.getInt("TICKET_ID"),
                        rs.getString("USER_ID"),
                        rs.getString("SEATNUM"),
                        rs.getInt("MUSICAL_ID"),
                        rs.getString("ISSUE")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }
        return result;
    }

    @Override
    public List<TicketDTO> ticketSelectByUserId(String userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from TICKET where USER_ID=?";
        List<TicketDTO> result = new ArrayList<>();
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                result.add(new TicketDTO(
                        rs.getInt("TICKET_ID"),
                        rs.getString("USER_ID"),
                        rs.getString("SEATNUM"),
                        rs.getInt("MUSICAL_ID"),
                        rs.getString("ISSUE")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }
        return result;
    }
}