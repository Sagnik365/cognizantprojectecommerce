package com.cognizant.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cognizant.ecommerce.entities.Item;
import com.cognizant.ecommerce.repositories.ItemRepository;
import com.cognizant.ecommerce.services.ItemServiceImpl;

class ItemServiceTest {

    @Test
    void testGetItem() {

        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl(repository);

        Item item = Item.builder().id(1L).name("Mouse").build();

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(item));

        assertEquals("Mouse", service.getItem(1L).getName());
    }
}
