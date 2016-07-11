package hiquanta.rxjava.operators.combine;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * 将一个发射多个Observables的Observable转换成另一个单独的Observable，后者发射那些Observables最近发射的数据项
 * 
 * @author hiquanta
 *
 */
public class Switch {
	public static void main(String[] args) {
		// 每隔500毫秒产生一个observable
		Observable<Observable<Long>> observable = Observable
				.timer(0, 20, TimeUnit.MILLISECONDS)
				.map(new Func1<Long, Observable<Long>>() {
					@Override
					public Observable<Long> call(Long aLong) {
						// 每隔200毫秒产生一组数据（0,10,20,30,40)
						return Observable.timer(0, 2000, TimeUnit.MILLISECONDS)
								.map(new Func1<Long, Long>() {
									@Override
									public Long call(Long aLong) {
										return aLong * 10;
									}
								}).take(5);
					}
				}).take(2);

		Observable.switchOnNext(observable).subscribe(new Subscriber<Long>() {
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
				System.out.println("Next:" + aLong);
			}
		});
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
