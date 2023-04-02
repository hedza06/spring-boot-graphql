package com.hedza06.graphql.service;

import com.hedza06.graphql.dto.DepartmentDTO;
import com.hedza06.graphql.mapper.DepartmentMapper;
import com.hedza06.graphql.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {

  private final DepartmentRepository departmentRepository;
  private final DepartmentMapper departmentMapper;


  public List<DepartmentDTO> findAll() {
    return departmentRepository.findAll().stream().map(departmentMapper::toQuery).toList();
  }

  public DepartmentDTO findById(Integer id) {
    return departmentRepository
        .findById(id)
        .map(departmentMapper::toQuery).orElseThrow(EntityNotFoundException::new);
  }
}
