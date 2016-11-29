package nz.co.sush.simplelistdetail.view;

import java.util.List;

import nz.co.sush.simplelistdetail.network.model.Event;

/**
 * Created by tomtang on 2/11/15.
 */
public interface EventListView extends LoadDataView{
    void renderEventList(List<Event> eventList);
}
