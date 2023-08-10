package com.shdwraze.sfb.service;

import com.shdwraze.sfb.model.entity.Item;
import com.shdwraze.sfb.model.request.AddItemRequest;
import com.shdwraze.sfb.model.response.UpdateItemResponse;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    Item getItemById(String id);

    void addItem(AddItemRequest createdItem);

    UpdateItemResponse updateItem(String id, AddItemRequest addItemRequest);

    void deleteItem(String id);
}
