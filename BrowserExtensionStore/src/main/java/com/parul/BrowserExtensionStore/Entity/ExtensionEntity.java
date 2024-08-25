package com.parul.BrowserExtensionStore.Entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Extensions")
@NoArgsConstructor
public class ExtensionEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int serialNo;

	    @Column(name = "extensionName", nullable = false, length = 50)
	    private String extensionName;

	    @Column(name = "devId", nullable = false)
	    private int devId;

	    @Column(name = "dateUploaded", nullable = true)
	    @Temporal(TemporalType.DATE)
	    private Date dateUploaded;

	    @Column(name = "lastModified", nullable = true)
	    @Temporal(TemporalType.DATE)
	    private Date lastModified;

	    @Column(name = "versionNo", nullable = false, length = 20)
	    private String versionNo;

	    @Column(name = "browserLink", length = 255)
	    private String browserLink;

	    @Lob
	    @Column(name = "extension")
	    private byte[] extension;

}
