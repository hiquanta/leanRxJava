package hiquanta.rxjava.operators.transform;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * ���ڽ�����ԭʼObservable�����ݷֽ�Ϊһ��Observable���ڣ�������Щ���ڣ�������ÿ�η���һ������
 * @author hiquanta
 *
 */
public class Window {
	public static void main(String[] args) {
		Observable.interval(1, TimeUnit.SECONDS).take(12)
			.window(3,TimeUnit.SECONDS)
			.subscribe(new Action1<Observable<Long>>() {

				@Override
				public void call(Observable<Long> t) {
				    System.out.println("subdivide begin......");
                    t.subscribe(new Action1<Long>() {
                        @Override
                        public void call(Long aLong) {
                            System.out.println("Next:" + aLong);
                        }
                    });
				}
			});
		  try {
				Thread.sleep(Integer.MAX_VALUE);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}
}
