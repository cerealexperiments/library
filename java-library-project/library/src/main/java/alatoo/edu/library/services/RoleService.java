package alatoo.edu.library.services;

import alatoo.edu.library.models.dto.RoleDto;

import java.util.List;

public interface RoleService extends BaseCrudService<RoleDto, Long>{
    List<RoleDto> automaticBaseRoles();
}
