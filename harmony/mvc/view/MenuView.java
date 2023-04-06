package mvc.view;

import mvc.controller.*;
import mvc.dto.TicketDTO;
import mvc.dto.UsersDTO;
import mvc.exception.SearchWrongException;

import java.util.Scanner;

public class MenuView {
    static Scanner sc = new Scanner(System.in);
    static String userID; // 현재 사용자

    /**
     * 로그인/회원가입 선택
     **/
    public static void userCheck() {
        while (true) {
            System.out.println("\n====================================================================================");
            System.out.print(" (1) 로그인   |  ");
            System.out.print("(2) 회원가입   |  ");
            System.out.print("(3) 종료 ");
            System.out.println("\n====================================================================================");
            System.out.print("메뉴를 선택해 주세요 >> ");
            try {
                int num = Integer.parseInt(sc.nextLine());
                switch (num) {
                    case 1: // 로그인 시
                        login();
                        break;
                    case 2: // 회원가입
                        joinMember();
                        break;
                    case 3: // 종료
                        System.out.println("방문해 주셔서 감사합니다. 다음에 또 오세요~");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("메뉴에 없는 숫자가 입력되었습니다. 다시 입력해 주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자 입력만 가능합니다. 다시 입력해 주세요.");
            }
        }
    }

    /**
     * 메뉴 선택
     **/
    public static void menuChoice() {

        while (true) {
            System.out.println("\n====================================================================================");
            System.out.print("                                    메인 화면");
            System.out.println("\n====================================================================================");
            System.out.print(" (1) 예매  | ");
            System.out.print("(2) 뮤지컬 차트  | ");
            System.out.print("(3) 예매 내역 확인  | ");
            System.out.print("(4) 예매 취소  | ");
            System.out.print("(5) 마이페이지 | ");
            System.out.print("(6) 종료 ");
            System.out.println("\n====================================================================================");
            System.out.print(" 메뉴를 선택해 주세요 >> ");
            try {
                int menu = Integer.parseInt(sc.nextLine());
                switch (menu) {
                    case 1: // 예매
                        ticketing();
                        break;
                    case 2: // 뮤지컬 차트 조회
                        musicalSelectAll();
                        break;
                    case 3: // 예매 내역 확인
                        ticketSelectByUserID();
                        break;
                    case 4: // 예매 취소
                        ticketDelete();
                        break;
                    case 5: // 마이페이지
                        userInfoUpdate();
                        break;
                    case 6: // 종료
                        System.out.println("다음에 또 오세요~ 로그아웃됩니다...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("메뉴에 없는 숫자가 입력되었습니다. 다시 입력해 주세요.");
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자 입력만 가능합니다. 다시 입력해 주세요");
            }
        } // while end
    }

    /**
     * 로그인
     **/
    public static void login() {
        System.out.print("ID를 입력하시오 >> ");
        userID = sc.nextLine();

        System.out.print("PassWord를 입력하시오 >> ");
        String pw = sc.nextLine();

        UserController.login(userID, pw);
        menuChoice();
    }

    /**
     * 로그인 실패 시, 다시 로그인 시도 or 회원가입 둘 중 하나를 선택
     **/
    public static void loginChoice() {
        System.out.println("\n====================================================================================");
        System.out.print(" (1) 로그인을 다시 시도  |  (2) 회원가입 ");
        System.out.println("\n====================================================================================");
        int choiceNUM = Integer.parseInt(sc.nextLine());
        switch (choiceNUM) {
            case 1:
                login(); // 로그인으로 이동
                break;
            case 2:
                joinMember(); // 회원가입으로 이동
                break;
            default:
                System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해 주세요!");
        }
    }

    /**
     * 회원가입
     **/
    public static void joinMember() {
        System.out.print("사용할 ID를 입력하시오 >> ");
        String id = sc.nextLine();

        System.out.print("사용할 PassWord를 입력하시오 >> ");
        String pw = sc.nextLine();

        System.out.print("등록할 Email을 입력하시오 >> ");
        String email = sc.nextLine();

        System.out.print("자신의 이름을 입력하시오 >> ");
        String name = sc.nextLine();

        System.out.print("자신의 나이를 입력하시오 >> ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("자신의 성별을 입력하시오 (남성 'M'/여성 'W') >> ");
        String gender = sc.nextLine();

        UsersDTO user = new UsersDTO(id, pw, email, name, age, gender, null);

        UserController.userInsert(user);
    }

    /**
     * 1. 예매
     **/
    public static void ticketing() {

        TicketDTO ticket = new TicketDTO();
        ticket.setUserId(userID);

        //영화 리스트 출력
        MusicalController.musicalSelectAll();

        System.out.print("관람하고 싶은 뮤지컬의 이름을 입력해 주세요 >> ");
        String input = sc.nextLine();

        try {
            TicketingController.searchByTitle(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ticketing();
        }
        System.out.print("관람을 원하는 날짜의 번호를 입력해 주세요 >> ");

        int inp2 = Integer.parseInt(sc.nextLine());
        ticket.setMusicalId(TicketingController.seatSearchByRownumWithTitle(inp2, input));
        try {
            MusicalController.musicalSeatSelect(ticket.getMusicalId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ticketing();
        }

        System.out.print("관람을 원하는 좌석을 입력해 주세요 >> ");
        try {
            ticket.setSeatNum(SeatController.checkSeat(sc.nextLine().toUpperCase()));
        } catch (SearchWrongException e) {
            System.out.println(e.getMessage());
            ticketing();
        }

//        System.out.println(ticket);
        try {
            UserController.userCardCheck(userID);
        } catch (SearchWrongException e) {
            System.out.println(e.getMessage());
            userCardUpdate();
        }

        // 결제 진행
        try {
            TicketController.ticketInsert(ticket);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ticketing();
        }
//        UserController.userSelect();
        menuChoice();
    }

    /**
     * 2. 뮤지컬 차트 조회
     **/
    public static void musicalSelectAll() {
        MusicalController.musicalSelectAll();

        System.out.print("상세 정보를 열람하고 싶은 뮤지컬의 제목을 입력해 주세요 >> ");
        String input = sc.nextLine();

        try {
            MusicalController.musicalDetailSelect(input);
            System.out.println("\n====================================================================================");
            System.out.println(" (1) 뮤지컬 목록으로 돌아가기    |    (2) 메인 메뉴로 돌아가기");
            System.out.println("====================================================================================");
            System.out.print("메뉴를 선택해 주세요 >> ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: // 뮤지컬 목록으로 돌아가기
                    musicalSelectAll();
                    break;
                case 2: // 메인 메뉴로 돌아가기
                    menuChoice();
                    break;
                default:
                    System.out.println("숫자만 입력해 주세요.");
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    /**
     * 작성자 : 박상희
     * 3.예매 내역 확인
     **/
    public static void ticketSelectByUserID() {
        TicketController.ticketSelectByMine(userID);
    }

    /**
     * 5. 마이페이지
     **/
    public static void userInfoUpdate() {
        while (true) {
            try {
                System.out.println("\n====================================================================================");
                System.out.print("                                      마이페이지");
                System.out.println("\n====================================================================================");
                System.out.print(" (1) 개인정보  | ");
                System.out.print("(2) 비밀번호 변경  | ");
                System.out.print("(3) 이름 변경  | ");
                System.out.print("(4) 카드 등록/수정  | ");
                System.out.print("(5) 메인 메뉴로 돌아가기  ");
                System.out.println("\n====================================================================================");
                System.out.print("원하시는 메뉴를 입력하세요 >>  ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: // 유저 개인 정보 조회
                        userInfoSelectByUserID();
                        break;
                    case 2: // 비밀번호 변경
                        userPWUpdateByUserID();
                        break;
                    case 3: // 이름 변경
                        userNameUpdateByUserID();
                        break;
                    case 4: // 카드 등록/수정
                        userCardUpdate();
                        break;
                    case 5: // 메인으로 돌아가기
                        menuChoice();
                        break;
                    default:
                        System.out.println("숫자만 입력해 주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해 주세요.");
            }

        } // while end
    }

    /**
     * 5-1. 개인 정보 조회
     **/
    public static void userInfoSelectByUserID() {
        UserController.userInfoSelectByUserID(userID);
    }

    /**
     * 5-2. 비밀번호 변경
     **/
    public static void userPWUpdateByUserID() {
        System.out.print("새로운 비밀번호를 입력해 주세요 >> ");
        String newPW = sc.nextLine();
        System.out.print("다시 한번 입력해 주세요 >> ");
        String checkPW = sc.nextLine();

        if (newPW.equals(checkPW)) {
            UserController.userPWUpdate(userID, newPW); // 유저 아이디와 비밀번호
        } else {
            FailView.errorMessage("입력된 비밀번호가 다릅니다. 다시 입력해 주세요");
            userPWUpdateByUserID();
        }
    }

    /**
     * 5-3. 이름 변경
     **/
    public static void userNameUpdateByUserID() {
        System.out.print("새로운 이름 입력해 주세요 >>");
        String newName = sc.nextLine();

        UserController.userNameUpdateByUserID(userID, newName); // 유저 아이디와 새로운 유저 이름
        menuChoice();
    }

    /**
     * 5-4. 카드 등록/수정
     **/
    public static void userCardUpdate() {
        System.out.println("\n====================================================================================");
        System.out.print(" (1) 카드 등록    |    (2) 카드 수정   |  (3) 메인 메뉴로 돌아가기");
        System.out.println("\n====================================================================================");
        System.out.print("메뉴를 선택해 주세요 >> ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1: // 카드 등록 메뉴
                cardInsertByUserID();
                break;
            case 2:  // 카드 수정 메뉴
                cardUpdateByUserID();
                break;
            case 3: // 메인 메뉴로 돌아가기
                menuChoice();
                break;
            default:
                System.out.println("숫자만 입력해 주세요.");
        }
    }

    /**
     * 5-4-1. 카드 등록
     **/
    public static void cardInsertByUserID() {
        System.out.print("등록할 카드번호를 입력하시오 >> ");
        String card = sc.nextLine();
        UserController.cardUpdateByUserID(userID, card);
    }

    /**
     * 5-4-2. 카드 수정
     **/
    public static void cardUpdateByUserID() {
        System.out.print("변경할 카드번호를 입력하시오 >> ");
        String card = sc.nextLine();
        UserController.cardUpdateByUserID(userID, card);
    }

    /**
     * 작성자 : 박상희
     * 6. 예매 취소
     **/
    public static void ticketDelete() {
        try {
            TicketController.ticketSelectMusicalTitle(userID); // 취소 가능한 예매 목록(티켓 예매 번호, 제목) 조회

            System.out.print("취소할 티켓의 예매 번호를 입력해 주세요. >> ");
            int ticketID = Integer.parseInt(sc.nextLine());

            TicketController.ticketDelete(ticketID, userID);
        } catch (NumberFormatException e) {
            System.out.println("예매 번호가 잘못되었습니다. 다시 시도해 주세요.");
        } catch (Exception e) {
            System.out.println("예매 취소에 실패했습니다. 다시 시도해 주세요.");
        }
    }
} // class end
