package mvc.controller;

import mvc.dto.UsersDTO;
import mvc.exception.DMLException;
import mvc.exception.SearchWrongException;
import mvc.service.UserService;
import mvc.service.UserServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

public class UserController {
    private static UserService userService = UserServiceImpl.getInstance();

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
     * 카드 변경
     * */
    public static void userCardUpdate(String user_id, String card) {
        try {
            userService.userCardUpdate(user_id, card); //void
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
}
