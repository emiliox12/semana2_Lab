package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de T.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T> {
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
			for (int i = 0; i < tamanoAct; i++) {
				if (dato.compareTo(elementos[i]) == 0) {
					return elementos[i];
				}
			}
			return null;
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

}
