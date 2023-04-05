package mvc.dao;

import mvc.common.DBManager;
import mvc.dto.MusicalDTO;
import mvc.dto.SeatDTO;
import mvc.exception.SearchWrongException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicalDAOImpl implements MusicalDAO {
    private static final MusicalDAO instance = new MusicalDAOImpl();

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
        List<String> musicalList = new ArrayList<>(); // title들을 list에 담아 return
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select distinct title from musical where musical_date >= sysdate order by TITLE"; // 정렬 - 상영일 지난 영화는 조회 X

        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                String title = rs.getString("title");
                musicalList.add(title);
            }
        } catch (SQLException e) {
            throw new SearchWrongException("뮤지컬 목록 조회에 문제가 발생했습니다. 다시 조회해주세요.");
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }

        return musicalList;
    }

    /**
     * 뮤지컬 상세 조회
     */
    @Override
    public MusicalDTO musicalDetailSelect(String title){
        MusicalDTO musical = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from musical where title = ?";

        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, title);
            rs = ps.executeQuery();

            if(rs.next()){
                musical = new MusicalDTO(rs.getInt("musical_id"), rs.getString("title"),
                        rs.getString("actor"), rs.getString("genre"), rs.getString("musical_date"),
                        rs.getString("hall"), rs.getString("summary"), rs.getString("production"));
            }
        } catch(SQLException e){
            throw new SearchWrongException("뮤지컬 " + title + "의 상세 정보 조회에 오류가 발생했습니다. 정확한 제목을 입력해주세요");
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }

        return musical;
    }

    /**
     * 해당 뮤지컬의 좌석 현황 조회
     * */
    @Override
    public List<SeatDTO> musicalSeatSelect(int musical_id) {
        List<SeatDTO> seatList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from seat where musical_id = ?";

        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, musical_id);
            rs = ps.executeQuery();

            while(rs.next()){
                SeatDTO seat = new SeatDTO(rs.getString("seatnum"), rs.getInt("musical_id"),
                        rs.getString("sold").toCharArray()[0], rs.getInt("price"));
                seatList.add(seat);
            }
        } catch(NumberFormatException e){
            throw new SearchWrongException("숫자만 입력해주세요.");
        } catch(SQLException e){
            throw new SearchWrongException(musical_id + "번 뮤지컬의 좌석 정보 조회에 문제가 발생했습니다. 정확한 번호를 입력해주세요.");
        } finally
         {
            DBManager.releaseConnection(con, ps, rs);
        }

        return seatList;
    }


    /**
     * 중복을 제외한 뮤지컬 이름 조회
     * */
    @Override
    public List<String> musicalTitleDistinctList() {
        List<String> result = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select DISTINCT TITLE from MUSICAL";

        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                result.add(rs.getString(1));
            }
        } catch(SQLException e){
            e.printStackTrace(); // TODO 테스트 후 지울 것
            throw new SearchWrongException("뮤지컬 리스트 조회에 오류가 발생했습니다.");
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }

        return result;
    }

    /**
     * 뮤지컬 목록 조회
     * */
    @Override
    public List<MusicalDTO> musicalSelectByTitle(String title){
        List<MusicalDTO> musicalList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from musical where musical_date >= sysdate AND TITLE=?";

        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1,title);
            rs = ps.executeQuery();
            while(rs.next()){
                musicalList.add(
                        new MusicalDTO(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8)
                                )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace(); // TODO 테스트 후 지울 것
            throw new SearchWrongException("뮤지컬 목록 조회에 오류가 발생했습니다.");
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }

        return musicalList;
    }
}