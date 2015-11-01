package nz.co.sush.simplelistdetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tomtang on 30/10/15.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventHolder> {

    private List<Event> mEventList;

    public EventsAdapter() {
        mEventList = new ArrayList<>();
    }

    public void setEvents(List<Event> eventList) {
        mEventList = eventList;
        notifyDataSetChanged();
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_event, parent, false);
        return new EventHolder(v);
    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        holder.bind(mEventList.get(position));
    }

    public class EventHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.event_id)
        TextView eventId;

        public EventHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Event event) {
            eventId.setText(String.valueOf(event.getId()));
        }
    }
}
