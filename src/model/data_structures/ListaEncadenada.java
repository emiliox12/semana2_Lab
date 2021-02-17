package model.data_structures;


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
		Nodo NodoActual= raiz;
		int contador=0;
		Nodo anterior =null;
		while (NodoActual.getNext()!=null && contador != pos-1) {
			anterior=NodoActual;
			if (contador== pos) {
				Nodo anterior1= (Nodo) anterior.getNext();
				anterior1=element;
				Nodo siguiente =(Nodo) anterior1.getNext();
				siguiente =NodoActual;


			}

			NodoActual= (Nodo) NodoActual.getNext();
			contador++;
		}

	}

	@Override
	public T removeFirst() {

		Nodo eliminado=raiz;
		if (raiz.getNext()!=null) {
			raiz=(Nodo) raiz.getNext();
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

		Nodo actual= raiz;
		Nodo anterior = null;
		Nodo siguiente;
		int contador=0;
		while (actual.getNext()!= null && contador!= pos-1) {

			if (contador == pos) {
				siguiente= (Nodo) actual.getNext();
				Nodo a=(Nodo) anterior.getNext();
				a=siguiente;
			}
			anterior=actual;
			actual=(Nodo) actual.getNext();
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

		Nodo actual =raiz;
		while (actual.getNext()!=null) {
			if (actual.getNext()==null) {
				return (T) actual;
			}
			actual= (Nodo) actual.getNext();
		}
		return (T) actual;
	}

	@Override
	public T getElement(int pos) {

		Nodo actual= raiz;
		int contador=0;
		while (actual.getNext()!= null && contador!= pos-1) {

			if (contador == pos) {
				return (T) actual;
			}

			actual=(Nodo) actual.getNext();
			contador++;
		}

		return (T) actual;


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
		boolean rta= false;
		if (size() > 0) {
			rta= true;
		}
		return rta;
	}

	@Override
	public int isPresent(T element) {
		int rta=0;
		Nodo actual=raiz;
		while (actual!= null) {
			if (actual.equals(element)) {
				rta=1;
			}
			actual= (Nodo) actual.getNext();
		}

		return rta;
	}

	@Override
	public void exchange(int pos1, int pos2) {
		// TODO Auto-generated method stub
		Nodo uno= null;
		Nodo dos= null;
		Nodo actual= raiz;
		Nodo anterior=null;
		Nodo anterior1=null;
		Nodo anterior2=null;

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
				Nodo perdido= (Nodo) uno.getNext();
				
				Nodo a1= (Nodo) anterior1.getNext();
				a1=dos;
				Nodo a2= (Nodo) anterior2.getNext();
				a2=uno;
				Nodo s2= (Nodo) dos.getNext();
				Nodo s1= (Nodo) uno.getNext();
				s1=s2;
				s2=perdido;
				
				
			}
			anterior= actual;
			actual= (Nodo) actual.getNext();
			contador++;
		}
	}

	@Override
	public void changeInfo(int pos, T elem) {
		// TODO Auto-generated method stub

	}
}