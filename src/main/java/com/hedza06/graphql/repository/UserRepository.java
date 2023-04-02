package com.hedza06.graphql.repository;

import com.hedza06.graphql.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("""
  select user from User user
  left join fetch user.roles
  left join fetch user.department
  """)
  List<User> findWithRoles();

  @Query("""
  select user from User user
  left join fetch user.roles
  left join fetch user.department
  where user.id in (:userIds)""")
  List<User> findWithRoles(@Param("userIds") List<Integer> userIds);

  @Query("""
  select user from User user
  left join fetch user.roles
  left join fetch user.department
  where user.id = :id
  """)
  Optional<User> findByIdWithRoles(@Param("id") Integer id);

  @Query("select user.id from User user")
  Page<Integer> findPageIds(Pageable pageable);
}
