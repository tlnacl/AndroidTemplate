package nz.co.sush.simplelistdetail;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by tomtang on 30/10/15.
 */
public class Event implements Serializable {
    @SerializedName("id")
    private long id;
    @SerializedName("type")
    private String type;
    @SerializedName("public")
    private boolean isPublic;

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isPublic() {
        return isPublic;
    }
}
