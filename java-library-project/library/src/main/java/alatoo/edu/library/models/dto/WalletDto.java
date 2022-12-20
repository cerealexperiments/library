package alatoo.edu.library.models.dto;

import alatoo.edu.library.models.entities.User;
import lombok.Data;

import javax.persistence.*;
@Data
public class WalletDto {
    private Long id;
    private UserDto userDto;
    private double money;
}