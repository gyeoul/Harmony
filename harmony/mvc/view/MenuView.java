package mvc.view;

import java.util.Scanner;

import mvc.controller.UserController;

public class MenuView {
    static Scanner sc = new Scanner(System.in);

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
            System.out.print(" (1) 예매\t | ");
            System.out.print("(2) 뮤지컬 차트\t | ");
            System.out.print("(3) 예매 내역 확인\t | ");
            System.out.print("(4) 예매 취소\t | ");
            System.out.print("(5) 종료 ");
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
                    case 5: //종료
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
        try {
			System.out.print("ID를 입력하시오: ");
			String id = sc.nextLine();
			
			System.out.print("PassWord를 입력하시오: ");
			String pw = sc.nextLine();
			
			UserController.login(id, pw);
		} catch (Exception e) {
			System.out.println("로그인 실패! 다시 입력하시오!");
			login();
		}
    	
    	menuChoice();
    }

    /**
     * 회원가입
     * KB_DBBoard_template에서 등록하는 부분 참고
     * */
    public static void joinMember(){

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

    }

    /**
     * 3.예매 내역 확인
     * */
    public static void ticketSelectByUserID(){

    }

    /**
     * 4. 예매 취소
     * */
    public static void ticketDelete(){

    }

}// class end

