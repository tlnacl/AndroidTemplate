package nz.co.sush.simplelistdetail.network;

import io.reactivex.Single;
import nz.co.sush.simplelistdetail.network.model.EventResponse;
import retrofit2.http.GET;
/**
 * Created by tomtang on 28/10/15.
 */
public interface ApiAdapter {

//    @GET("/events")Single<List<Event>> getEventList();//How to make List Event testable?
    @GET("/events")Single<EventResponse> getEventList();
}

