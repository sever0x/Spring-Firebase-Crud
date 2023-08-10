package com.shdwraze.sfb.controller;

import com.shdwraze.sfb.model.entity.Item;
import com.shdwraze.sfb.model.request.AddItemRequest;
import com.shdwraze.sfb.model.response.UpdateItemResponse;
import com.shdwraze.sfb.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class FirestoreController {

    private ItemService itemService;

    @PostMapping
    public void addItem(@RequestBody AddItemRequest createdItem) {
        itemService.addItem(createdItem);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable String id) {
        return itemService.getItemById(id);
    }

    @PutMapping("/{id}")
    public UpdateItemResponse updateItem(@RequestBody AddItemRequest addItemRequest,
                                         @PathVariable String id) {
        return itemService.updateItem(id, addItemRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }
}
