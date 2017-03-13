package nz.co.sush.simplelistdetail.network.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tomt on 13/03/17.
 */
@AutoValue
public abstract class EventResponse {
	public static EventResponse create(List<Event> items) {
		return new AutoValue_EventResponse(items);
	}

	public static EventResponse create(Event... items) {
		return new AutoValue_EventResponse(Arrays.asList(items));
	}

	public static TypeAdapter<EventResponse> typeAdapter(Gson gson) {
		return new AutoValue_EventResponse.GsonTypeAdapter(gson);
	}

	public abstract List<Event> items();
}
