package main;

import java.util.ArrayList;
import java.util.List;

public class Quicksort {

	private int numIteraciones;

	public <L extends List<E>, E extends Comparable<E>> L ordenar(L lista) {

		int indicePivote;
		E pivote;
		List<E> listaIzq, listaDer;
		List<E> listaIzqMover, listaDerMover;
		List<E> listaIzqNoMover, listaDerNoMover;

		// caso base
		if (lista.size() <= 1) {
			// Caso base
		} else {

			indicePivote = lista.size() / 2;

			pivote = lista.get(indicePivote);

			listaIzq = lista.subList(0, indicePivote);

			listaIzqMover = new ArrayList<>();
			listaIzqNoMover = new ArrayList<>();

			numIteraciones += listaIzq.size();

			for (E e : listaIzq) {
				if (e.compareTo(pivote) > 0) {
					listaIzqMover.add(e);
				} else {
					listaIzqNoMover.add(e);
				}
			}

			listaDer = lista.subList(indicePivote + 1, lista.size());

			listaDerMover = new ArrayList<>();
			listaDerNoMover = new ArrayList<>();

			numIteraciones += listaDer.size();
			
			for (E e : listaDer) {
				if (e.compareTo(pivote) < 0) {
					listaDerMover.add(e);
				} else {
					listaDerNoMover.add(e);
				}
			}

			listaIzq = new ArrayList<>();
			listaIzq.addAll(listaIzqNoMover);
			listaIzq.addAll(listaDerMover);

			listaDer = new ArrayList<>();
			listaDer.addAll(listaDerNoMover);
			listaDer.addAll(listaIzqMover);

			lista.clear();
			lista.addAll(ordenar(listaIzq));
			lista.add(pivote);
			lista.addAll(ordenar(listaDer));

		}

		return lista;
	}

	static List<Integer> buildRandom() {

		List<Integer> lista = new ArrayList<>();
		int rNumber;

		for (int i = 0; i < 1000; i++) {

			rNumber = new Double(Math.random() * 1000).intValue();

			lista.add(new Integer(rNumber));

		}

		return lista;
	}

	public static void main(String args[]) {
		List<Integer> lista = new ArrayList<>();
		Quicksort quicksort;

		lista = buildRandom();

		quicksort = new Quicksort();
		
		lista = quicksort.ordenar(lista);
		
		System.out.println("Num iteraciones: "+quicksort.getNumIteraciones());

		for (Integer i : lista) {
			System.out.print(" ->" + i);
		}
	}

	public int getNumIteraciones() {
		return numIteraciones;
	}

	public void setNumIteraciones(int numIteraciones) {
		this.numIteraciones = numIteraciones;
	}
}
