package nz.co.sush.simplelistdetail.presentation

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import nz.co.sush.simplelistdetail.RxSchedulersOverrideRule
import nz.co.sush.simplelistdetail.network.ApiAdapter
import nz.co.sush.simplelistdetail.network.model.Actor
import nz.co.sush.simplelistdetail.network.model.Event
import nz.co.sush.simplelistdetail.network.model.EventResponse
import nz.co.sush.simplelistdetail.view.EventListView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`

/**
 * Created by tomt on 13/03/17.
 */
class EventListPresenterTestK {
    private val mockView:EventListView = mock()
    private val apiAdapter:ApiAdapter = mock()

    private lateinit var presenter:EventListPresenter

    @Rule
    var rxSchedulersOverrideRule = RxSchedulersOverrideRule()


    @Before
    fun setup(){
        presenter = EventListPresenter(apiAdapter)
        presenter.setView(mockView)
    }

    @Test
    fun testLoadEvent(){
        val eventResponse = EventResponse.create(Event.create(1, "Test", true, Actor.create(1, "test", "testurl", "testavatarurl")))
        `when`<Single<EventResponse>>(apiAdapter.eventList).thenReturn(Single.just(eventResponse))

        presenter.loadEvents()
        verify(mockView).hideLoading()
        verify(mockView).renderEventList(eventResponse)
    }

}