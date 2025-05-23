package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.MissionNotChallenged;

public class MissionRequestDTO {

    @Getter
    @Setter
    @MissionNotChallenged
    public static class MissionChallengeRequest {

        @NotNull(message = "storeId는 필수입니다.")
        private Long storeId;

        @NotNull(message = "missionId는 필수입니다.")
        private Long missionId;

        // 임시 로그인 사용자 ID (추후 인증 정보로 대체)
        private Long memberId = 1L;
    }
}