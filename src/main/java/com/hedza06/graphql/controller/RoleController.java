package com.hedza06.graphql.controller;

import com.hedza06.graphql.entity.Role;
import com.hedza06.graphql.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoleController {

  private final RoleService roleService;


  @QueryMapping
  public List<Role> allRoles() {
    return roleService.findAll();
  }

}
