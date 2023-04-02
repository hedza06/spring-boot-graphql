package com.hedza06.graphql.dto;

import com.hedza06.graphql.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserDTO {

  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private Integer age;
  private DepartmentDTO department;
  private Set<Role> roles = new HashSet<>();

}
