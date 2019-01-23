package com.ago.teste;

import java.util.Scanner;

import com.ago.model.bean.TCategoria;
import com.ago.model.dao.TCategoriaDao;

public class TCategoriaTeste {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Integer num = 0;
		System.out.println("digite o id a ser pesquisado: ");
		num = scan.nextInt();
		TCategoriaDao dao = new TCategoriaDao();

		TCategoria tc = new TCategoria();
		tc = dao.findById(num);

		System.out.println("Descrição: " + tc.getId());
		System.out.println("Descrição: " + tc.getDescricao());
		
		for (TCategoria c : dao.findAll()) {
			System.out.println("descrição: " + c.getDescricao());
		}
		
	//	tc= dao.remove(3);
		
		System.out.println("Id deletado: " + tc.getId());

	}

}
