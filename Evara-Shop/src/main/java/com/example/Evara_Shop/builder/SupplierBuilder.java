package com.example.Evara_Shop.builder;

import com.example.Evara_Shop.DTO.supplier.SupplierCreateDTO;
import com.example.Evara_Shop.DTO.supplier.SupplierUpdateDTO;
import com.example.Evara_Shop.model.Supplier;

public class SupplierBuilder {
    public static Supplier from(SupplierCreateDTO supplierCreateDTO) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierCreateDTO.getName());
        supplier.setPhone(supplierCreateDTO.getPhone());
        supplier.setEmail(supplierCreateDTO.getEmail());
        supplier.setAddress(supplierCreateDTO.getAddress());
        return supplier;
    }

    public static void updateFromDTO(Supplier supplier, SupplierUpdateDTO dto) {
        if (dto.getName() != null) {
            supplier.setName(dto.getName());
        }
        if (dto.getEmail() != null) {
            supplier.setEmail(dto.getEmail());
        }
        if (dto.getPhone() != null) {
            supplier.setPhone(dto.getPhone());
        }
        if (dto.getAddress() != null) {
            supplier.setAddress(dto.getAddress());
        }
    }
}
