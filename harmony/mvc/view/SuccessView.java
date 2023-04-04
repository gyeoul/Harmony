package mvc.view;

import mvc.dto.UsersDTO;

public class SuccessView {
    /**
     * 성공 메시지 출력
     * */
    public static void messagePrint(String message) {
        System.out.println(message);
    }

    /**
     * 성공한 유저 정보 출력
     * */
    public static void selectByUserIdPrint(UsersDTO userDTO) {
        System.out.println(userDTO);
    }

}
