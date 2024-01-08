package com.trashzero.mapper;


import com.trashzero.dto.WasteSummaryDto;
import com.trashzero.entity.WasteSummary;

public class WasteSummaryMapper {
    public static WasteSummaryDto mapToWasteSummaryDto(WasteSummary wasteSummary){
        return new WasteSummaryDto(
                wasteSummary.getClientId(),
                wasteSummary.getClientName(),
                wasteSummary.getGenWetWaste(),
                wasteSummary.getGenDryWaste(),
                wasteSummary.getGenDirRejects(),
                wasteSummary.getTotalInWaste()
        );
    }

    public static WasteSummary mapWasteSummary(WasteSummaryDto wasteSummaryDto){
        return new WasteSummary(
                wasteSummaryDto.getClientId(),
                wasteSummaryDto.getClientName(),
                wasteSummaryDto.getGenWetWaste(),
                wasteSummaryDto.getGenDryWaste(),
                wasteSummaryDto.getGenDirRejects(),
                wasteSummaryDto.getTotalInWaste()
        );
    }
}
