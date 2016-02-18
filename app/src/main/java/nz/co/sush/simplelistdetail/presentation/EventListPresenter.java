package nz.co.sush.simplelistdetail.presentation;

import java.util.List;

import javax.inject.Inject;

import nz.co.sush.simplelistdetail.Event;
import nz.co.sush.simplelistdetail.PostExecutionThread;
import nz.co.sush.simplelistdetail.ThreadExecutor;
import nz.co.sush.simplelistdetail.di.PerActivity;
import nz.co.sush.simplelistdetail.network.ApiAdapter;
import nz.co.sush.simplelistdetail.view.EventListView;
import nz.co.sush.simplelistdetail.view.IView;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by tomtang on 2/11/15.
 */
@PerActivity
public class EventListPresenter implements Presenter {

    private ApiAdapter mApiAdapter;
    private ThreadExecutor mJobExecutor;
    private PostExecutionThread mUIThread;
    private EventListView mEventListView;
    private Subscription mSubscription;

    @Inject
    public EventListPresenter(ApiAdapter apiAdapter, ThreadExecutor jobExecutor, PostExecutionThread UIThread) {
        mApiAdapter = apiAdapter;
        mJobExecutor = jobExecutor;
        mUIThread = UIThread;
    }

    public void loadEvents() {
        mEventListView.showLoading();
        mSubscription = mApiAdapter.getEventList()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .observeOn(mUIThread.getScheduler())
                .subscribe(new Subscriber<List<Event>>() {
                    @Override
                    public void onCompleted() {
                        mEventListView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mEventListView.hideLoading();
                        mEventListView.showRetry();
                    }

                    @Override
                    public void onNext(List<Event> events) {
                        mEventListView.hideLoading();
                        mEventListView.renderEventList(events);
                    }
                });
    }

    @Override
    public void setView(IView view) {
        mEventListView = (EventListView) view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }

}
