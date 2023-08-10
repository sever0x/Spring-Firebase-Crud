package com.shdwraze.sfb.mapper;

import com.shdwraze.sfb.model.entity.Item;
import com.shdwraze.sfb.model.request.AddItemRequest;
import com.shdwraze.sfb.model.response.UpdateItemResponse;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item toItem(AddItemRequest addItemRequest) {
        return new Item(null, addItemRequest.name(), addItemRequest.price());
    }

    public UpdateItemResponse toUpdatedItem(Item item) {
        return new UpdateItemResponse(item.getId(), item.getName(), item.getPrice());
    }
}
