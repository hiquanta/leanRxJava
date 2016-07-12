package hiquanta.rxjava.operators.helper;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * ��ԭʼObservable��һ�������������һ��ָ����ʱ����û�з������ݣ����ᷢһ������֪ͨ
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
