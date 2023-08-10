package com.shdwraze.sfb.repository;

import com.shdwraze.sfb.model.entity.Item;

import java.util.List;

public interface ItemRepository {

    List<Item> findItems();

    Item findItemById(String id);

    void saveItem(Item item);

    void updateItem(Item item);

    void deleteItem(String id);
}
