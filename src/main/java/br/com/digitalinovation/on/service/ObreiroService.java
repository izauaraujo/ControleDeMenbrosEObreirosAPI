package br.com.digitalinovation.on.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalinovation.on.domain.dto.mapper.EnderecoMapper;
import br.com.digitalinovation.on.domain.dto.mapper.MenbroMapper;
import br.com.digitalinovation.on.domain.dto.mapper.ObreiroMapper;
import br.com.digitalinovation.on.domain.dto.request.ObreiroDTO;
import br.com.digitalinovation.on.domain.dto.response.MessageResponseDTO;
import br.com.digitalinovation.on.domain.enums.Ativo;
import br.com.digitalinovation.on.domain.model.Endereco;
import br.com.digitalinovation.on.domain.model.Menbro;
import br.com.digitalinovation.on.domain.model.Obreiro;
import br.com.digitalinovation.on.domain.repository.EnderecoRepository;
import br.com.digitalinovation.on.domain.repository.HistoricoObreiroRespository;
import br.com.digitalinovation.on.domain.repository.MenbroRespository;
import br.com.digitalinovation.on.domain.repository.ObreiroReposistory;
import br.com.digitalinovation.on.exception.MenbroNotFoundException;
import br.com.digitalinovation.on.exception.ObreiroNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ObreiroService {

	private ObreiroReposistory obreiroReposistory;
	private MenbroRespository menbroRepository;
	private HistoricoObreiroRespository historicoObreiroRespository;
	private EnderecoRepository enderecoRespository;
	private final MenbroMapper menbroMapper;
	private final ObreiroMapper obreiroMapper;
	private final EnderecoMapper enderecoMapper;

	public MessageResponseDTO cadastra(ObreiroDTO obreiroDTO) throws MenbroNotFoundException {
		String nomeMenbro = obreiroDTO.getMenbroDTO().getPessoa().getNome();
		Menbro menbro = menbroRepository.findByName(nomeMenbro)
				.orElseThrow(() -> new MenbroNotFoundException(nomeMenbro));
		obreiroDTO.setMenbroDTO(menbroMapper.toDTO(menbro));
		
		Obreiro obreiro = obreiroMapper.toModel(obreiroDTO);
		
		historicoObreiroRespository.save(obreiro.getHistoricoObreiro());
		Endereco endereco = enderecoMapper.toModel(obreiroDTO.getMenbroDTO().getPessoa().getEndereco());
		enderecoRespository.save(endereco);
		obreiro = obreiroReposistory.save(obreiro);
		MessageResponseDTO messageResponse = createMessageResponse("Obreiro Cadastrado com sucesso  - ID ",
				obreiro.getId());
		return messageResponse;
	}

	public ObreiroDTO buscarPorId(Long id) throws ObreiroNotFoundException {
		Obreiro obreiro = obreiroReposistory.findById(id).orElseThrow(() -> new ObreiroNotFoundException(id));
		return obreiroMapper.toDTO(obreiro);
	}

	public MessageResponseDTO atualizar(Long id, ObreiroDTO obreiroDTO) throws ObreiroNotFoundException {
		String nomeMenbro = obreiroDTO.getMenbroDTO().getPessoa().getNome();
		Menbro menbro = menbroRepository.findById(id)
				.orElseThrow(() -> new ObreiroNotFoundException(nomeMenbro));

		obreiroDTO.setMenbroDTO(menbroMapper.toDTO(menbro));
		Obreiro obreiro = obreiroMapper.toModel(obreiroDTO);
		historicoObreiroRespository.save(obreiro.getHistoricoObreiro());
		Endereco endereco = enderecoMapper.toModel(obreiroDTO.getMenbroDTO().getPessoa().getEndereco());
		enderecoRespository.save(endereco);
		obreiro = obreiroReposistory.save(obreiro);
		
		MessageResponseDTO messageResponse = createMessageResponse("Obreiro Cadastrado com sucesso  - ID ",
				obreiro.getId());
		
		return messageResponse;
	}

	public List<ObreiroDTO> buscaTodosAtivos() {
		List<Obreiro> listObreiro = obreiroReposistory.findByAllAtivos(Ativo.ATIVO);
		return listObreiro.stream().map(obreiroMapper::toDTO).collect(Collectors.toList());
	}

	public List<ObreiroDTO> buscaTodos() {
		List<Obreiro> listObreiro = obreiroReposistory.findAll();
		return listObreiro.stream().map(obreiroMapper::toDTO).collect(Collectors.toList());
	}

	public List<ObreiroDTO> buscaPorDataDeAdmissao(String dataInicial, String dataFinal) {
		List<Obreiro> listObreiro = obreiroReposistory.findByDataRangePesquisa(dataInicial, dataFinal);
		return listObreiro.stream().map(obreiroMapper::toDTO).collect(Collectors.toList());
	}

	public ObreiroDTO buscaPorNome(String nome) {
		Obreiro obreiro = obreiroReposistory.findByNome(nome).get();
		return obreiroMapper.toDTO(obreiro);
	}

	// Não faz exclusão fisicamente
	public MessageResponseDTO excluir(Long id) throws ObreiroNotFoundException {
		Obreiro obreiro = obreiroReposistory.findById(id).orElseThrow(() -> new ObreiroNotFoundException(id));
		obreiro.setFlagAtivacao(Ativo.NAO_ATIVO);
		
		obreiroReposistory.save(obreiro);
		
		MessageResponseDTO messageResponse = createMessageResponse("Obreiro Desativado com sucesso  - ID ",
				obreiro.getId());
		
		return messageResponse;
	}

	private MessageResponseDTO createMessageResponse(String s, Long id2) {
		return MessageResponseDTO.builder().message(s + id2).build();
	}

}
