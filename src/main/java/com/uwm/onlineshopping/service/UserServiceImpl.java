package com.uwm.onlineshopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwm.onlineshopping.dto.RoleDto;
import com.uwm.onlineshopping.dto.UserDto;
import com.uwm.onlineshopping.model.UserEntity;
import com.uwm.onlineshopping.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void saveUser(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userRepository.save(userEntity);

	}

	@Override
	public void updateUser(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userRepository.save(userEntity);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDto getUserById(Long id) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRepository.findById(id), userDto);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		return userRepository.findAll().stream().map(userEntity -> {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userEntity, userDto);
			return userDto;
		}).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserByUsername(String username) {
		UserDto userDto = new UserDto();
		UserEntity user = userRepository.findByUserName(username);
		BeanUtils.copyProperties(user, userDto);
		RoleDto roleDto = new RoleDto();
		BeanUtils.copyProperties(user.getRole(), roleDto);
		userDto.setRole(roleDto);
		System.out.println(userDto.getRole().getRoleName());
		return userDto;
	}

}
