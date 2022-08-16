package com.sparta.assignment.service;
import com.sparta.assignment.domain.Information;
import com.sparta.assignment.domain.InformationRepository;
import com.sparta.assignment.domain.InformationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service//얘는 service다 !!
@RequiredArgsConstructor//필요있는 인자들을 서비스로
public class Informationservice {
    private final InformationRepository informationRepository;
    @Transactional
    public Long update(Long id, InformationRequestDto RequestDto) {
        Information information = informationRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        information.update(RequestDto);
         return  information.getId();
    }
}
