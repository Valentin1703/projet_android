package condorcet.projet_android_motard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class ListZone {
    @SerializedName("items")
    @Expose
    private ArrayList<Zone> items= new ArrayList<>();
    @SerializedName("next")
    @Expose
    private Deplacement next;
    @SerializedName("previous")
    @Expose
    private Deplacement previous;
    @SerializedName("first")
    @Expose
    private Deplacement first;

    public ArrayList<Zone> getItems() {
        return items;
    }

    public void setItems(ArrayList<Zone> items) {
        this.items = items;
    }

    public Deplacement getNext() {
        return next;
    }

    public void setNext(Deplacement next) {
        this.next = next;
    }

    public Deplacement getPrevious() {
        return previous;
    }

    public void setPrevious(Deplacement previous) {
        this.previous = previous;
    }

    public Deplacement getFirst() {
        return first;
    }

    public void setFirst(Deplacement first) {
        this.first = first;
    }

}


