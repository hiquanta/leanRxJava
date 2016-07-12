package hiquanta.rxjava.operators.helper;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * 将一个发射数据的Observable转换为发射那些数据发射时间间隔的Observable
 * 
 * @author hiquanta
 *
 */
public class TimeInterval {
	public static void main(String[] args) {
		Observable
				.create(new Observable.OnSubscribe<Integer>() {
					@Override
					public void call(Subscriber<? super Integer> subscriber) {
						for (int i = 0; i <= 3; i++) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							subscriber.onNext(i);
						}
						subscriber.onCompleted();
					}
				})
				
				.subscribe(
						i -> System.out.println(i+ ":"
								+ System.currentTimeMillis()));
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
