package com.esi.studentservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;


import com.esi.studentservice.dto.RPLRequestDto;
import com.esi.studentservice.model.RPLRequest;
import com.esi.studentservice.model.RPLRequestStatus;
import com.esi.studentservice.repository.RPLRequestRepository;
import com.esi.adviserservice.dto.RPLRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RPLRequestService {

    @Autowired
    private RPLRequestRepository RPLRequestRepository;

    private final KafkaTemplate<String, RPLRequestDto> kafkaTemplate;



    public   List<RPLRequestDto> getAllRPLRequest(){
        List<RPLRequest> rPLRequests =  new ArrayList<>();
        RPLRequestRepository.findAll().forEach(rPLRequests::add);
        return rPLRequests.stream().map(this::mapToRPLRequestsDto).toList();
    }    
        
    private RPLRequestDto mapToRPLRequestsDto(RPLRequest rPLRequest) {
            return RPLRequestDto.builder()
                    .id(rPLRequest.getId())
                    .userId(rPLRequest.getUserId())
                    .courseToSubstituteName(rPLRequest.getCourseToSubstituteName())
                    .courseToSubstituteCode(rPLRequest.getCourseToSubstituteCode())
                    .courseToSubstituteVolume(rPLRequest.getCourseToSubstituteVolume())
                    .courseToBeSubstitutedName(rPLRequest.getCourseToBeSubstitutedName())
                    .courseToBeSubstitutedCode(rPLRequest.getCourseToBeSubstitutedCode())
                    .build();
    }

    public void addRPLRequest(RPLRequestDto rPLRequestDto) {
        RPLRequest rplRequest = RPLRequest.builder()
        .id(rPLRequestDto.getId())
        .userId(rPLRequestDto.getUserId())
        .courseToSubstituteName(rPLRequestDto.getCourseToSubstituteName())
        .courseToSubstituteCode(rPLRequestDto.getCourseToSubstituteCode())
        .courseToBeSubstitutedName(rPLRequestDto.getCourseToBeSubstitutedCode())
        .build();

        
        // Setting the Order status to CREATED, and the payment status to Pending
        rplRequest.setRPLRequestStatus(RPLRequestStatus.Submitted);
        rPLRequestDto.setRPLRequestStatus(RPLRequestStatus.Submitted);

        kafkaTemplate.send("RPLRequestTopic", rPLRequestDto);

        RPLRequestRepository.save(rplRequest);
    }



}
