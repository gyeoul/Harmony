package mvc.view;

/**
 * 컨트롤러에서 요청한 작업이 실패했을 경우 메시지를 출력하는 뷰 클래스
 */
public class FailView {
    public static void errorMessage(String message) {
        System.out.println(message);
    }
}
