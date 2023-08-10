package com.shdwraze.sfb.service.impl;

import com.shdwraze.sfb.mapper.ItemMapper;
import com.shdwraze.sfb.model.entity.Item;
import com.shdwraze.sfb.model.request.AddItemRequest;
import com.shdwraze.sfb.model.response.UpdateItemResponse;
import com.shdwraze.sfb.repository.ItemRepository;
import com.shdwraze.sfb.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private ItemMapper itemMapper;

    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findItems();
    }

    @Override
    public Item getItemById(String id) {
        return itemRepository.findItemById(id);
    }

    @Override
    public void addItem(AddItemRequest addItemRequest) {
        itemRepository.saveItem(itemMapper.toItem(addItemRequest));
    }

    @Override
    public UpdateItemResponse updateItem(String id, AddItemRequest addItemRequest) {
        Item item = itemRepository.findItemById(id);
        item.setName(addItemRequest.name());
        item.setPrice(addItemRequest.price());
        itemRepository.updateItem(item);

        return itemMapper.toUpdatedItem(item);
    }

    @Override
    public void deleteItem(String id) {
        itemRepository.deleteItem(id);
    }
}
