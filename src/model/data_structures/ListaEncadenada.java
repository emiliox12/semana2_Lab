package model.data_structures;

import java.util.ArrayList;



public class ListaEncadenada<T extends Comparable<T>> implements ILista <T> {


	private Nodo raiz;



	@Override
	public void addFirst(T element) {
		Nodo primeroActual = raiz;
		Nodo newNode = new Nodo(element);
		if (primeroActual==null) {
			raiz = newNode;
		}

		else {
			newNode.setNext(primeroActual);
			raiz= newNode;
		}
	}

	@Override
	public void addLast(T element) {
		Nodo actual = raiz;
		Nodo newNode = new Nodo(element);
		if (raiz == null) {
			raiz = newNode;
			return;
		}
		while (actual.getNext() != null) {
			actual = actual.getNext();
		}
		actual.setNext(newNode);
	}

	@Override
	public void insertElement(T element, int pos) {
		Nodo NodoActual= raiz.getNext();
		Nodo newNode = new Nodo(element);
		int posit=0;
		Nodo anterior= raiz;

		if (posit== pos-1) {
			addFirst(element);
		}
		posit++;
		while (NodoActual.getNext()!=null && posit <= pos) {

			if (posit== pos) {
				anterior.setNext(newNode);
				newNode.setNext(NodoActual);
			}
			anterior=anterior.getNext();
			NodoActual= NodoActual.getNext();
			posit++;
		}

	}

	@Override
	public T removeFirst() {
		Nodo eliminado=raiz;

		if (raiz.getNext()!=null) {
			raiz= raiz.getNext();
		}
		else {
			raiz=null;
		}

		return (T) eliminado;
	}

	@Override
	public T removeLast() {
		Nodo actual= raiz;
		Nodo rta = null;
		while (actual.getNext()!=null) {
			rta=actual;
			if (actual.getNext()==null) {
				actual=null;
			}
			actual=(Nodo) actual.getNext();
		}

		return (T) rta;
	}

	@Override
	public T deleteElement(int pos) {
		// TODO Auto-generated method stub

		Nodo actual= raiz.getNext();
		Nodo anterior = raiz;
		Nodo siguiente;
		int posit=0;
		if (posit==pos-1) {
			removeFirst();
		}

		while (actual.getNext()!= null && posit<=pos) {

			if (posit == pos) {
				siguiente = actual.getNext();
				anterior.setNext(siguiente);
				actual.setNext(null);
			}
			anterior=anterior.getNext();
			actual=actual.getNext();
			posit++;
		}

		return (T) actual;
	}

	@Override
	public T firstElement() {
		return (T) raiz.getElement();
	}

	@Override
	public T lastElement() {

		Nodo actual =raiz;
		
		while (actual.getNext() != null) {
			actual = actual.getNext();
		}
		return (T) actual.getElement();
	}

	@Override
	public T getElement(int pos) {

		Nodo actual= raiz.getNext();
		int posit=0;
		T rta= null;
		if (posit==pos-1) {
			firstElement();
		}
		while (actual.getNext()!= null && posit!= pos-1) {

			if (posit == pos) {
				rta= (T) actual.getElement();
			}
			actual=(Nodo) actual.getNext();
			posit++;
		}

		return (T) rta;


	}

	@Override
	public int size() {

		Nodo actual= raiz;
		int rta = 0;
		if (raiz !=null) {
			while (actual!=null) {
				rta++;		
				actual=(Nodo) actual.getNext();
			}
		}

		return rta;
	}

	@Override
	public boolean isEmpty() {
		boolean rta= true;
		if (size() > 0) {
			rta= false;
		}
		return rta;
	}

	@Override
	public int isPresent(T element) {
		int rta=0;
		Nodo actual=raiz;
		while (actual!= null) {
			if (actual.getElement().equals(element)) {
				rta=1;
			}
			actual= (Nodo) actual.getNext();
		}

		return rta;
	}

	@Override
	public void exchange(int pos1, int pos2) {
	
		ArrayList<Nodo> arregloTemporal= new ArrayList();
		Nodo actual = raiz;
		
		while (actual!=null) {
			arregloTemporal.add(actual);
			actual=actual.getNext();
		}
		Nodo uno= arregloTemporal.get(pos1);
		Nodo dos =arregloTemporal.get(pos2);
		Nodo anteriorUno= arregloTemporal.get(pos1-1);
		Nodo anteriorDos =arregloTemporal.get(pos2-1);
		
		if (uno!=null && dos!=null) {
			Nodo Siguiente1=uno.getNext();
			Nodo Siguiente2=dos.getNext();
			uno.setNext(Siguiente2);
			dos.setNext(Siguiente1);
			anteriorUno=dos;
			anteriorDos=uno;
		}
	}

	@Override
	public void changeInfo(int pos, T elem) {
		// TODO Auto-generated method stub
		Nodo actual =raiz;
		int posit=0;
		while (actual.getNext()!= null && posit <=pos-1) {
			
			if (posit==pos-1) {
				actual.setElement(elem);
			}
			actual=actual.getNext();
		}
	}
}