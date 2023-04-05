package mvc.controller;

import java.awt.Menu;

import mvc.dto.UsersDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;
import mvc.service.UserService;
import mvc.service.UserServiceImpl;
import mvc.view.FailView;
import mvc.view.MenuView;
import mvc.view.SuccessView;

import static mvc.view.MenuView.menuChoice;
import static mvc.view.MenuView.userPWUpdateByUserID;

public class UserController {
    private static final UserService userService = UserServiceImpl.getInstance();

    /**
     * 회원 가입
     * */
    public static void userInsert(UsersDTO userDto){
        try {
            userService.userInsert(userDto);
            SuccessView.messagePrint("회원 가입에 성공했습니다");
        }catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 카드 등록/수정
     * */
    public static void cardUpdateByUserID(String userID, String card) {
        try {
            userService.cardUpdateByUserID(userID, card);
            SuccessView.messagePrint("카드 변경에 성공했습니다");
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 개인 정보 조회
     */
    public static void userSelect(String user_id) {
        try {
            UsersDTO dto = userService.userSelect(user_id);
            SuccessView.selectByUserIdPrint(dto);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    
    /**
     * 로그인
     */
    public static void login(String userID, String userPW) {
		try {
			userService.login(userID, userPW);
			SuccessView.messagePrint("로그인 되었습니다.");
		} catch (DMLException e) {
//			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			MenuView.loginChoice(); // 로그인 실패하여 실패 후 선택창으로 이동
		}
	}

    /**
     * 개인정보 조회
     * */
    public static void userInfoSelectByUserID(String userID){
        try {
            UsersDTO usersDTO = userService.userInfoSelectByUserID(userID);
            SuccessView.selectUserInfoPrint(usersDTO);
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 비밀번호 변경
     * */
    public static void userPWUpdate(String userID, String newPW) {
        try {
            userService.userPWUpdate(userID, newPW);
            SuccessView.messagePrint("비밀번호 변경에 성공했습니다");
            menuChoice();
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
            userPWUpdateByUserID();
        }
    }

    /**
     * 이름 변경
     * */
    public static void userNameUpdate(String userID, String userName) {
        try {
            userService.userNameUpdate(userID, userName);
            SuccessView.messagePrint("이름 변경에 성공했습니다");
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    
}
