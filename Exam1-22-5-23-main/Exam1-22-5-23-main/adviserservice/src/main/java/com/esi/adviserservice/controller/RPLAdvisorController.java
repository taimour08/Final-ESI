package com.esi.adviserservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esi.adviserservice.dto.RPLRequestDto;
import com.esi.adviserservice.service.RPLAdvisorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RPLAdvisorController {

    @Autowired
    private RPLAdvisorService rPLAdvisorService;


    @PutMapping("/rplresponse")
    public ResponseEntity<String> updateRPLResponse(@RequestBody RPLRequestDto rPLRequestDto) {
        rPLAdvisorService.updateRPLResponse(rPLRequestDto);
    return ResponseEntity.ok("An RPL Request is under review by the committee");

    }
}
