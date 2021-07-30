package br.com.digitalinovation.on.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalinovation.on.domain.dto.mapper.MenbroMapper;
import br.com.digitalinovation.on.domain.dto.request.MenbroDTO;
import br.com.digitalinovation.on.domain.dto.response.MessageResponseDTO;
import br.com.digitalinovation.on.domain.enums.Ativo;
import br.com.digitalinovation.on.domain.model.Menbro;
import br.com.digitalinovation.on.domain.repository.EnderecoRepository;
import br.com.digitalinovation.on.domain.repository.MenbroRespository;
import br.com.digitalinovation.on.domain.repository.PessoaReposiroty;
import br.com.digitalinovation.on.exception.EnderecoNotFoundException;
import br.com.digitalinovation.on.exception.MenbroNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MenbroService {

	private MenbroRespository menbroRepository;
	private final MenbroMapper menbroMapper;

	public MessageResponseDTO cadastra(MenbroDTO menbroDTO) {
		Menbro menbro = menbroMapper.toModel(menbroDTO);
		Menbro menbroSaved = menbroRepository.save(menbro);
		MessageResponseDTO messageResponse = createMessageResponse("Menbro cadastrado com sucesso ID ",
				menbroSaved.getId());
		return messageResponse;

	}

	public MenbroDTO buscarPorId(Long id) throws MenbroNotFoundException {
		Menbro menbro = menbroRepository.findById(id).orElseThrow(() -> new MenbroNotFoundException(id));
		return menbroMapper.toDTO(menbro);
	}

	public MenbroDTO buscaPorNome(String nome) throws MenbroNotFoundException {
		Menbro menbro = menbroRepository.findByName(nome).orElseThrow(() -> new MenbroNotFoundException(nome));
		return menbroMapper.toDTO(menbro);
	}

	public List<MenbroDTO> buscaPorDataDeAdmissao(String dataInicial, String dataFinal) {
		List<Menbro> listMenbro = menbroRepository.findByDataRangePesquisa(dataInicial, dataFinal);
		return listMenbro.stream().map(menbroMapper::toDTO).collect(Collectors.toList());
	}

	public List<MenbroDTO> buscaTodos() {
		List<Menbro> listMenbro = menbroRepository.findAll();
		return listMenbro.stream().map(menbroMapper::toDTO).collect(Collectors.toList());
	}

	public MessageResponseDTO atualizar(Long id, MenbroDTO menbroDTO) throws MenbroNotFoundException {
		menbroRepository.findById(id).orElseThrow(() -> new MenbroNotFoundException(id));

		Menbro menbro = menbroMapper.toModel(menbroDTO);
		Menbro updatedMenbro = menbroRepository.save(menbro);

		MessageResponseDTO messageResponse = createMessageResponse("Menbro desetivado com sucesso ID ",
				updatedMenbro.getId());

		return messageResponse;
	}

	public MessageResponseDTO excluir(Long id) throws MenbroNotFoundException {
		Menbro menbroLogicalDelete = menbroRepository.findById(id).orElseThrow(() -> new MenbroNotFoundException(id));
		menbroLogicalDelete.setFlagAtivacao(Ativo.NAO_ATIVO);
		menbroRepository.save(menbroLogicalDelete);
		MessageResponseDTO messageResponse = createMessageResponse("Menbro desetivado com sucesso ID ",
				menbroLogicalDelete.getId());

		return messageResponse;
	}

	private MessageResponseDTO createMessageResponse(String s, Long id2) {
		return MessageResponseDTO.builder().message(s + id2).build();
	}

}
