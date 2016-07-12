package hiquanta.rxjava.operators.condition;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 发射Observable发射的数据，直到一个指定的条件不成立
 * http://blog.chinaunix.net/uid-20771867-id-5208237.html
 * @author hiquanta
 *
 */
public class TakeWhile {
	public static void main(String[] args) {
		Observable.interval(1, TimeUnit.SECONDS).takeWhile(new  Func1<Long, Boolean>() {

			@Override
			public Boolean call(Long t) {
				return t<5;
			}
		}).subscribe(new Action1<Long>() {

			@Override
			public void call(Long t) {
				System.out.println(t);
				
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
