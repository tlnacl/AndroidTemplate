package nz.co.sush.simplelistdetail;

import org.junit.Test;

import java.util.Arrays;

import rx.functions.Action1;
import rx.observers.TestSubscriber;
import rx.subjects.AsyncSubject;

import static org.junit.Assert.assertTrue;

/**
 * Created by tom.t on 5/07/16.
 */
public class AsyncSubjectExample {
    @Test
    public void exampleLastValue() {
        AsyncSubject<Integer> s = AsyncSubject.create();
//        s.subscribe(new DefaultSubscriber<Integer>() {
//            @Override
//            public void onNext(Integer v) {
//                System.out.println(v);
//            }
//        });
        s.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer v) {
                System.out.println(v);
            }
        });
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.onCompleted();

        // 2
    }

    @Test
    public void exampleNoCompletion() {
        AsyncSubject<Integer> s = AsyncSubject.create();
        s.onNext(0);
        s.subscribe(new DefaultSubscriber<Integer>() {
            @Override
            public void onNext(Integer v) {
                System.out.println(v);
            }
        });
//        s.subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer v) {
//                System.out.println(v);
//            }
//        });
        s.onNext(1);
        s.onNext(2);
    }

    //
    // Tests
    //

    @Test
    public void testLastValue() {
        TestSubscriber<Integer> tester = new TestSubscriber<>();

        AsyncSubject<Integer> s = AsyncSubject.create();
        s.subscribe(tester);
        s.onNext(0);
        s.onNext(1);
        s.onNext(3);
        s.onCompleted();

        tester.assertReceivedOnNext(Arrays.asList(3));
        tester.assertTerminalEvent();
        tester.assertNoErrors();
    }

    @Test
    public void testNoCompletion() {
        TestSubscriber<Integer> tester = new TestSubscriber<>();

        AsyncSubject<Integer> s = AsyncSubject.create();
        s.subscribe(tester);
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);

        tester.assertReceivedOnNext(Arrays.<Integer>asList());
        assertTrue(tester.getOnCompletedEvents().size() == 0);
        tester.assertNoErrors();
    }
}
