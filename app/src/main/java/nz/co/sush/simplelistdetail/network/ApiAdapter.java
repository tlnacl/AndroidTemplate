package nz.co.sush.simplelistdetail.network;

import java.util.List;

import nz.co.sush.simplelistdetail.network.model.Event;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by tomtang on 28/10/15.
 */
public interface ApiAdapter {

    @GET("/events")
    Observable<List<Event>> getEventList();
}

