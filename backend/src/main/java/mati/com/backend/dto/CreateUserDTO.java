package mati.com.backend.dto;

import javax.management.relation.Role;

public record CreateUserDTO(String email, String password, Role role) {

    
}
