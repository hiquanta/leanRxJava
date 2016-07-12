package hiquanta.rxjava.operators.condition;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * ���ڶ���Observable������һ�����ݻ�����ֹʱ������ԭʼObservable������κ�����
 * @author hiquanta
 *
 */
public class TakeUntil {
	public static void main(String[] args) {
		Observable.interval(1, TimeUnit.SECONDS).takeUntil(Observable.timer(10, TimeUnit.SECONDS))
		.subscribe(new Action1<Long>() {

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
