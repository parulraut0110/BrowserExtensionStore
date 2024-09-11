package com.parul.BrowserExtensionStore.Repository;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parul.BrowserExtensionStore.Entity.ExtensionEntity;
import com.parul.BrowserExtensionStore.dto.SearchResultDTO;

@Repository
public interface ExtensionRepo extends JpaRepository<ExtensionEntity, Integer> {


	@Query(value = "SELECT extensionName, description " +
			"FROM extensions " +
			"WHERE MATCH(extensionName, description) " +
			"AGAINST (?1 WITH QUERY EXPANSION)",
			nativeQuery = true)
	List<Object[]> findInExtensionsStore(String searchQuery);



}
