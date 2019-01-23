package com.ago.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import com.ago.connection.ConnectionFactory;
import com.ago.model.bean.TProduto;

public class TProdutoDao {

	public TProduto save(TProduto produto) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			if (produto.getId() == null) {
				em.persist(produto);
			} else {
				em.merge(produto);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();

		}
		return produto;
	}

	public TProduto findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		TProduto produto = null;
		try {
			produto = em.find(TProduto.class, id);

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return produto;
	}

	@SuppressWarnings("unchecked")
	public List<TProduto> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();

		List<TProduto> produtos = null;

		try {
			// faz select na classe
			produtos = em.createQuery("from TProduto t").getResultList();

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return produtos;
	}

}
