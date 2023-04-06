package mvc.dto;

/**
 * 티켓의 정보를 저장하는 객체
 * ticketId:int, userId:String, seatNum:String, musicalId:int, issue:String
 * 작성자 : 전상희
 */
public class TicketDTO {
    /**
     * 티켓 아이디 | number
     */
    private int ticketId;
    /**
     * 유저 아이디 | varchar2(20) (FK - USERS)
     */
    private String userId;
    /**
     * 자리 번호 | char(2) (FK - SEAT)
     */
    private String seatNum;
    /**
     * 뮤지컬 아이디 | number (FK - SEAT)
     */
    private int musicalId;
    /**
     * 예매일 | date
     */
    private String issue;

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
