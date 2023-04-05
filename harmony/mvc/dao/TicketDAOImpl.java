package mvc.dao;

import mvc.common.DBManager;
import mvc.dto.TicketDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    private static TicketDAO instance = new TicketDAOImpl();

    /**
     * 외부에서 객체생성 막음
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
}