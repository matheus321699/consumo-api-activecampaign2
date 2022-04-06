package dto;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("activecampaign");
		} catch (Exception e) {
			
		}	
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe =classe;
		em = emf.createEntityManager(); 
	}
	
	public DAO<E> abrirTrans() {
		em.getTransaction().begin();
		
		// Retorna o próprio objeto;
		return this;
	}
	
	public DAO<E> fecharTrans() {
		em.getTransaction().commit();
		
		// Retorna o próprio objeto;
		return this;
	}
	
	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		
		// Retorna o próprio objeto;
		return this;
	}
	
	public DAO<E> incluirTodos(List<Object> listaUsuarios) {
		
		 for(int i = 0; i < listaUsuarios.size(); i++) {
	        	
			 em.persist(listaUsuarios.get(i));
	     }
				
		// Retorna o próprio objeto;
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) {	
		return this.abrirTrans().incluir(entidade).fecharTrans();		
	}
	
	public DAO<E> incluirTodosAtomico(List<Object> listaUsuarios) {	
		return this.abrirTrans().incluirTodos(listaUsuarios).fecharTrans();		
	}
	
	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int qtde, int deslocamento) {
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}

		String jpql = "select e from" + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return query.getResultList(); 
	}
	
	public void fechar() {
		em.close();
	}

}
