package br.com.digitalinovation.on.domain.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.digitalinovation.on.domain.dto.request.MenbroDTO;
import br.com.digitalinovation.on.domain.model.Menbro;

@Mapper(componentModel = "spring")
public interface MenbroMapper {
	
	@Mapping(target =  "dataBatismo", source = "dataBatismo", dateFormat = "dd-MM-yyyy")
	@Mapping(target =  "dataAdmissao", source = "dataAdmissao", dateFormat = "dd-MM-yyyy")
	@Mapping(target =  "dataSaida", source = "dataSaida", dateFormat = "dd-MM-yyyy")
	Menbro toModel(MenbroDTO dto);
	
	MenbroDTO toDTO(Menbro dto);
}

