package condorcet.projet_android_motard;

/**
 * Created by User on 01-12-17.
 */

public class Globals {
    private static Globals instance;

    // Global variable
    private int data;

    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setData(int d){
        this.data=d;
    }
    public int getData(){
        return this.data;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }

}
