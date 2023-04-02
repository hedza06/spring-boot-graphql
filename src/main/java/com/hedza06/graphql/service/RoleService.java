package com.hedza06.graphql.service;

import com.hedza06.graphql.entity.Role;
import com.hedza06.graphql.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleService {

  private final RoleRepository roleRepository;

  public List<Role> findAll() {
    return roleRepository.findAll();
  }
}
