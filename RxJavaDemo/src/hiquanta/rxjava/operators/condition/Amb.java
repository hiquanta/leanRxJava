package hiquanta.rxjava.operators.condition;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * 给定两个或多个Observables，它只发射首先发射数据或通知的那个Observable的所有数据
 * http://blog.chinaunix.net/uid-20771867-id-5208237.html
 * @author hiquanta
 *
 */
public class Amb {
	public static void main(String[] args) {
		Observable<Integer> delay3 = Observable.just(1, 2, 3).delay(3000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay2 = Observable.just(4, 5, 6).delay(1000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay1 = Observable.just(7, 8, 9).delay(2000, TimeUnit.MILLISECONDS);
        Observable.amb(delay1, delay2, delay3).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t+"");
			}
		});
        try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
