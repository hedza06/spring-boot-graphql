package com.hedza06.graphql.service;

import com.hedza06.graphql.dto.UserDTO;
import com.hedza06.graphql.entity.User;
import com.hedza06.graphql.mapper.UserMapper;
import com.hedza06.graphql.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;


  public List<UserDTO> findAll() {
    return userRepository.findWithRoles().stream().map(userMapper::toUserDTO).toList();
  }

  public Page<UserDTO> findPage(Pageable pageable) {
    Page<Integer> userIdPage = userRepository.findPageIds(pageable);
    List<User> users = userRepository.findWithRoles(userIdPage.getContent());
    return new PageImpl<>(
        users.stream().map(userMapper::toUserDTO).toList(),
        pageable,
        userIdPage.getTotalElements()
    );
  }

  public UserDTO findById(Integer id) {
    User user = userRepository.findByIdWithRoles(id).orElseThrow(EntityNotFoundException::new);
    return userMapper.toUserDTO(user);
  }

  public UserDTO save(UserDTO user) {
    User entity = userMapper.toEntity(user);
    userRepository.save(entity);
    return userMapper.toUserDTO(entity);
  }

  @Transactional
  public void deleteById(Integer id) {
    userRepository.deleteById(id);
  }
}
