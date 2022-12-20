package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.RoleRepo;
import alatoo.edu.library.mappers.ReaderMapper;
import alatoo.edu.library.mappers.RoleMapper;
import alatoo.edu.library.models.dto.RoleDto;
import alatoo.edu.library.models.entities.Role;
import alatoo.edu.library.models.enums.ERole;
import alatoo.edu.library.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo repo;

    public List<RoleDto> automaticBaseRoles() {
        RoleDto role1 = new RoleDto();
        role1.setName(ERole.ROLE_ADMIN);
        RoleDto role2 = new RoleDto();
        role2.setName(ERole.ROLE_USER);
        RoleDto role3 = new RoleDto();
        role3.setName(ERole.ROLE_MODERATOR);
        List<RoleDto> roleDtos = new ArrayList<>();
        roleDtos.add(map().toDto(repo.save(map().toEntity(role1))));
        roleDtos.add(map().toDto(repo.save(map().toEntity(role2))));
        roleDtos.add(map().toDto(repo.save(map().toEntity(role3))));
        return roleDtos;
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        return null;
    }

    @Override
    public RoleDto update(RoleDto roleDto) {
        return null;
    }

    @Override
    public RoleDto findById(Long id) {
        return null;
    }

    @Override
    public List<RoleDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    public RoleMapper map() {
        return new RoleMapper();
    }
}
