package com.reorg.user_setting.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    enum ColourPalette {
        NORMAL,
        DARK
    }
    
    @Id
    private String email;
    private String username;
    private String password;
    private String alias;
    private ColourPalette colourPalette;
    private String dateFormat;
}
