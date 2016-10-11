package nz.co.sush.simplelistdetail;

/**
 * Created by tom.t on 26/05/16.
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {
    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(T t) {
    }
}