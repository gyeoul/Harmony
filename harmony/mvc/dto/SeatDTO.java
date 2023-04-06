package mvc.dto;

/**
 * 좌석의 정보를 저장하는 객체
 * seatnum:String, musical_id:int, sold:char, price:int
 * 작성자 : 전상희
 */
public class SeatDTO {
    /**
     * 자리 번호 | char(2) (PK - TICKET)
     */
    private String seatnum;
    /**
     * 뮤지컬 아이디 | number (PK - TICKET | FK - MUSICAL)
     */
    private int musical_id;
    /**
     * 예약 여부 | char
     */
    private char sold;
    /**
     * 가격 | number
     */
    private int price;

    public SeatDTO() {
    }

    public SeatDTO(String seatnum, int musical_id, char sold, int price) {
        this.seatnum = seatnum;
        this.musical_id = musical_id;
        this.sold = sold;
        this.price = price;
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

    public char getSold() {
        return sold;
    }

    public void setSold(char sold) {
        this.sold = sold;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SeatDTO{");
        sb.append("seatnum='").append(seatnum).append('\'');
        sb.append(", musical_id=").append(musical_id);
        sb.append(", sold=").append(sold);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
