package com.saralash2.demo.repository;

import com.saralash2.demo.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 06/07/2023 - 11:57 PM
 * Created by Akhmadali
 */
public interface OrganizationRepository extends JpaRepository<Organization,Integer> {
}
