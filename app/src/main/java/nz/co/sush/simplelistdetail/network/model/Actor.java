package nz.co.sush.simplelistdetail.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tlnacl on 1/12/16.
 */
@AutoValue
public abstract class Actor implements Parcelable{
    public abstract int id();

    @SerializedName("display_login")
    public abstract String displayLogin();

    public abstract String url();

    @SerializedName("avatar_url")
    public abstract String avatarUrl();


    public static Actor create(int id, String displayLogin, String url, String avatarUrl) {
        return new AutoValue_Actor(id, displayLogin, url, avatarUrl);
    }

    public static TypeAdapter<Actor> typeAdapter(Gson gson) {
        return new AutoValue_Actor.GsonTypeAdapter(gson);
    }
}
