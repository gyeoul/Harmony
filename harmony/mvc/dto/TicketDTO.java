package mvc.dto;

public class TicketDTO {
    private int ticketId; // 티켓 아이디 | number
    private String userId; // 유저 아이디 | varchar2(20) (FK - USERS)
    private String seatNum; // 자리 번호 | char(2) (FK - SEAT)
    private int musicalId; // 뮤지컬 아이디 | number (FK - SEAT)
    private String issue; // 예매일 | date

    public TicketDTO() {
    }

    public TicketDTO(int ticketId, String userId, String seatNum, int musicalId, String issue) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.seatNum = seatNum;
        this.musicalId = musicalId;
        this.issue = issue;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public int getMusicalId() {
        return musicalId;
    }

    public void setMusicalId(int musicalId) {
        this.musicalId = musicalId;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TicketDTO{");
        sb.append("ticketId=").append(ticketId);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", seatnum='").append(seatNum).append('\'');
        sb.append(", musicalId=").append(musicalId);
        sb.append(", issue='").append(issue).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
