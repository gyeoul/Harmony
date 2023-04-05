package mvc.view;

import java.util.Scanner;

import mvc.controller.MusicalController;
import mvc.controller.TicketController;
import mvc.controller.UserController;
import mvc.dto.UsersDTO;

public class MenuView {
    static Scanner sc = new Scanner(System.in);
    static String userID; //현재 사용자

    /**
     * 로그인/회원가입 선택
     * */
    public static void userCheck(){
        while (true) {
            System.out.println("로그인하시겠습니까?");
            System.out.print("(1) 로그인  | ");
            System.out.print("(2) 회원가입  | ");
            System.out.println("(3) 종료 ");
            System.out.print("메뉴를 선택해주세요 >> ");
            try {
                int num = Integer.parseInt(sc.nextLine());
                switch (num) {
                    case 1: //로그인시
                        login();
                        break;
                    case 2: //회원가입
                        joinMember();
                        break;
                    case 3: //종료
                        System.out.println("방문해주셔서 감사합니다. 다음에 또 오세요~");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("메뉴에 없는 숫자가 입력되었습니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자 입력만 가능합니다. 다시 입력해주세요.");
            }
        }
    }
    /**
     * 메뉴 선택
     */
    public static void menuChoice() {

        while (true) {
            System.out.println("\n==================================================================================");
            System.out.print(" (1) 예매  | ");
            System.out.print("(2) 뮤지컬 차트  | ");
            System.out.print("(3) 예매 내역 확인  | ");
            System.out.print("(4) 예매 취소  | ");
            System.out.print("(5) 마이페이지 ");
            System.out.print("(6) 종료 ");
            System.out.println("\n==================================================================================");
            System.out.print("메뉴를 선택해주세요 >> ");
            try {
                int menu = Integer.parseInt(sc.nextLine());
                switch (menu) {
                    case 1: //예매
                        ticketing();
                        break;
                    case 2: //뮤지컬 차트 조회
                        musicalSelectAll();
                        break;
                    case 3: //예매 내역 확인
                        ticketSelectByUserID();
                        break;
                    case 4: //예매 취소
                        ticketDelete();
                        break;
                    case 5: //마이 페이지
                        userInfoUpdate();
                        break;
                    case 6: //종료
                        System.out.println("다음에 또 오세요~ 로그아웃됩니다...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("메뉴에 없는 숫자가 입력되었습니다. 다시 입력해주세요.");
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자 입력만 가능합니다. 다시 입력해주세요");
            }
        } // while end
    }

    /**
     * try/catch 이용해서 작성
     * */

    /**
     * 로그인
     * try에서는
     * 1. 아이디와 패스워드를 입력 받고
     * 2. 아이디와 패스워드 정보 비교 후 옳으면 로그인되도록
     * 3. 로그인 후 menuChoice(); 로 넘어갈 수 있도록
     *
     * catch에서는
     * 틀렸다고 알려주고 다시 로그인으로 돌아가도록
     *
     * KB_DBBoard_template에서 글번호 검색하는 부분 참고
     * */
    public static void login(){
			System.out.print("ID를 입력하시오 : ");
            userID = sc.nextLine();
			
			System.out.print("PassWord를 입력하시오 : ");
			String pw = sc.nextLine();
			
			UserController.login(userID, pw);
			menuChoice();
    }
    
    public static void loginChoice() {
    	 System.out.println("로그인을 다시 시도하고 싶다면 '1', 회원가입을 하고 싶다면 '2'를 입력하세요.");

    	 int choiceNUM = Integer.parseInt(sc.nextLine());
    	 switch (choiceNUM) {
    	 	case 1:
    	 		login(); // 로그인으로 이동 
    	 		break; 
    	 	case 2 : 
    	 		joinMember(); // 회원가입으로 이동 
    	 		break;
    	 	default:
    	 		System.out.println("잘못된 숫자를 입력하셨습니다, 다시 입력해주세요!");
    	 }
    }

    /**
     * 회원가입
     * KB_DBBoard_template에서 등록하는 부분 참고
     * */
    public static void joinMember(){
    	System.out.print("사용할 ID를 입력하시오 : ");
    	String id = sc.nextLine();
    	
    	System.out.print("사용할 PassWord를 입력하시오 : ");
    	String pw = sc.nextLine();
    	
    	System.out.print("등록할 Email을 입력하시오 : ");
    	String email = sc.nextLine();
    	
    	System.out.print("자신의 이름을 입력하시오 : ");
    	String name = sc.nextLine();
    	
    	System.out.print("자신의 나이를 입력하시오 : ");
    	int age = Integer.parseInt(sc.nextLine());
    	
    	System.out.print("자신의 성별을 입력하시오 (남성인 경우 'M'/여성인 경우 'W') : ");
    	String gender = sc.nextLine();
    	
    	System.out.print("사용할 카드의 카드번호를 입력하시오 : ");
    	String card = sc.nextLine();
    	
    	UsersDTO user = new UsersDTO(id, pw, email, name, age, gender, card);
    	UserController.userInsert(user);
    }

    /**
     * 1. 예매
     * */
    public static void ticketing(){

    }


    /**
     * 2. 뮤지컬 차트 조회
     * */
    public static void musicalSelectAll(){
        MusicalController.musicalSelectAll();

        System.out.print("상세 정보를 열람하고 싶은 뮤지컬의 제목을 입력해주세요: ");
        String input = sc.nextLine();

        try{
            MusicalController.musicalDetailSelect(input);
            System.out.println("\n==================================================================================");
            System.out.println("    (1) 뮤지컬 목록으로 돌아가기    |    (2) 메인 메뉴로 돌아가기");
            System.out.println("==================================================================================");
            System.out.print("메뉴를 선택해주세요 >> ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: // 뮤지컬 목록으로 돌아가기
                    musicalSelectAll();
                    break;
                case 2: // 메인 메뉴로 돌아가기
                    menuChoice();
                    break;
                default:
                    System.out.println("숫자만 입력해주세요.");
            }
        } catch (Exception e){
            System.out.println("잘못된 입력입니다.");
        }
    }

    /**
     * 3.예매 내역 확인
     * */
    public static void ticketSelectByUserID(){
        TicketController.ticketSelectByMine(userID);
    }

    /**
     * 5. 마이페이지
     * */
    public static void userInfoUpdate(){
        while(true) {
            try {
                System.out.println("\n==================================================================================");
                System.out.print(" (1) 비밀번호 변경  | ");
                System.out.print("(2) 이름 변경  | ");
                System.out.print("(3) 카드 등록/수정  | ");
                System.out.print("(4) 메인으로 돌아가기  ");
                System.out.println("\n==================================================================================");
                System.out.print("원하시는 메뉴를 입력하세요 >>  ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: //비밀번호 변경
//                        userPWUpdateByUserID();
                        break;
                    case 2: //이름 변경
                        break;
                    case 3: // 카드 등록/수정
                        break;
                    case 4: //메인으로 돌아가기
                        menuChoice();
                        break;
                    default:
                        System.out.println("숫자만 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }

        } //while end
    }

    /**
     * 5-1. 비밀번호 변경
     * */
    /*
    public static void userPWUpdateByUserID(){
        try {
            System.out.print("변경하실 비밀번호를 입력해주세요 >>");
            String newPW = sc.nextLine();
            System.out.print("다시 한번 입력해주세요 >>");
            String checkPW = sc.nextLine();

            if (newPW == checkPW){
                UserController.UpdateUserPW(userID, newPW); //유저아이디와
            }
        }catch(Exception e){

        }
    }
    */

    /**
     * 6. 예매 취소
     **/
    public static void ticketDelete(){
        try {
            System.out.print("취소할 티켓의 예매 번호를 입력해 주세요.");
//            TicketController.ticketSelectByUserId(userID); // 예매 목록(제목) 보여 주기
            int ticketID = sc.nextInt();

            TicketController.ticketDelete(ticketID);
        } catch (Exception e) {
            System.out.println("");
        }
    }
    
    
    /**
     * 카드 변경
     **/
    public static void userCardUpdate() {
  
		System.out.println("변경할 카드번호를 입력하시오 : ");
		String card = sc.nextLine();
		
		UserController.userCardUpdate(userID, card);
	}
    

} // class end

