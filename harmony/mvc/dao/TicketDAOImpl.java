package mvc.dao;

import mvc.common.DBManager;
import mvc.dto.TicketDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    private static TicketDAO instance = new TicketDAOImpl();

    /**
     * 외부에서 객체 생성 막음
     **/
    private TicketDAOImpl() {
    }

    public static TicketDAO getInstance() {
        return instance;
    }

    /**
     * 예매 등록
     **/
    @Override
    public int ticketInsert(TicketDTO ticket){
        return 0;
    }

    /**
     * 예매 취소
     **/
    @Override
    public int ticketDelete(int ticketID){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from ticket where ticket_id = ?"; // SQL 문 수정 필요
        int result = 0;

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ticketID);

            int seatNum = searchSeatNum(con, ticketID); // 해당 티켓의 좌석 번호
            cancelSeat(con, seatNum); // 해당 티켓의 좌석 공석으로 전환

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(con, ps);
        }

        return result;
    }

    /**
     * 예매 내역 조회
     **/
    @Override
    public List<TicketDTO> ticketSelectAll(){
        return null;
    }

    /**
     * 개별 유저 예매 내역 조회
     **/
    @Override
    public List<TicketDTO> ticketSelectById(int ticketID) {
        return null;
    }

    private int searchSeatNum(Connection con, int ticketID) throws SQLException { // 티켓의 좌석 번호 조회
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select seatnum from ticket where ticket_id = ?";
        int seatNum = 0;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ticketID);

            rs = ps.executeQuery();

            if (rs.next()) {
                seatNum = rs.getInt("seatnum");
            }
        } finally {
            DBManager.releaseConnection(null, ps);
        }

        return seatNum;
    }

    private int cancelSeat(Connection con, int seatNo) throws SQLException { // 티켓의 좌석 공석으로 전환
        PreparedStatement ps = null;
        String sql = "update seat set sold = ? where seatnum = ?";
        int result = 0;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "N");
            ps.setInt(2, seatNo);

            result = ps.executeUpdate();
        } finally {
            DBManager.releaseConnection(null, ps);
        }

        return result;
    }
}