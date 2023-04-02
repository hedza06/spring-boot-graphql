package com.hedza06.graphql.mapper;

import com.hedza06.graphql.dto.UserDTO;
import com.hedza06.graphql.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  UserDTO toUserDTO(User user);
  User toEntity(UserDTO user);
}
