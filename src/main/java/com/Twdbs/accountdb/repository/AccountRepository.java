package com.Twdbs.accountdb.repository;

import com.Twdbs.accountdb.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//try t remove repos anno
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
