package hiquanta.rxjava.operators.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * 不发射任何数据，只发射Observable的终止通知
 * 
 * @author hiquanta
 *
 */
public class IgnoreElements {
	public static void main(String[] args) {
		Observable.just(1, 2, 3).ignoreElements()
				.subscribe(new Subscriber<Integer>() {
					@Override
					public void onNext(Integer item) {
						System.out.println("Next: " + item);
					}

					@Override
					public void onError(Throwable error) {
						System.err.println("Error: " + error.getMessage());
					}

					@Override
					public void onCompleted() {
						System.out.println("Sequence complete.");
					}
				});
	}
}
