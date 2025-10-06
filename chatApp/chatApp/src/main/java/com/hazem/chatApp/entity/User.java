package com.hazem.chatApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private String nickName;
    private String fullName;
    private String email;
    private UserStatus status;
}
