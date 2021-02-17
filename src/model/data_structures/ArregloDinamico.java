package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de T.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements ILista<T> {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Object[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Object[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	@Override
	public T darElemento(int i) {
		if (i > tamanoAct || i < 0) {
			return null;
		} else {
			return elementos[i];
		}
	}

	@Override
	public T buscar(T dato) {
		T rta = null;
		int i=0;
		while (elementos.length>i) {
			if (elementos[i].equals(dato)) {
				rta=elementos[i];
			}
			i++;
		}
		return rta;
	}
		
		@Override
		public T eliminar(T dato) {
			T toEliminate = null;
			boolean eliminated = false; 
			for (int i = 0; i < tamanoAct; i++) {
				if (dato.compareTo(elementos[i]) == 0) {
					toEliminate = elementos[i];
					elementos[i] = (i < tamanoMax -2) ? elementos[i+1] : null;
					eliminated = true;
				} else if (eliminated) {
					elementos[i] = (i < tamanoMax -2) ? elementos[i+1] : null;
				}
			}
			tamanoAct--;
			return toEliminate;
		}

		@Override
		public void invertir() {
			T[] nuevoArreglo= (T[]) new Object[tamanoMax];
			for (int i = 0; i < tamanoAct; i++) {
				nuevoArreglo[i] = elementos[tamanoMax - i - 1];
			}
			elementos = nuevoArreglo;
		}

		@Override
		public void addFirst(T element) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addLast(T element) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertElement(T element, int pos) {
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T firstElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T lastElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T getElement(int pos) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int isPresent(T element) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void exchange(int pos1, int pos2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void changeInfo(int pos, T elem) {
			// TODO Auto-generated method stub
			
		}

}
