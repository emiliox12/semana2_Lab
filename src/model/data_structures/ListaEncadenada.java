package model.data_structures;

import com.sun.tools.classfile.Annotation.element_value;

public class ListaEncadenada<T extends Comparable<T>> implements ILista <T> {


	private Elemento raiz;



	@Override
	public void addFirst( Elemento element) {

		Elemento primeroActual=  raiz;
		if (primeroActual==null) {
			raiz = element;
		}

		else {
			Elemento siguiente = (Elemento) element.darSiguiente();
			siguiente= (Elemento) primeroActual;
			raiz= element;
		}
	}

	@Override
	public void addLast( Elemento element) {
		Elemento actual=raiz;

		while (actual.darSiguiente() != null) {

			if (actual.darSiguiente()==null) {
				Elemento siguiente =(Elemento) actual.darSiguiente(); 
				siguiente=element;
			}
			actual=(Elemento) actual.darSiguiente();
		}
	}

	@Override
	public void insertElement(Elemento element, int pos) {

		Elemento elementoActual= raiz;
		int contador=0;
		Elemento anterior =null;
		while (elementoActual.darSiguiente()!=null && contador != pos-1) {
			anterior=elementoActual;
			if (contador== pos) {
				Elemento anterior1= (Elemento) anterior.darSiguiente();
				anterior1=element;
				Elemento siguiente =(Elemento) anterior1.darSiguiente();
				siguiente =elementoActual;


			}

			elementoActual= (Elemento) elementoActual.darSiguiente();
			contador++;
		}

	}

	@Override
	public T removeFirst() {

		Elemento eliminado=raiz;
		if (raiz.darSiguiente()!=null) {
			raiz=(Elemento) raiz.darSiguiente();
		}
		else {
			raiz=null;
		}

		return (T) eliminado;
	}

	@Override
	public T removeLast() {
		Elemento actual= raiz;
		Elemento rta = null;
		while (actual.darSiguiente()!=null) {
			rta=actual;
			if (actual.darSiguiente()==null) {
				actual=null;
			}
			actual=(Elemento) actual.darSiguiente();
		}

		return (T) rta;
	}

	@Override
	public T deleteElement(int pos) {
		// TODO Auto-generated method stub

		Elemento actual= raiz;
		Elemento anterior = null;
		Elemento siguiente;
		int contador=0;
		while (actual.darSiguiente()!= null && contador!= pos-1) {

			if (contador == pos) {
				siguiente= (Elemento) actual.darSiguiente();
				Elemento a=(Elemento) anterior.darSiguiente();
				a=siguiente;
			}
			anterior=actual;
			actual=(Elemento) actual.darSiguiente();
			contador++;
		}

		return (T) actual;
	}

	@Override
	public T firstElement() {
		return (T) raiz;
	}

	@Override
	public T lastElement() {

		Elemento actual =raiz;
		while (actual.darSiguiente()!=null) {
			if (actual.darSiguiente()==null) {
				return (T) actual;
			}
			actual= (Elemento) actual.darSiguiente();
		}
		return (T) actual;
	}

	@Override
	public T getElement(int pos) {

		Elemento actual= raiz;
		int contador=0;
		while (actual.darSiguiente()!= null && contador!= pos-1) {

			if (contador == pos) {
				return (T) actual;
			}

			actual=(Elemento) actual.darSiguiente();
			contador++;
		}

		return (T) actual;


	}

	@Override
	public int size() {

		Elemento actual= raiz;
		int rta = 0;
		if (raiz !=null) {
			while (actual!=null) {
				rta++;		
				actual=(Elemento) actual.darSiguiente();
			}
		}

		return rta;
	}

	@Override
	public boolean isEmpty() {
		boolean rta= false;
		if (size() > 0) {
			rta= true;
		}
		return rta;
	}

	@Override
	public int isPresent(T element) {
		int rta=0;
		Elemento actual=raiz;
		while (actual!= null) {
			if (actual.equals(element)) {
				rta=1;
			}
			actual= (Elemento) actual.darSiguiente();
		}

		return rta;
	}

	@Override
	public void exchange(int pos1, int pos2) {
		// TODO Auto-generated method stub
		Elemento uno= null;
		Elemento dos= null;
		Elemento actual= raiz;
		Elemento anterior=null;
		Elemento anterior1=null;
		Elemento anterior2=null;

		int contador =0;
		while (actual!= null) {
			if (contador==pos1) {
				uno= actual;
				anterior1 =anterior;

			}
			if (contador == pos2) {
				dos = actual;
				anterior2= anterior;
			}	
			if (uno!= null && dos!= null) {
				Elemento perdido= (Elemento) uno.darSiguiente();
				
				Elemento a1= (Elemento) anterior1.darSiguiente();
				a1=dos;
				Elemento a2= (Elemento) anterior2.darSiguiente();
				a2=uno;
				Elemento s2= (Elemento) dos.darSiguiente();
				Elemento s1= (Elemento) uno.darSiguiente();
				s1=s2;
				s2=perdido;
				
				
			}
			anterior= actual;
			actual= (Elemento) actual.darSiguiente();
			contador++;
		}
	}

	@Override
	public void changeInfo(int pos, T elem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFirst(T element) {
		// TODO Auto-generated method stub

	}}