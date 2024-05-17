package com.example.gestiondepartements.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.gestiondepartements.entity.Admin;
import com.example.gestiondepartements.entity.dto.AdminDto;
import com.example.gestiondepartements.entity.dto.AdminUpdateDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AdminMapper {

    public AdminDto toAdminDto(Admin admin);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    public Admin toAdmin(AdminDto adminDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    public void updateAdmin(AdminUpdateDto adminDto, @MappingTarget Admin admin);
}
