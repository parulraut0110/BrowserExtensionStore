package com.parul.BrowserExtensionStore.Repository;

import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parul.BrowserExtensionStore.Entity.ExtensionEntity;

@Repository
public interface ExtensionRepo extends JpaRepository<ExtensionEntity, Integer> {

	   
}
