package com.sparta.assignment.controller;
import com.sparta.assignment.domain.Information;
import com.sparta.assignment.domain.InformationRepository;
import com.sparta.assignment.domain.InformationRequestDto;
import com.sparta.assignment.service.Informationservice;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.LazyToOne;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class InformationController {
    private final InformationRepository informationRepository;//저장하기 위한 그런 얘임
    private final Informationservice informationservice;//service를 이용
    @PostMapping("/api/information")
    public Information createInformation(@RequestBody InformationRequestDto informationRequestDto) {
        Information information = new Information(informationRequestDto);
        return informationRepository.save(information);
    }
    @GetMapping("/api/information")
    public List<Information> getInfomations() {
        return informationRepository.findAllByOrderByCreatedAtDesc();
    }

    @PutMapping("/api/information/{id}")
    public Long correctpassword(@PathVariable Long id ,@RequestBody InformationRequestDto informationRequestDto) {
        informationservice.update(id, informationRequestDto);
        return  id;
    }
    @DeleteMapping("/api/information/{id}")
    public Long deleteInformation(@PathVariable Long id) {
        informationRepository.deleteById(id);
        return id;
    }
    @PostMapping("/api/information/{id}")
    public Boolean modifyInformation(@PathVariable Long id ,@RequestBody Map<String,String> map) {
        String password = map.get("password");
        Optional<Information> information = informationRepository.findById(id);
        if(password.equals(information.get().getPassword())){
            return true;
        }
        else
            return false;
    }

}
