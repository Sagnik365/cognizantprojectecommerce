package com.cognizant.ecommerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ecommerce.dtos.ItemRequestDTO;
import com.cognizant.ecommerce.dtos.ItemResponseDTO;
import com.cognizant.ecommerce.services.ItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @PostMapping
    public ItemResponseDTO create(@RequestBody ItemRequestDTO request) {
        return service.createItem(request);
    }

    @GetMapping("/{id}")
    public ItemResponseDTO get(@PathVariable Long id) {
        return service.getItem(id);
    }

    @GetMapping
    public List<ItemResponseDTO> getAll() {
        return service.getAllItems();
    }

    @PutMapping("/{id}")
    public ItemResponseDTO update(@PathVariable Long id,
                                  @RequestBody ItemRequestDTO request) {
        return service.updateItem(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteItem(id);
    }
}