package hiquanta.rxjava.operators.condition;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * ����ԭʼObservable��������ݣ�ֱ���ڶ���Observable������һ������
 * http://blog.chinaunix.net/uid-20771867-id-5208237.html
 * @author hiquanta
 *
 */
public class SkipUntil {
		public static void main(String[] args) {
			Observable.interval(1, TimeUnit.SECONDS).
				skipUntil(Observable.timer(5, TimeUnit.SECONDS))
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
