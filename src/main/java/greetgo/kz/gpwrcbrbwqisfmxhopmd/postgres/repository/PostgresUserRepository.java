package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.repository;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.PostgresUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PostgresUserRepository extends JpaRepository<PostgresUser, Long> {

    @Query("SELECT u FROM PostgresUser u WHERE u.primaryPhoneNumber = :phoneNumber OR u.secondaryPhoneNumber = :phoneNumber")
    PostgresUser findUserByPrimaryOrSecondaryPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Modifying
    @Query("DELETE FROM PostgresUser u WHERE u.primaryPhoneNumber = :phoneNumber OR u.secondaryPhoneNumber = :phoneNumber")
    void deleteUserByPrimaryOrSecondaryPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
