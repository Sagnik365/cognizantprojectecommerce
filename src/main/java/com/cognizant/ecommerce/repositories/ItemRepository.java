package com.cognizant.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ecommerce.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
}