package com.sjacob.persistence;

import org.springframework.data.repository.CrudRepository;

import com.sjacob.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
