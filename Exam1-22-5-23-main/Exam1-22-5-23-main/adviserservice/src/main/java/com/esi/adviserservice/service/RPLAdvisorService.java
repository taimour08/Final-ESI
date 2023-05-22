package com.esi.adviserservice.service;
import com.esi.adviserservice.dto.RPLRequestDto;
import com.esi.adviserservice.dto.RPLRequestStatus;

import org.springframework.stereotype.Service;

import com.esi.adviserservice.dto.RPLRequestDto;
import com.esi.adviserservice.repository.RPLAdvisorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;




@RequiredArgsConstructor
@Service
public class RPLAdvisorService {
 


public void updateRPLResponse(RPLRequestDto rPLRequestDto) {

}

    
@KafkaListener(topics = "RPLRequestTopic", groupId = "RPLRequestGroup")
public void receiveRPLRequest(RPLRequestDto rPLRequestDto){
    RPLAdvisor rPLAdvisor = RPLAdvisor.builder()
    .id(rPLRequestDto.getId())
    .userId(rPLRequestDto.getUserId())
    .courseToSubstituteCode(rPLRequestDto.getCourseToSubstituteCode())
    .courseToSubstituteVolume(rPLRequestDto.getCourseToSubstituteVolume())
    .courseToBeSubstitutedName(rPLRequestDto.getCourseToBeSubstitutedName())
    .courseToBeSubstitutedCode(rPLRequestDto.getCourseToBeSubstitutedCode())
    .RPLRequestStatus(rPLRequestDto.getCourseToBeSubstitutedCode())
    .build();

    rPLAdvisor.setRPLRequestStatus(RPLRequestStatus.UnderReview);
    rPLAdvisorDto.setRPLRequestStatus(RPLRequestStatus.UnderReview);

    RPLAdvisorRepository.save(rPLAdvisor);
log.info("RPL receieved", rPLAdvisor.getId());
}

}

