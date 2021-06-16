package com.poi.dudu.mapper;

import com.poi.dudu.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author eisuto
 */
public interface TypeRepository extends JpaRepository<Type,Long>, JpaSpecificationExecutor<Type> {

    Type findOneByName(String name);
}
