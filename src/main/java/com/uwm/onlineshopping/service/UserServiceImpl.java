package com.uwm.onlineshopping.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwm.onlineshopping.dto.RoleDto;
import com.uwm.onlineshopping.dto.UserDto;
import com.uwm.onlineshopping.model.RoleEntity;
import com.uwm.onlineshopping.model.UserEntity;
import com.uwm.onlineshopping.repository.UserRepository;
import com.uwm.onlineshopping.util.ShoppingCartUtil;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public void saveUser(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFullName(userDto.getFullName());
		userEntity.setEmail(userDto.getEmail());
		userEntity.setUserName(userDto.getUserName());
		userEntity.setDob(userDto.getDob());
		userEntity.setPassword(ShoppingCartUtil.encodePassword(userDto.getPassword()));

		RoleEntity role = new RoleEntity();
		role.setId(2L);
		role.setRoleName("ROLE_CUSTOMER");
		userEntity.setRole(role);

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
