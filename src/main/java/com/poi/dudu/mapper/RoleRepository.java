package com.poi.dudu.mapper;

import com.poi.dudu.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author eisuto
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * 批量删除
     * @param ids
     * @return
     */
    void deleteByIdIn(Long[] ids);
}
