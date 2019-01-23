package com.ago.teste;


import com.ago.model.bean.TProduto;
import com.ago.model.dao.TProdutoDao;

public class TProdutoTeste {

	public static void main(String[] args) {

		TProdutoDao dao = new TProdutoDao();

		TProduto p = new TProduto();

		p = dao.findById(2);

		System.out.println("Descrição: " + p.getDescricao());
		System.out.println("qtd: " + p.getQtd());
		System.out.println("valor: " + p.getValor());
		System.out.println("Categoria: " + p.getCategoria().getDescricao());
		
		for (TProduto tp : dao.findAll()) {
			System.out.println("id: " + tp.getId());
			System.out.println("Descrição: "+ tp.getDescricao());
			System.out.println("Quantidade: " + tp.getQtd());
		}

	}
}
