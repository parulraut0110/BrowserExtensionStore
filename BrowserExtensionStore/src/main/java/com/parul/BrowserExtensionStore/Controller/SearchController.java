package com.parul.BrowserExtensionStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.parul.BrowserExtensionStore.Model.SearchData;
import com.parul.BrowserExtensionStore.Repository.ExtensionRepo;
import com.parul.BrowserExtensionStore.dto.SearchResultDTO;

@Controller
public class SearchController {
	@Autowired
	ExtensionRepo extensionRepo;
	
	@GetMapping("/search")
	public String handleSearch(@ModelAttribute("searchData") SearchData searchData, Model model) {
		System.out.println("searchData: " + searchData.getSearch());
		List<Object []> searchResults = extensionRepo.findInExtensionsStore(searchData.getSearch());
		System.out.println("Results: " + searchResults.get(0).length);
		model.addAttribute("searchResults", searchResults);
		return "searchQuery";
	}
}
