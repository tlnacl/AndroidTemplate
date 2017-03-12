package nz.co.sush.simplelistdetail.network;

import java.util.List;

import io.reactivex.Single;
import nz.co.sush.simplelistdetail.network.model.Event;
import retrofit2.http.GET;
/**
 * Created by tomtang on 28/10/15.
 */
public interface ApiAdapter {

    @GET("/events")
    Single<List<Event>> getEventList();
}

