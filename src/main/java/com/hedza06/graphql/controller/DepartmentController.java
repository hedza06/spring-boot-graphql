package com.hedza06.graphql.controller;

import com.hedza06.graphql.dto.DepartmentDTO;
import com.hedza06.graphql.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

  private final DepartmentService departmentService;


  @QueryMapping
  public List<DepartmentDTO> allDepartments() {
    return departmentService.findAll();
  }
}
