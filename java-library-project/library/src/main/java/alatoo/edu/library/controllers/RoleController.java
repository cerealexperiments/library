package alatoo.edu.library.controllers;

import alatoo.edu.library.models.dto.RoleDto;
import alatoo.edu.library.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController implements BaseCrudController<RoleDto, Long>{
    @Autowired
    private RoleService service;


    public ResponseEntity<RoleDto> save(@RequestBody RoleDto imageDto) {
        return null;
    }

    @Override
    public ResponseEntity<RoleDto> update(RoleDto imageDto) {
        return null;
    }

    @Override
    public ResponseEntity<RoleDto> findById(Long id) {
        return null;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<RoleDto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/automatic-add")
    public ResponseEntity<List<RoleDto>> automaticBaseRoles() {
        return new ResponseEntity<>(service.automaticBaseRoles(), HttpStatus.CREATED);
    }
}
