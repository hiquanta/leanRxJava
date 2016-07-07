package hiquanta.rxjava.operators.create;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * 创建一个按固定时间间隔发射整数序列的Observable
 * http://blog.csdn.net/pizza_lawson/article/details/45199517
 * @author hiquanta
 *
 */
public class Interval {
	public static void main(String[] args) {
		Observable<Long> observable=Observable.interval(1, TimeUnit.SECONDS);
		observable.subscribe(new Action1<Long>() {

			@Override
			public void call(Long t) {
				System.out.println("interval:"+t);
			}
		});
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
