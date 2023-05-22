package com.esi.studentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rplrequeststable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RPLRequest {
    @Id
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



