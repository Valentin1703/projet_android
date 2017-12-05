package condorcet.projet_android_motard;

/**
 * Created by lafer on 05-12-17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
public class Deplacement {
    @SerializedName("$ref")
    @Expose
    String $ref;

    public Deplacement() {

    }
    public Deplacement(String $ref) {
        this.$ref = $ref;
    }

    public String get$ref() {
        return $ref;
    }

    public void set$ref(String $ref) {
        this.$ref = $ref;
    }

    @Override
    public String toString() {
        return $ref;
    }
}
