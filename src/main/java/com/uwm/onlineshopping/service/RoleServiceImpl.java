package com.uwm.onlineshopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwm.onlineshopping.dto.RoleDto;
import com.uwm.onlineshopping.model.RoleEntity;
import com.uwm.onlineshopping.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public void saveRole(RoleDto roleDto) {
		RoleEntity roleEntity = new RoleEntity();
		BeanUtils.copyProperties(roleDto, roleEntity);
		roleRepository.save(roleEntity);

	}

	@Override
	public void updateRole(RoleDto roleDto) {
		RoleEntity roleEntity = new RoleEntity();
		BeanUtils.copyProperties(roleDto, roleEntity);
		roleRepository.save(roleEntity);

	}

	@Override
	public void deleteRole(Long id) {
		roleRepository.deleteById(id);

	}

	@Override
	public RoleDto getRoleById(Long id) {
		RoleDto roleDto = new RoleDto();
		BeanUtils.copyProperties(roleRepository.findById(id), roleDto);
		return roleDto;
	}

	@Override
	public List<RoleDto> getAllRole() {
		return roleRepository.findAll().stream().map(RoleEntity -> {
			RoleDto roleDto = new RoleDto();
			BeanUtils.copyProperties(RoleEntity, roleDto);
			return roleDto;
		}).collect(Collectors.toList());
	}

}
