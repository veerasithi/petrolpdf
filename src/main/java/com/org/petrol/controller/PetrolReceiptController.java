/**
 * 
 */
package com.org.petrol.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.petrol.dto.PetrolReceiptDto;
import com.org.petrol.service.PetrolReceiptService;

/**
 * 
 */
@RestController
@RequestMapping("/api/petrol")
public class PetrolReceiptController {

    @Autowired
    private PetrolReceiptService receiptService;

//    @PostMapping("/generate-receipt")
//    public ResponseEntity<byte[]> generateReceipt(@RequestBody PetrolReceiptDto dto) {
//        ByteArrayInputStream bis = receiptService.generateReceiptPdf(dto);
//
//        if (bis == null) {
//            return ResponseEntity.internalServerError().body(null);
//        }
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=petrol_receipt.pdf")
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(bis.readAllBytes());
//    }
    @PostMapping("/save-to-folder")
    public ResponseEntity<String> saveReceiptToFolder(@RequestBody PetrolReceiptDto dto) {
        String message = receiptService.generateAndSaveReceiptPdf(dto);
        return ResponseEntity.ok(message);
    }
}
