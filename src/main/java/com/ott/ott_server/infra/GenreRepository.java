package com.ott.ott_server.infra;

import com.ott.ott_server.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Optional<Genre> findByNameContaining(String name);
}
