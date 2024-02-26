package com.trashzero.mapper;


import com.trashzero.dto.WasteSummaryDto;
import com.trashzero.entity.WasteSummary;

public class WasteSummaryMapper {
    public static WasteSummaryDto mapToWasteSummaryDto(WasteSummary wasteSummary){
       String[] clientFullName= wasteSummary.getClientName().split(",");
        return new WasteSummaryDto(
                wasteSummary.getClientId(),
                clientFullName[0],
                clientFullName[1],
                wasteSummary.getGenWetWaste(),
                wasteSummary.getGenDryWaste(),
                wasteSummary.getGenDirRejects(),
                wasteSummary.getTotalInWaste()
        );
    }

    public static WasteSummary mapWasteSummary(WasteSummaryDto wasteSummaryDto){
        return new WasteSummary(
                wasteSummaryDto.getClientId(),
                wasteSummaryDto.getClientFirstName()+","+wasteSummaryDto.getClientSecondName(),
                wasteSummaryDto.getGenWetWaste(),
                wasteSummaryDto.getGenDryWaste(),
                wasteSummaryDto.getGenDirRejects(),
                wasteSummaryDto.getTotalInWaste()
        );
    }
}
