package mvc.controller;

import mvc.exception.SearchWrongException;

public class SeatController {

    /**
     * 자리 검사
     */
    public static String checkSeat(String seat) {
        char[] arr = seat.toCharArray();
        if (arr.length != 2) throw new SearchWrongException("해당하는 좌석이 없습니다");
        if (arr[0] < 'A' || arr[0] > 'E') throw new SearchWrongException("해당하는 좌석이 없습니다");
        if (arr[1] < '1' || arr[1] > '5') throw new SearchWrongException("해당하는 좌석이 없습니다");
        return seat;
    }

}
