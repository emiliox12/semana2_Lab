package model.data_structures;

/**
 * 2019-01-23 Estructura de Datos Arreglo Dinamico de T. El arreglo al llenarse
 * (llegar a su maxima capacidad) debe aumentar su capacidad.
 * 
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements ILista<T> {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int maxSize;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la
	 * posicion 0)
	 */
	private int currentSize;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T[] elements;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * 
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico(int max) {
		maxSize = max;
		elements = (T[]) new Comparable[maxSize];
		currentSize = 0;
	}

	public T buscar(T dato) {
		T rta = null;
		int i = 0;
		while (elements.length > i) {
			if (elements[i].equals(dato)) {
				rta = elements[i];
			}
			i++;
		}
		return rta;
	}

	public T eliminar(T dato) {
		T toEliminate = null;
		boolean eliminated = false;
		for (int i = 0; i < currentSize; i++) {
			if (dato.compareTo(elements[i]) == 0) {
				toEliminate = elements[i];
				elements[i] = (i < maxSize - 2) ? elements[i + 1] : null;
				eliminated = true;
			} else if (eliminated) {
				elements[i] = (i < maxSize - 2) ? elements[i + 1] : null;
			}
		}
		currentSize--;
		return toEliminate;
	}

	public void invertir() {
		T[] nuevoArreglo = (T[]) new Comparable[maxSize];
		for (int i = 0; i < currentSize; i++) {
			nuevoArreglo[i] = elements[maxSize - i - 1];
		}
		elements = nuevoArreglo;
	}

	@Override
	public void addFirst(T element) {
		if (currentSize == maxSize) {
			maxSize = 2 * maxSize;
			T[] copia = elements;
			elements = (T[]) new Comparable[maxSize];
			copia[0] = element;
			for (int i = 1; i < currentSize; i++) {
				elements[i] = copia[i];
			}
		} else {
			T[] copia = elements;
			elements = (T[]) new Comparable[maxSize];
			copia[0] = element;
			for (int i = 1; i < currentSize; i++) {
				elements[i] = copia[i];
			}
		}
		currentSize++;
	}

	@Override
	public void addLast(T element) {
		if (currentSize == maxSize) {
			maxSize = 2 * maxSize;
			T[] copia = elements;
			elements = (T[]) new Comparable[maxSize];
			for (int i = 0; i < currentSize; i++) {
				elements[i] = copia[i];
			}
		}
		elements[currentSize] = element;
		currentSize++;
	}

	@Override
	public void insertElement(T element, int pos) {
		
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T deleteElement(int pos) {
		return null;
	}

	@Override
	public T firstElement() {
		return elements[0];
	}

	@Override
	public T lastElement() {
		return elements[currentSize - 1];
	}

	@Override
	public T getElement(int pos) {
		if (pos > currentSize || pos < 0) {
			return null;
		} else {
			return elements[pos];
		}
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public int isPresent(T element) {
		for (int i = 0; i < currentSize; i++) {
			if (elements.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void exchange(int pos1, int pos2) {
		T temp = elements[pos1];
		elements[pos1] = elements[pos2];
		elements[pos2] = temp;
	}

	@Override
	public void changeInfo(int pos, T elem) {
		elements[pos] = elem;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (T t : elements) {
			result += " " + t;
		}
		return result;
	}
}
