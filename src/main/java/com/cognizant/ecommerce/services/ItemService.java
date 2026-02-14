package com.cognizant.ecommerce.services;

import java.util.List;

import com.cognizant.ecommerce.dtos.ItemRequestDTO;
import com.cognizant.ecommerce.dtos.ItemResponseDTO;

public interface ItemService {

    ItemResponseDTO createItem(ItemRequestDTO request);

    ItemResponseDTO getItem(Long id);

    List<ItemResponseDTO> getAllItems();

    ItemResponseDTO updateItem(Long id, ItemRequestDTO request);

    void deleteItem(Long id);
}