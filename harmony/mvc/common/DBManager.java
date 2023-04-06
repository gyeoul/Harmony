package mvc.common;

import java.sql.*;

public class DBManager {
    /*
     * 데이터베이스 드라이버 로드
     */
    static {
        try {
            Class.forName(DBProperties.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터베이스 세션 생성
     * @return java.sql.Connection()
     * @throws SQLException 데이터베이스 연결 오류
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBProperties.URL, DBProperties.USER_ID, DBProperties.USER_PASS);
    }

    /**
     * 데이터베이스 세션 종료(DML,DDL)
     * @param con java.sql.Connection()
     * @param st java.sql.Statement / java.sql.PreparedStatement
     */
    public static void releaseConnection(Connection con, Statement st) {
        try {
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터베이스 세션 종료(DQL)
     * @param con java.sql.Connection()
     * @param st java.sql.Statement / java.sql.PreparedStatement
     * @param rs java.sql.ResultSet
     */
    public static void releaseConnection(Connection con, Statement st, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        releaseConnection(con, st);
    }
}
