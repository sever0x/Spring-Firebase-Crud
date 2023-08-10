package com.shdwraze.sfb.model.response;

import lombok.Builder;

@Builder
public record UpdateItemResponse(
        String id,
        String name,
        double price
) {
}
