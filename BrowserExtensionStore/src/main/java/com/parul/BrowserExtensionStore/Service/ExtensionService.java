package com.parul.BrowserExtensionStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parul.BrowserExtensionStore.Entity.ExtensionEntity;
import com.parul.BrowserExtensionStore.Repository.ExtensionRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.Date;

@Service
public class ExtensionService {

    @Autowired
    private ExtensionRepo extensionRepo;

    public void saveExtension(String extensionName, int devId, Date dateUploaded, Date lastModified, String versionNo, String browserLink, String filePath) {
        File file = new File(filePath);
        byte[] fileData = null;

        // Read the file as an InputStream
        try (InputStream inputStream = new FileInputStream(file)) {
            fileData = Files.readAllBytes(file.toPath());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            System.out.println("Unable to read file");
            e.printStackTrace();
            return;
        }

        // Ensure that dates are not null
        if (dateUploaded == null || lastModified == null) {
            throw new IllegalArgumentException("dateUploaded and lastModified cannot be null");
        }

        long fileSize = file.length();
        System.out.println("File size in bytes: " + fileSize);

        // Print dates for debugging
        System.out.println("Date Uploaded: " + dateUploaded);
        System.out.println("Last Modified: " + lastModified);

        // Create an entity instance
        ExtensionEntity extension = new ExtensionEntity();
        extension.setExtensionName(extensionName);
        extension.setDevId(devId);
        extension.setDateUploaded(new java.sql.Date(dateUploaded.getTime())); // Convert java.util.Date to java.sql.Date
        extension.setLastModified(new java.sql.Date(lastModified.getTime())); // Convert java.util.Date to java.sql.Date
        extension.setVersionNo(versionNo);
        extension.setBrowserLink(browserLink);
        extension.setExtension(fileData);

        // Save the entity to the database
        try {
            extensionRepo.save(extension);
            System.out.println("Added successfully");
        } catch (Exception e) {
            System.out.println("Error saving extension: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
