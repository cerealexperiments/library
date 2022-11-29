package alatoo.edu.library.models.dto;

import alatoo.edu.library.models.enums.ERole;
import lombok.Data;

@Data
public class RoleDto {
    private Integer id;
    private ERole name;
}
