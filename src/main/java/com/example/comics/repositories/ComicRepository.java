package com.example.comics.repositories;

import com.example.comics.models.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic,Long> {

}
