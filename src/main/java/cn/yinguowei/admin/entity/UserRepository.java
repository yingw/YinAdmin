package cn.yinguowei.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author yinguowei 2018/3/5.
 */
//@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * search User by username, for login function.
     * @param username
     * @return
     */
    User findByUsername(@Param("username") String username);
}