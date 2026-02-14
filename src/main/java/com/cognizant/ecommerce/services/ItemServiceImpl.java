package com.cognizant.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cognizant.ecommerce.dtos.ItemRequestDTO;
import com.cognizant.ecommerce.dtos.ItemResponseDTO;
import com.cognizant.ecommerce.entities.Item;
import com.cognizant.ecommerce.exceptions.ItemNotFoundException;
import com.cognizant.ecommerce.mappers.ItemMapper;
import com.cognizant.ecommerce.repositories.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Override
    public ItemResponseDTO createItem(ItemRequestDTO request) {
        Item item = ItemMapper.toEntity(request);
        return ItemMapper.toDTO(repository.save(item));
    }

    @Override
    public ItemResponseDTO getItem(Long id) {
        Item item = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        return ItemMapper.toDTO(item);
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {
        return repository.findAll()
                .stream()
                .map(ItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemResponseDTO updateItem(Long id, ItemRequestDTO request) {
        Item item = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setCategory(request.getCategory());

        return ItemMapper.toDTO(repository.save(item));
    }

    @Override
    public void deleteItem(Long id) {
        if (!repository.existsById(id)) {
            throw new ItemNotFoundException(id);
        }
        repository.deleteById(id);
    }
}