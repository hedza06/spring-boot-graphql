package com.hedza06.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DefaultPage<T> {

  private T data;
  private long totalElements;
  private long totalPages;

}
