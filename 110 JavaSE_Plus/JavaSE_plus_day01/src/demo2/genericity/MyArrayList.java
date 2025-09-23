package demo2.genericity;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo2genericity
 * @className demo2genericity.MyArrayList
 * @date 2024/11/13 19:53
 * @description 自定义List
 */
public class MyArrayList <T>{
    public T[] array;
    public int size;
    public MyArrayList()
    {
        array = (T[]) new Object[10];
    }

    public void add(T data)
    {
        array[size++] = data;
    }

    public T get(int index)
    {
        return array[index];
    }

    public void remove(int index)
    {
        for (int i = index; i < size - 1; i++)
        {
            array[i] = array[i + 1];
        }
        size--;
    }

    @Override
    public String toString() {
        return array.toString();
    }


}
