package demo2.genericity;

public interface Data <T>{

    void add(T data);
    void delete(T data);
    void update(T data);
    T query(T data);

}
