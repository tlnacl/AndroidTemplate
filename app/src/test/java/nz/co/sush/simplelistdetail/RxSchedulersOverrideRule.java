package nz.co.sush.simplelistdetail;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tomt on 13/03/17.
 */

public class RxSchedulersOverrideRule implements TestRule {

	@Override
	public Statement apply(final Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				RxAndroidPlugins.reset();
				RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());

				RxJavaPlugins.reset();
				RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
				RxJavaPlugins.setComputationSchedulerHandler(scheduler -> Schedulers.trampoline());

				base.evaluate();

				RxAndroidPlugins.reset();
				RxJavaPlugins.reset();
			}
		};
	}
}
