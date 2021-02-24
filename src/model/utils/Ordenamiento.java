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

	public void ordenarMergeSort(ILista<T> lista, Comparator<T> criterio, boolean ascendente) {
		int size = lista.size();
		if (size>1) {
			int mitad = size/2;

			ILista<T> listaIzqui = lista.subList(1, mitad);
			ILista<T> listaDerech = lista.subList(mitad+1, size-mitad);

			ordenarMergeSort(listaIzqui, criterio, ascendente);
			ordenarMergeSort(listaDerech, criterio, ascendente);
			
			int i,j,k;
			i=j=k=1;
			
			int leftelements = listaIzqui.size();
			int rightelements = listaDerech.size();
			
			while(i <= leftelements && j <= rightelements) {
				T elemi = listaIzqui.getElement(i);
				T elemj = listaDerech.getElement(j);
				int factorComparacion = (ascendente?1:-1) * criterio.compare(elemi, elemj);
				if(factorComparacion <= 0) {
					lista.changeInfo(k, elemi);
					i++;
				}
				else {
					lista.changeInfo(k, elemj);
					j++;
				}
				k++;
			}
			while (i<=leftelements) {
				lista.changeInfo(k, listaIzqui.getElement(i));
				i++;
				k++;
			}
			while(j <= rightelements) {
				lista.changeInfo(k, listaDerech.getElement(j));
				j++;
				k++;
			}
		}
	}

	public void quicksort(ILista<T> lista, Comparator<T> criterio, boolean ascendente) {
		
	}
}
