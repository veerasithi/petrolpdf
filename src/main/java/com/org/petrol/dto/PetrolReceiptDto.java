/**
 * 
 */
package com.org.petrol.dto;

import lombok.Data;

/**
 * 
 */
@Data
public class PetrolReceiptDto {
	private String invoiceNo;
    private String receiptType;
    private String vehicleNo;
    private String mobileNo;
    private String date;
    private String time;
    private String nzNo;
    private String product;
    private double rate;
    private double amount;
    private double volume;
}
