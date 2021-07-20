package com.usermanagenentrestapi.repository;

import com.usermanagenentrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "Select * from employee where status = 1")
    public List<User> getListUser();
    @Query(nativeQuery = true, value = "Select * from employee where status = 1 and id = ?1")
    public User getUserById(int id);
    @Query(nativeQuery = true, value = "Select * from employee where status = 1 and name like %?1%")
    List<User> findByNameIsLike(String name);
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update employee set status = 0 where id = ?1 and status = 1")
    Integer deleteUser(Long id);
    @Query(nativeQuery = true, value = "Select * from employee where status = 1 and email = ?1 and password = ?2")
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
