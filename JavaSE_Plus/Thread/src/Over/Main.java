package Over;

public class Main {

    public int add (int x, int y){
        return x+y;
    }
//    public String add (int x, int y){
//        return x+y;
//    }
    public String add (int x, int y, int z){

        return "重载";
    }
}


class Son extends Main
{
    public int add (int x, int y){
        return x+y;
    }
}