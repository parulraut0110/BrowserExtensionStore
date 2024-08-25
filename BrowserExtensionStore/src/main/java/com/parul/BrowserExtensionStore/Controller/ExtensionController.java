package com.parul.BrowserExtensionStore.Controller;

import java.util.Date;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.parul.BrowserExtensionStore.Service.ExtensionService;

@RestController
public class ExtensionController {

    @Autowired
    ExtensionService extensionService;

    @GetMapping("/mainController")
    public void mainController() throws IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateUploaded = sdf.parse("2024-08-18");  // Create a 'Date' object corresponding to the string input provided

        // Read the file as InputStream
        Path path = Paths.get("C:\\BrowserExtension\\me.jpeg");
        try (InputStream fileStream = Files.newInputStream(path)) {  // Use try-with-resources to ensure the stream is closed
            System.out.println("Saving extension entry...");
            // Call the service with the InputStream
            extensionService.saveExtension("Dark Mode Extension", 10, dateUploaded, dateUploaded, "1.0.0", "https://chromewebstore.google.com/detail/dark-reader/eimadpbcbfnmbkopoojfekhnkhdbieeh?pli=1", fileStream);
            System.out.println("Saved extension entry");
        }
    }
}

