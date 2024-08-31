package com.parul.BrowserExtensionStore.Service;

import com.parul.BrowserExtensionStore.Entity.User;
import com.parul.BrowserExtensionStore.dto.UserRegistrationDto;

public interface UserService {
	User save(UserRegistrationDto registrationDto);
}
