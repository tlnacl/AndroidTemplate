package nz.co.sush.simplelistdetail.view;

import nz.co.sush.simplelistdetail.network.model.EventResponse;

/**
 * Created by tomtang on 2/11/15.
 */
public interface EventListView extends LoadDataView{
    void renderEventList(EventResponse eventList);
}
