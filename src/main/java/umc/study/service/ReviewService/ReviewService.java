package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository; // 현재 로그인 사용자 사용 시
    private final ReviewRepository reviewRepository;

    @Transactional
    public void addReviewToStore(Long storeId, ReviewRequestDTO.WriteDto dto) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가게가 존재하지 않습니다."));

        // 로그인 사용자가 있다면 실제 인증 객체로 교체
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Review review = Review.builder()
                .title(dto.getTitle())
                .score(dto.getScore())
                .store(store)
                .member(member)
                .build();

        reviewRepository.save(review);
    }
}