package net.TechStore.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.TechStore.model.User;
import net.TechStore.DTO.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
