package nz.co.sush.simplelistdetail.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tomtang on 30/10/15.
 */
@AutoValue
public abstract class Event implements Parcelable {
    public abstract long id();

    public abstract String type();

    @SerializedName("public")
    public abstract boolean isPublic();

    public abstract Actor actor();

    public static Event create(long id, String type, boolean isPublic, Actor actor) {
        return new AutoValue_Event(id, type, isPublic, actor);
    }

    public static TypeAdapter<Event> typeAdapter(Gson gson) {
        return new AutoValue_Event.GsonTypeAdapter(gson);
    }
}
