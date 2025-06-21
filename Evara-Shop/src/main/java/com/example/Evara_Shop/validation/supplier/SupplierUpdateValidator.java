package com.example.Evara_Shop.validation.supplier;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.example.Evara_Shop.DTO.supplier.SupplierUpdateDTO;
import com.example.Evara_Shop.validation.ValidatorStrategy;

@Component("supplierUpdateValidator")
public class SupplierUpdateValidator implements ValidatorStrategy<SupplierUpdateDTO> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    @Override
    public void validate(SupplierUpdateDTO dto) {
        if (dto.getEmail() != null && !EMAIL_PATTERN.matcher(dto.getEmail()).matches()) {
            System.out.println("Invalid email!");
        }
        if (dto.getPhone() != null && !PHONE_PATTERN.matcher(dto.getPhone()).matches()) {
            System.out.println("Invalid phone number!");
        }
    }
}
