package mvc.dto;

public class MusicalTicketDTO {
    private int ticketId; // 티켓 아이디 | number
    private String userId; // 유저 아이디 | varchar2(20) (FK - USERS)
    private String seatNum; // 자리 번호 | char(2) (FK - SEAT)
    private int musicalId; // 뮤지컬 아이디 | number (FK - SEAT)
    private String issue; // 예매일 | date
    private String title; // 제목 | varchar2(20)
    private String date; // 상영일 | date
    private String hall; // 상영홀 | varchar2(20)

    public MusicalTicketDTO() {

    }

    public MusicalTicketDTO(int ticketId, String userId, String seatNum, int musicalId, String issue, String title, String date, String hall) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.seatNum = seatNum;
        this.musicalId = musicalId;
        this.issue = issue;
        this.title = title;
        this.date = date;
        this.hall = hall;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "MusicalTicketDTO{" +
                "ticketId=" + ticketId +
                ", userId='" + userId + '\'' +
                ", seatNum='" + seatNum + '\'' +
                ", musicalId=" + musicalId +
                ", issue='" + issue + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", hall='" + hall + '\'' +
                '}';
    }
}
