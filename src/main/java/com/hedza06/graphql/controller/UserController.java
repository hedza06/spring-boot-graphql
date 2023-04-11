package com.hedza06.graphql.controller;

import com.hedza06.graphql.dto.DefaultPage;
import com.hedza06.graphql.dto.DefaultPage.PageInfo;
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
  public DefaultPage<List<UserDTO>> usersPage(@Argument Integer page, @Argument Integer size) {
    Page<UserDTO> usersPage = userService.findPage(PageRequest.of(page, size));
    return new DefaultPage<>(
        usersPage.getContent(),
        new PageInfo(usersPage.getTotalElements(), usersPage.getTotalPages())
    );
  }

  @MutationMapping
  public UserDTO createUser(@Argument UserDTO user) {
    return userService.save(user);
  }
}
