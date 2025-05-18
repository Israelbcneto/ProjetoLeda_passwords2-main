package interfaces;

public interface ITwoParamFunction<T, U, R> {
    R apply(T param1, U param2);
}
