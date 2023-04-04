package mvc.dto;

public class TicketDTO {
    private int ticket_id; // 티켓 아이디 | number
    private String user_id; // 유저 아이디 | varchar2(20) (FK - USERS)
    private String seatnum; // 자리 번호 | char(2) (FK - SEAT)
    private int musical_id; // 뮤지컬 아이디 | number (FK - SEAT)
    private String date; // 예매일 | date

    public TicketDTO(){}

    public TicketDTO(int ticket_id, String user_id, String seatnum, int musical_id, String date) {
        this.ticket_id = ticket_id;
        this.user_id = user_id;
        this.seatnum = seatnum;
        this.musical_id = musical_id;
        this.date = date;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(String seatnum) {
        this.seatnum = seatnum;
    }

    public int getMusical_id() {
        return musical_id;
    }

    public void setMusical_id(int musical_id) {
        this.musical_id = musical_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TicketDTO{");
        sb.append("ticket_id=").append(ticket_id);
        sb.append(", user_id='").append(user_id).append('\'');
        sb.append(", seatnum='").append(seatnum).append('\'');
        sb.append(", musical_id=").append(musical_id);
        sb.append(", date='").append(date).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
