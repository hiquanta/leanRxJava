package hiquanta.rxjava.operators.combine;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * 当两个Observables中的任何一个发射了数据时，使用一个函数结合每个Observable发射的最近数据项，并且基于这个函数的结果发射数据。
 * 
 * @author hiquanta
 *
 */
public class CombineLatest {
	public static void main(String[] args) {
		// 产生0,5,10,15,20数列
		Observable<Long> observable1 = Observable
				.interval(0, 1000, TimeUnit.MILLISECONDS)
				.map(new Func1<Long, Long>() {
					@Override
					public Long call(Long aLong) {
						return aLong * 5;
					}
				}).take(5);

		// 产生0,10,20,30,40数列
		Observable<Long> observable2 = Observable
				.interval(500, 1000, TimeUnit.MILLISECONDS)
				.map(new Func1<Long, Long>() {
					@Override
					public Long call(Long aLong) {
						return aLong * 10;
					}
				}).take(5);

		Observable.combineLatest(observable1, observable2,
				new Func2<Long, Long, Long>() {
					@Override
					public Long call(Long aLong, Long aLong2) {
						return aLong + aLong2;
					}
				}).subscribe(new Subscriber<Long>() {
			@Override
			public void onCompleted() {
				System.out.println("Sequence complete.");
			}

			@Override
			public void onError(Throwable e) {
				System.err.println("Error: " + e.getMessage());
			}

			@Override
			public void onNext(Long aLong) {
				System.out.println("Next: " + aLong);
			}
		});
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
