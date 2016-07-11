package hiquanta.rxjava.operators.combine;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * ��һ��������Observables��Observableת������һ��������Observable�����߷�����ЩObservables��������������
 * 
 * @author hiquanta
 *
 */
public class Switch {
	public static void main(String[] args) {
		// ÿ��500�������һ��observable
		Observable<Observable<Long>> observable = Observable
				.timer(0, 20, TimeUnit.MILLISECONDS)
				.map(new Func1<Long, Observable<Long>>() {
					@Override
					public Observable<Long> call(Long aLong) {
						// ÿ��200�������һ�����ݣ�0,10,20,30,40)
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
