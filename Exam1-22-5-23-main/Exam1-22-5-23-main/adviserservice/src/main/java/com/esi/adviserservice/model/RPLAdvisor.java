package com.esi.adviserservice.model;

import com.esi.adviserservice.dto.RPLRequestStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "adviserservicetable")
public class RPLAdvisor {
    @Id
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
