package com.esi.adviserservice.dto;

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
    @Enumerated(EnumType.STRING)
    private RPLRequestStatus rPLRequestStatus;
}



