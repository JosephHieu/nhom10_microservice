package com.josephhieu.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lưu ý: UserDto không cần phải giống hệt entity User, chỉ cần có đủ dữ liệu cần dùng.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
}

