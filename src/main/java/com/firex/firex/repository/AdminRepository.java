package com.firex.firex.repository;

import com.firex.firex.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends  JpaRepository<Admin, Long> {
}
