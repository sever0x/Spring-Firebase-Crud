package com.shdwraze.sfb.model.request;

import lombok.Builder;

@Builder
public record AddItemRequest(
        String name,
        double price
) {}