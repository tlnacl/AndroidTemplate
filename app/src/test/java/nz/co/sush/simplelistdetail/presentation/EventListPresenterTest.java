package nz.co.sush.simplelistdetail.presentation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.reactivex.Single;
import nz.co.sush.simplelistdetail.RxSchedulersOverrideRule;
import nz.co.sush.simplelistdetail.network.ApiAdapter;
import nz.co.sush.simplelistdetail.network.model.Actor;
import nz.co.sush.simplelistdetail.network.model.Event;
import nz.co.sush.simplelistdetail.network.model.EventResponse;
import nz.co.sush.simplelistdetail.view.EventListView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tlnacl on 29/11/16.
 */

public class EventListPresenterTest {
	private EventListView mockView;
	private EventListPresenter presenter;
	private ApiAdapter apiAdapter;

	@Rule
	public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();

	@Before
	public void setup() {
		mockView = mock(EventListView.class);
		apiAdapter = mock(ApiAdapter.class);
		presenter = new EventListPresenter(apiAdapter);
		presenter.setView(mockView);
	}

//	@After
//	public void tearDown() {
//		presenter.destroy();
//	}

	@Test
	public void testLoadEvent(){
		EventResponse eventResponse = EventResponse.create(Event.create(1,"Test",true, Actor.create(1,"test","testurl","testavatarurl")));
		when(apiAdapter.getEventList()).thenReturn(Single.just(eventResponse));

		presenter.loadEvents();
		verify(mockView).hideLoading();
		verify(mockView).renderEventList(eventResponse);
	}
}
