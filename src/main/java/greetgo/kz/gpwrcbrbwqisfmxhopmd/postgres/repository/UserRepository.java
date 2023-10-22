package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.repository;

import com.mongodb.lang.Nullable;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

//    @Override
//    Page<User> findAll(Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.primaryPhoneNumber = :phoneNumber OR u.secondaryPhoneNumber = :phoneNumber")
    User findUserByPrimaryOrSecondaryPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Modifying
    @Query("DELETE FROM User u WHERE u.primaryPhoneNumber = :phoneNumber OR u.secondaryPhoneNumber = :phoneNumber")
    void deleteUserByPrimaryOrSecondaryPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
