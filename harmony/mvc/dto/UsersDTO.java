package mvc.dto;

public class UsersDTO {
    private String user_id; // 유저 아이디 | varchar2(20) (PK)
    private String user_pw; // 유저 비밀번호 | varchar2(20)
    private String email; // 이메일 | varchar(40)
    private String name; // 유저 이름 | varchar2(20)
    private int age; // 나이 | number
    private char gender; // 성별
    private String card; // 카드 - 결제 수단

    public UsersDTO (){}

    public UsersDTO(String user_id, String user_pw, String email, String name, int age, char gender, String card) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.card = card;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
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
        sb.append("user_id='").append(user_id).append('\'');
        sb.append(", user_pw='").append(user_pw).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append('}');
        return sb.toString();
    }
}
