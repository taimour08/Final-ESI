package com.esi.studentservice.dto;

import com.esi.studentservice.model.RPLRequestStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RPLRequestDto {
    private String id;
    private String userId;
    private String courseToSubstituteName;
    private String courseToSubstituteCode;
    private Integer courseToSubstituteVolume;
    private String courseToBeSubstitutedName;
    private String courseToBeSubstitutedCode;
    private String advisoryDescription;
    @Enumerated(EnumType.STRING)
    private RPLRequestStatus rPLRequestStatus;
}



