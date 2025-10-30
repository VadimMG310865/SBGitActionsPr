package org.sbmicroservice.menu.dto;

public record OrderDto(
        Integer id,
        String ordernum,
        int ordersum,
        int iduser
) {
}
