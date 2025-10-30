package org.sbmicroservice.menu.dto;

public record UserDto(
        Integer id,
        String name,
        int balance
) {
}
