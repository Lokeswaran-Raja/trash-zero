package com.trashzero.controller;

import com.trashzero.dto.WasteSummaryDto;
import com.trashzero.service.WasteSummaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class WasteSummaryController {
    private WasteSummaryService wasteSummaryService;

    @PostMapping
    public ResponseEntity<WasteSummaryDto> addWasteSummary(@RequestBody WasteSummaryDto wasteSummaryDto){
        WasteSummaryDto addWasteSummary = wasteSummaryService.addWasteSummary(wasteSummaryDto);
        return new ResponseEntity<>(addWasteSummary, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<WasteSummaryDto> getClientId(@PathVariable("id") Long clientId){
        WasteSummaryDto summaryById = wasteSummaryService.getSummaryById(clientId);
        return ResponseEntity.ok(summaryById);
    }

    @GetMapping("/all")
    public ResponseEntity<java.lang.Object> getAllClients(){
        List<WasteSummaryDto> clients = wasteSummaryService.getAllClient();
        return ResponseEntity.ok(clients);
    }

    @PutMapping("{id}")
    public ResponseEntity <WasteSummaryDto> updateClient(@PathVariable("id") Long clientId,
                                                         @RequestBody WasteSummaryDto updatedClient){
        WasteSummaryDto wasteSummaryDto = wasteSummaryService.updateClient(clientId, updatedClient);
        return ResponseEntity.ok(wasteSummaryDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<java.lang.Object> deleteClient(@PathVariable("id") Long clientId){
        wasteSummaryService.deleteClient(clientId);
        return ResponseEntity.ok("Client Deleted Successfully!.");
    }


}
