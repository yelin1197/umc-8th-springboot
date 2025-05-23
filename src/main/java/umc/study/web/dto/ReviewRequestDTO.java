package umc.study.web.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class ReviewRequestDTO {

    @Getter
    @Setter
    public static class WriteDto {

        @NotBlank(message = "리뷰 제목은 필수입니다.")
        private String title;

        @NotNull(message = "점수는 필수 항목입니다.")
        @DecimalMin(value = "0.0", inclusive = true, message = "점수는 0 이상이어야 합니다.")
        @DecimalMax(value = "5.0", inclusive = true, message = "점수는 5 이하이어야 합니다.")
        private Float score;
    }
}
