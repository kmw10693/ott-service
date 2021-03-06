package com.ott.ott_server.infra;

import com.ott.ott_server.domain.UserOtt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOttRepository extends JpaRepository<UserOtt, Long> {

}
