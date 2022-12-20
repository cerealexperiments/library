package alatoo.edu.library.models.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Set<RoleDto> roleDtos = new HashSet<>();

    public UserDto(Long id, String username, String email, String password, Set<RoleDto> roleDtos) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleDtos = roleDtos;
    }

    public UserDto() {
    }
}