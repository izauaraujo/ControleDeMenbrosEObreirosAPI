package br.com.digitalinovation.on.service;

import java.util.List;


public interface IService <T>{
	
	T cadastra(T t);
	
	T  buscarPorId(Long id);
	
	List<T> buscaTodos();
	
	T atualizar(T t);
	
	List<T> buscaPorDataDeAdmissao(String dataInicial,String dataFinal);
	
	void excluir(T t);
	
	T buscaPorNome(String nome);

	
}