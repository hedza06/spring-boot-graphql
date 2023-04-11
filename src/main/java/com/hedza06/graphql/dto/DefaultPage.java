package com.hedza06.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DefaultPage<T> {

  private T nodes;
  private PageInfo pageInfo;

  @Getter
  @AllArgsConstructor
  public static class PageInfo {
    private long totalElements;
    private long totalPages;
  }
}
