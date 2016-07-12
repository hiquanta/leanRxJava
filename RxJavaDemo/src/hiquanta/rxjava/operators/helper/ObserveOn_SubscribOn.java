package hiquanta.rxjava.operators.helper;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 *  ObserveOn:指定一个观察者在哪个调度器上观察这个Observable 
 *  SubscribOn:用来指定Observable在哪个线程上运行
 * @author hiquanta
 *
 */
public class ObserveOn_SubscribOn {
		public static void main(String[] args) {
			Observable.just(1, 2, 3).observeOn(Schedulers.newThread()).
			subscribeOn(Schedulers.newThread()).subscribe(new Action1<Integer>() {

				@Override
				public void call(Integer t) {
					System.out.println(t);
					
				}
			});
			 try {
					Thread.sleep(Integer.MAX_VALUE);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
		}
}
