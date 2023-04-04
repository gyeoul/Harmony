package mvc.dto;

public class MusicalDTO {
    private int musical_id; // 뮤지컬 아이디 | number (PK)
    private String title; // 제목 | varchar2(20)
    private String actor; // 배우 | varchar2(80)
    private String genre; // 장르 | varchar2(80)
    private String date; // 상영일 | date
    private String hall; // 상영홀 | varchar2(20)
    private String summary; // 줄거리 | varchar2(255)

    public MusicalDTO(){}

    public MusicalDTO(int musical_id, String title, String actor, String genre, String date, String hall, String summary) {
        this.musical_id = musical_id;
        this.title = title;
        this.actor = actor;
        this.genre = genre;
        this.date = date;
        this.hall = hall;
        this.summary = summary;
    }

    public int getMusical_id() {
        return musical_id;
    }

    public void setMusical_id(int musical_id) {
        this.musical_id = musical_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MusicalDTO{");
        sb.append("musical_id=").append(musical_id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", actor='").append(actor).append('\'');
        sb.append(", genre='").append(genre).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", hall='").append(hall).append('\'');
        sb.append(", summary='").append(summary).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
