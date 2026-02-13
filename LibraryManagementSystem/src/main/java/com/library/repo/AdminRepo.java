package com.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.AdminInformation;

public interface AdminRepo  extends JpaRepository<AdminInformation, Integer>
{
	

}
