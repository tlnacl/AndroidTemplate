package nz.co.sush.simplelistdetail.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import nz.co.sush.simplelistdetail.AndroidApplication;
import nz.co.sush.simplelistdetail.R;
import nz.co.sush.simplelistdetail.di.components.DaggerEventComponent;
import nz.co.sush.simplelistdetail.network.model.Event;
import nz.co.sush.simplelistdetail.network.model.EventResponse;
import nz.co.sush.simplelistdetail.presentation.EventListPresenter;
import nz.co.sush.simplelistdetail.view.EventListView;
import nz.co.sush.simplelistdetail.view.activity.EventDetailActivity;
import nz.co.sush.simplelistdetail.view.adapter.EventsAdapter;

/**
 * Created by tomtang on 3/11/15.
 */
public class EventListFragment extends BaseFragment implements EventListView, EventsAdapter.Callback {
    @BindView(R.id.rv_events)
    RecyclerView mRvEvents;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.retry)
    Button mRetry;
    private EventsAdapter mEventAdapter;
    @Inject
    EventListPresenter mEventListPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_events, container, false);
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mEventListPresenter.destroy();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mFab.setOnClickListener(view1 -> Snackbar.make(view1, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show());

        mEventAdapter = new EventsAdapter(this);
        mRvEvents.setAdapter(mEventAdapter);
        mRvEvents.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        loadEvents();
    }

    private void initialize() {
        DaggerEventComponent.builder().appComponent(AndroidApplication.getAppComponent()).build().inject(this);
        mEventListPresenter.setView(this);
    }

    @OnClick(R.id.retry)
    void onRetryClick(){
        loadEvents();
    }



    private void loadEvents() {
        mEventListPresenter.loadEvents();
    }

    @Override
    public void renderEventList(EventResponse eventList) {
        mEventAdapter.setEvents(eventList.items());
    }

    @Override
    public void showLoading() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showRetry() {
        mRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        mRetry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
    }

    @Override
    public void onItemClick(Event event) {
        startActivity(EventDetailActivity.getCallingIntent(getActivity(),event));
    }
}
