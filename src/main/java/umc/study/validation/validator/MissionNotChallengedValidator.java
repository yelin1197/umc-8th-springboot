package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.validation.annotation.MissionNotChallenged;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionRequestDTO.MissionChallengeRequest; // ✅ inner class 직접 import


@Component
@RequiredArgsConstructor
public class MissionNotChallengedValidator implements ConstraintValidator<MissionNotChallenged, MissionRequestDTO.MissionChallengeRequest> {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public boolean isValid(MissionChallengeRequest value, ConstraintValidatorContext context) {
        if (value.getMemberId() == null || value.getMissionId() == null) return true;

        Member member = memberRepository.findById(value.getMemberId()).orElse(null);
        Mission mission = missionRepository.findById(value.getMissionId()).orElse(null);

        if (member == null || mission == null) return true;

        return !memberMissionRepository.existsByMemberAndMission(member, mission);
    }
}
