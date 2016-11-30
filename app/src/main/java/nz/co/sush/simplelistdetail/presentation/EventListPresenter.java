package nz.co.sush.simplelistdetail.presentation;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import nz.co.sush.simplelistdetail.di.PerActivity;
import nz.co.sush.simplelistdetail.network.ApiAdapter;
import nz.co.sush.simplelistdetail.view.EventListView;
import nz.co.sush.simplelistdetail.view.IView;

/**
 * Created by tomtang on 2/11/15.
 */
@PerActivity
public class EventListPresenter implements Presenter {

    private ApiAdapter mApiAdapter;
    private EventListView mEventListView;
    private final CompositeDisposable disposables = new CompositeDisposable();


    @Inject
    public EventListPresenter(ApiAdapter apiAdapter) {
        mApiAdapter = apiAdapter;
    }

    public void loadEvents() {
        mEventListView.showLoading();
        disposables.add(mApiAdapter.getEventList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(events -> {
                    mEventListView.hideLoading();
                    mEventListView.renderEventList(events);
                }, throwable -> {
                    mEventListView.hideLoading();
                    mEventListView.showRetry();
                }));
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
        disposables.clear();
    }

}
