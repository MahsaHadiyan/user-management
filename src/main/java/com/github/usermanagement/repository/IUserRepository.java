package com.github.usermanagement.repository;

import com.github.usermanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mahsa.Hadiyan  Date: 9/12/2023   Time: 12:42 PM
 **/
@Repository
public interface IUserRepository extends JpaRepository<Users,Long> {
    @Override
    <S extends Users> S save(S entity);

    Users findUsersById(Long id);
}
