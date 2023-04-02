package com.hedza06.graphql.controller;

import com.hedza06.graphql.dto.UserDTO;
import com.hedza06.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;


  @QueryMapping
  public List<UserDTO> allUsers() {
    return userService.findAll();
  }

  @QueryMapping
  public Page<UserDTO> usersPage(@Argument Integer page, @Argument Integer size) {
    return userService.findPage(PageRequest.of(page, size));
  }

  @MutationMapping
  public UserDTO createUser(@Argument UserDTO user) {
    return userService.save(user);
  }
}
