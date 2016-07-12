package hiquanta.rxjava.operators.helper;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * 对原始Observable的一个镜像，如果过了一个指定的时长仍没有发射数据，它会发一个错误通知
 * 
 * @author hiquanta
 *
 */
public class Timeout {
	public static void main(String[] args) {
		Observable.create(new Observable.OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> t) {
				for (int i = 0; i <= 3; i++) {
					try {
						Thread.sleep(i * 100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					t.onNext(i);
				}
			}
		}).timeout(200, TimeUnit.MILLISECONDS)
				.subscribe(new Action1<Integer>() {

					@Override
					public void call(Integer t) {
						System.out.println(t);

					}
				});

	}
}
