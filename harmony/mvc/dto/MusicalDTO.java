package mvc.dto;

public class MusicalDTO {
    private int musical_id; // 뮤지컬 아이디 | number (PK)
    private String title; // 제목 | varchar2(20)
    private String actor; // 배우 | varchar2(80)
    private String genre; // 장르 | varchar2(80)
    private String date; // 상영일 | date
    private String hall; // 상영홀 | varchar2(20)
    private String summary; // 줄거리 | varchar2(255)
    private String production; // 제작사 | varchar2(20)

    public MusicalDTO(){}

    public MusicalDTO(int musical_id, String title, String actor, String genre, String date, String hall, String summary, String production) {
        this.musical_id = musical_id;
        this.title = title;
        this.actor = actor;
        this.genre = genre;
        this.date = date;
        this.hall = hall;
        this.summary = summary;
        this.production = production;
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

    public String getProduction() { return production; }

    public void setProduction(String production) { this.production = production; }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("< 뮤지컬 " + title + " >");
        sb.append("\n상영관 | " + hall);
        sb.append("\n배우  | " + actor);
        sb.append("\n장르  | " + genre);
        sb.append("\n소개  | " + summary);
        sb.append("\n제작사 | " + production);
        sb.append("");
        return sb.toString();
    }
}
