package com.example.gestiondepartements.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.gestiondepartements.entity.Etudiant;
import com.example.gestiondepartements.entity.dto.EtudiantDto;
import com.example.gestiondepartements.entity.dto.EtudiantUpdateDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EtudiantMapper {
    public EtudiantDto toEtudiantDto(Etudiant etudiant);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    public Etudiant toEtudiant(EtudiantDto etudiantDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    public void updateEtudiant(EtudiantUpdateDto etudiantDto, @MappingTarget Etudiant etudiant);
}