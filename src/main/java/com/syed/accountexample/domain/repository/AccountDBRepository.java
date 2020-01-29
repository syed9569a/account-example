package com.syed.accountexample.domain.repository;

import com.syed.accountexample.domain.AccountDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AccountDBRepository extends JpaRepository<AccountDB, Long> {

    @Query("SELECT a from AccountDB a where a.first_name = :firstName")
    List<AccountDB> findByName(String firstName);

}
