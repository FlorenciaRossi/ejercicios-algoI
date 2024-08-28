public interface Pila<T> {
    // Genéricos -> permiten que se operre con distintos tipos de datos específicos de manera segura.
    //              Provee código más flexible y reutilizable sin comprometer la seguridad de tipo. 
    // modificador de acceso public por defecto
    // específica el tipo de retorno y parámetros del método
    void apilar(T elemento);
    T tope();
    T desapilar();
    boolean esVacia();
}
