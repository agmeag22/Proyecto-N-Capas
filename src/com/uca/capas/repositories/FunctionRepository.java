package com.uca.capas.repositories;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Function;

public interface FunctionRepository extends JpaRepository<Function, Integer>{
	
	public Page<Function> findAll(Pageable page);
	
	@Query(nativeQuery=true, value="select * from table_function WHERE id_film = :filmId")
	public List<Function> findAllByFilmId(@Param("filmId") int filmId) throws DataAccessException;
}
