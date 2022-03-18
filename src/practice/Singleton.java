package practice;

public class Singleton {

    private static Singleton singleton;
    private Singleton()
    {

    }

    public static  Singleton getInstance()
    {

        if(singleton==null)
        {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }

        return singleton;

    }

    public static void main(String[] args) {
        Singleton singleton =  Singleton.getInstance();
        System.out.println(singleton);
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1);
    }
}
