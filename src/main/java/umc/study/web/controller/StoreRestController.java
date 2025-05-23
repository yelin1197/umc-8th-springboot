package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.MissionService.MissionService;
import umc.study.service.ReviewService.ReviewService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.ReviewRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final ReviewService reviewService;
    private final MissionService missionService;

    @PostMapping("/{storeId}/reviews")
    public ResponseEntity<String> addReview(
            @PathVariable Long storeId,
            @RequestBody @Valid ReviewRequestDTO.WriteDto requestDTO
    ) {
        reviewService.addReviewToStore(storeId, requestDTO);
        return ResponseEntity.ok("리뷰가 성공적으로 등록되었습니다.");
    }

    @PostMapping("/missions/challenge")
    public ResponseEntity<String> challengeMission(
            @RequestBody @Valid MissionRequestDTO.MissionChallengeRequest request
    ) {
        missionService.challengeMission(request.getStoreId(), request.getMissionId());
        return ResponseEntity.ok("미션 도전이 성공적으로 등록되었습니다.");
    }

}
