package com.parul.BrowserExtensionStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parul.BrowserExtensionStore.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
}
