package hiquanta.rxjava.operators.combine;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 合并多个Observables的发射物
 * 
 * @author hiquanta
 *
 */
public class Merge {
	public static void main(String[] args) {
		// 产生0,5,10,15,20数列
		Observable<Long> observable1 = Observable.timer(0, 1000,
				TimeUnit.MILLISECONDS).map(new Func1<Long, Long>() {
			@Override
			public Long call(Long aLong) {
				return aLong * 5;
			}
		});

		// 产生0,10,20,30,40数列
		Observable<Long> observable2 = Observable.timer(500, 10000,
				TimeUnit.MILLISECONDS).map(new Func1<Long, Long>() {
			@Override
			public Long call(Long aLong) {
				return aLong * 10;
			}
		});

		Observable.merge(observable1, observable2).subscribe(
				new Subscriber<Long>() {
					@Override
					public void onNext(Long item) {
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
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
