package com.example.gestiondepartements.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.gestiondepartements.entity.Enseignant;
import com.example.gestiondepartements.entity.dto.EnseignantDto;
import com.example.gestiondepartements.entity.dto.EnseignantUpdateDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnseignantMapper {
    public EnseignantDto toEnseignantDto(Enseignant enseignant);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    public Enseignant toEnseignant(EnseignantDto enseignantDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    public void updateEnseignant(EnseignantUpdateDto enseignantDto, @MappingTarget Enseignant enseignant);
}
