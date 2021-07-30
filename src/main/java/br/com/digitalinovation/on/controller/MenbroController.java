package br.com.digitalinovation.on.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalinovation.on.domain.dto.request.MenbroDTO;
import br.com.digitalinovation.on.domain.dto.response.MessageResponseDTO;
import br.com.digitalinovation.on.exception.EnderecoNotFoundException;
import br.com.digitalinovation.on.exception.MenbroNotFoundException;
import br.com.digitalinovation.on.service.MenbroService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/CMO/menbro")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MenbroController {

	private final MenbroService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid MenbroDTO menbroDTO) {
		return service.cadastra(menbroDTO);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MenbroDTO findById(@PathVariable Long id) throws MenbroNotFoundException {
		return service.buscarPorId(id);
	}

	@GetMapping
	public List<MenbroDTO> listAll() {
		return service.buscaTodos();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid MenbroDTO menbroDTO)
			throws MenbroNotFoundException {
		return service.atualizar(id, menbroDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MessageResponseDTO delete(@PathVariable long id) throws MenbroNotFoundException {
		return service.excluir(id);
	}
}
