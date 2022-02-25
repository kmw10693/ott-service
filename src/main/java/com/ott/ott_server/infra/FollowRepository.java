package com.ott.ott_server.infra;

import com.ott.ott_server.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    boolean existsByFromUserIdAndToUserId(Long fromUserId, Long toUserId);

    Optional<Follow> findByFromUserIdAndToUserId(Long fromUserId, Long toUserId);

    List<Follow> findByFromUserId(Long fromUserId);

    List<Follow> findByToUserId(Long ToUserId);
}
