package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.status.ErrorStatus;

public class FoodCategoryHandler extends RuntimeException {

    private final ErrorStatus status;

    public FoodCategoryHandler(ErrorStatus status) {
        super(status.getMessage()); // 에러 메시지로 출력
        this.status = status;
    }

    public ErrorStatus getStatus() {
        return status;
    }
}
