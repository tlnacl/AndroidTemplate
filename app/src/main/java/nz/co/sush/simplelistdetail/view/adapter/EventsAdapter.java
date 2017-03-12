package nz.co.sush.simplelistdetail.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nz.co.sush.simplelistdetail.R;
import nz.co.sush.simplelistdetail.network.model.Event;

/**
 * Created by tomtang on 30/10/15.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventHolder> {

    private List<Event> mEventList;
    private Callback callback;

    public EventsAdapter(Callback callback) {
        mEventList = new ArrayList<>();
        this.callback = callback;
    }

    public void setEvents(List<Event> eventList) {
        mEventList = eventList;
        notifyDataSetChanged();
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
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
        @BindView(R.id.event_id)
        TextView eventId;
        @BindView(R.id.actor)
        TextView actor;
        @BindView(R.id.event_item_layout)
        View itemLayout;
        Context context;

        public EventHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        public void bind(Event event) {
            eventId.setText(context.getString(R.string.event_id,event.id()));
            actor.setText(context.getString(R.string.event_actor,event.actor().displayLogin()));
            itemLayout.setOnClickListener(view -> callback.onItemClick(event));
        }
    }

    public interface Callback{
        void onItemClick(Event event);
    }
}
