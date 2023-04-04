package mvc.exception;

/**
 * insert, update, delete에 결과가 오류가 있을 때 발생
 * */
public class DMLException  extends RuntimeException{
    public DMLException() {}
    public DMLException(String message) {
        super(message);
    }

}
