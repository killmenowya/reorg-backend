package com.reorg.user_setting.dto;

public record UserRegistratioRecord(
    String username,
    String email,
    String firstName,
    String lastName,
    String password
) {

}
