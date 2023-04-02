package com.hedza06.graphql.mapper;

import com.hedza06.graphql.dto.DepartmentDTO;
import com.hedza06.graphql.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

  DepartmentDTO toQuery(Department department);

}
