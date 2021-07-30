package br.com.digitalinovation.on.domain.dto.mapper;

import org.mapstruct.Mapper;

import br.com.digitalinovation.on.domain.dto.request.EnderecoDTO;
import br.com.digitalinovation.on.domain.model.Endereco;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
	
	Endereco toModel(EnderecoDTO dto);
	
	EnderecoDTO toDTO(Endereco dto);
	
}
