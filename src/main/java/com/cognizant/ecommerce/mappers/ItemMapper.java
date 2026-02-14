package com.cognizant.ecommerce.mappers;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;

import com.cognizant.ecommerce.dtos.ItemRequestDTO;
import com.cognizant.ecommerce.dtos.ItemResponseDTO;
import com.cognizant.ecommerce.entities.Item;

public class ItemMapper {

    public static Item toEntity(ItemRequestDTO dto) {
        return Item.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ItemResponseDTO toDTO(Item item) {
        return ItemResponseDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .category(item.getCategory())
                .createdAt(item.getCreatedAt())
                .build();
    }
}