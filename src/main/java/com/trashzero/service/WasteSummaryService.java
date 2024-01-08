package com.trashzero.service;

import com.trashzero.dto.WasteSummaryDto;

import java.util.List;

public interface WasteSummaryService {
    WasteSummaryDto addWasteSummary(WasteSummaryDto wasteSummaryDto);

    WasteSummaryDto getSummaryById(Long clientId);

    List<WasteSummaryDto> getAllClient();

    WasteSummaryDto updateClient(Long clientId, WasteSummaryDto updatedClient);
}
