package com.shdwraze.sfb.repository.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.shdwraze.sfb.exception.RepositoryException;
import com.shdwraze.sfb.model.entity.Item;
import com.shdwraze.sfb.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final String COLLECTION_NAME = "items";

    private final Firestore firestore;

    @Override
    public List<Item> findItems() {
        ApiFuture<QuerySnapshot> future = firestore.collection(COLLECTION_NAME).get();
        QuerySnapshot querySnapshot;
        try {
            querySnapshot = future.get();
        } catch (Exception e) {
            throw new RepositoryException(e);
        }

        return querySnapshot.toObjects(Item.class);
    }

    @Override
    public Item findItemById(String id) {
        ApiFuture<DocumentSnapshot> future = firestore.collection(COLLECTION_NAME).document(id).get();
        DocumentSnapshot document;
        try {
            document = future.get();
        } catch (Exception e) {
            throw new RepositoryException(e);
        }

        return document.toObject(Item.class);
    }

    @Override
    public void saveItem(Item item) {
        firestore.collection(COLLECTION_NAME).add(item);
    }

    @Override
    public void updateItem(Item item) {
        firestore.collection(COLLECTION_NAME).document(item.getId()).set(item);
    }

    @Override
    public void deleteItem(String id) {
        firestore.collection(COLLECTION_NAME).document(id).delete();
    }
}
