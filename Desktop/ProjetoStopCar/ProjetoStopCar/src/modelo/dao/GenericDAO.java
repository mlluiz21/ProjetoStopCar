package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDAO<T> {

	EntityManager getEntityManager();

	T lerPorId(Object id);

	List<T> lerTodos();

	T salvar(T objeto);

	void excluir(T objeto);

	void abrirTransacao();

	void gravarTransacao();

	void desfazerTransacao();

}
