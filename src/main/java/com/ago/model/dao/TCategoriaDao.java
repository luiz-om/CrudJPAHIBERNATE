package com.ago.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ago.connection.ConnectionFactory;
import com.ago.model.bean.TCategoria;

public class TCategoriaDao {

	public TCategoria save(TCategoria categoria) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			if (categoria.getId() == null) {
				em.persist(categoria);
			} else {
				em.merge(categoria);
			}

			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();// TODO: handle exception
		} finally {
			em.close();
		}
		return categoria;
	}

	public TCategoria findById(Integer id) throws NullPointerException {
		EntityManager em = new ConnectionFactory().getConnection();

		TCategoria categoria = null;

		try {
			categoria = em.find(TCategoria.class, id);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return categoria;
	}

	@SuppressWarnings("unchecked")

	public List<TCategoria> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();

		List<TCategoria> categorias = null;

		try {
			// faz select na classe
			categorias = em.createQuery("from TCategoria c").getResultList();

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return categorias;
	}

	public TCategoria remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		TCategoria categoria = null;

		try {

			categoria = em.find(TCategoria.class, id);
			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return categoria;
	}
}
