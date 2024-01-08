package com.trashzero.service.impl;

import com.trashzero.dto.WasteSummaryDto;
import com.trashzero.entity.WasteSummary;
import com.trashzero.exception.ResourceNotFoundException;
import com.trashzero.mapper.WasteSummaryMapper;
import com.trashzero.repository.WasteSummaryRepository;
import com.trashzero.service.WasteSummaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@AllArgsConstructor
public class WasteSummaryServiceImpl implements WasteSummaryService {

    private WasteSummaryRepository wasteSummaryRepository;
    @Override
    public WasteSummaryDto addWasteSummary(WasteSummaryDto wasteSummaryDto) {

        WasteSummary wasteSummary= WasteSummaryMapper.mapWasteSummary(wasteSummaryDto);
        WasteSummary addedWasteSummary = wasteSummaryRepository.save(wasteSummary);

        return WasteSummaryMapper.mapToWasteSummaryDto(addedWasteSummary);
    }

    @Override
    public WasteSummaryDto getSummaryById(Long clientId) {
        WasteSummary wasteSummary = wasteSummaryRepository.findById(clientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client Not Exist for id:" + clientId));
        return WasteSummaryMapper.mapToWasteSummaryDto(wasteSummary);
    }

    @Override
    public List<WasteSummaryDto> getAllClient() {
        List<WasteSummary> clients=wasteSummaryRepository.findAll();
        return clients.stream().map((wasteSummary) -> WasteSummaryMapper.mapToWasteSummaryDto(wasteSummary))
                .collect(Collectors.toList());
    }

    @Override
    public WasteSummaryDto updateClient(Long clientId, WasteSummaryDto updatedClient) {
        WasteSummary wasteSummary = wasteSummaryRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("Client Not Exist for id:" + clientId)
        );

        wasteSummary.setClientName(updatedClient.getClientName());
        wasteSummary.setGenDryWaste(updatedClient.getGenDryWaste());
        wasteSummary.setGenWetWaste(updatedClient.getGenWetWaste());
        wasteSummary.setGenDirRejects(updatedClient.getGenDirRejects());
        wasteSummary.setTotalInWaste(updatedClient.getTotalInWaste());

        WasteSummary updatedClientObj = wasteSummaryRepository.save(wasteSummary);
        return WasteSummaryMapper.mapToWasteSummaryDto(updatedClientObj);
    }
}
