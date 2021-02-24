package model.utils;

import java.util.Comparator;

import model.data_structures.ILista;

public class Ordenamiento<T extends Comparable<T>> {

	public void ordenarInsercion(ILista<T> lista, Comparator<T> criterio, boolean ascendente) {
		int scale = (ascendente) ? 1 : -1;
		for (int i = 0; i < lista.size(); i++) {
			boolean flag = false;
			for (int j = i + 1; j > 0 && flag; j--) {
				T elem = lista.getElement(j);
				T elem2 = lista.getElement(j - 1);
				if (criterio.compare(elem, elem2) * scale < 0) {
					lista.exchange(i, j);
				} else {
					flag = true;
				}
			}
		}
	}

	public void ordenarShell(ILista<T> lista, Comparator<T> criterio, boolean ascendente) {
		int n = lista.size();
		int h = 1;
		while (h < n/3) h = h * 3 + 1;
		int scale = (ascendente) ? 1 : -1;
		while (h >= 1) {
			for (int i = h + 1; i < n; i++) {
				boolean flag = false;
				for (int j = i; j > h; j -= h) {
					T elem = lista.getElement(j);
					T elem2 = lista.getElement(j - h);
					if (criterio.compare(elem, elem2) * scale < 0) {
						lista.exchange(i, j);
					} else {
						flag = true;
					}
				}
			}
			h /= 3;
		}
	}

	public void quicksort(ILista<T> lista, Comparator<T> criterio, boolean ascendente) {
		
	}
}
