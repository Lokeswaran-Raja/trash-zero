package com.trashzero.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WasteSummaryDto {
    private Long clientId;
    private String clientFirstName;
    private String clientSecondName;
    private Double genWetWaste;
    private Double genDryWaste;
    private Double genDirRejects;
    private Double totalInWaste;
}
