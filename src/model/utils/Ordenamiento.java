package model.utils;

import java.util.Comparator;

import model.data_structures.ILista;

public class Ordenamiento<T extends Comparable<T>> {

	public void ordenarInsercion(ILista<T> lista, Comparator<T> criterio, boolean ascendente) {
	}

	public void ordenarShell(ILista<T> lista, Comparator<T> criterio, boolean ascendente) {
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

}
