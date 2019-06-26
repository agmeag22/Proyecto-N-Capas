package com.uca.capas.repositories;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Departamento;
import com.uca.capas.domain.Film;
import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.Paises;
import com.uca.capas.domain.Role;
import com.uca.capas.domain.User;

public interface PaisRepository extends JpaRepository<Paises, Integer>{
	
}
