package mvc.dto;

public class UsersDTO {
    private String userID; // 유저 아이디 | varchar2(20) (PK)
    private String userPW; // 유저 비밀번호 | varchar2(20)
    private String email; // 이메일 | varchar2(40)
    private String name; // 유저 이름 | varchar2(20)
    private int age; // 나이 | number
    private String gender; // 성별 | char(1) - char 타입의 데이터를 직접적으로 사용하기 위한 메소드를 java에서 지원X -> String으로 재변환 처리 거쳐야 함
    private String card; // 카드 - 결제 수단 | varchar2(20)

    public UsersDTO (){}

    public UsersDTO(String userID, String userPW, String email, String name, int age, String gender, String card) {
        this.userID = userID;
        this.userPW = userPW;
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.card = card;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPW() {
        return userPW;
    }

    public void setUser_pw(String userPW) {
        this.userPW = userPW;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCard(){
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UsersDTO{");
        sb.append("userID='").append(userID).append('\'');
        sb.append(", userPW='").append(userPW).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append('}');
        return sb.toString();
    }
}
