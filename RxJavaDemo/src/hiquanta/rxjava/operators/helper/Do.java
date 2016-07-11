package hiquanta.rxjava.operators.helper;

import rx.Notification;
import rx.Observable;
import rx.functions.Action1;

/**
 * 注册一个动作作为原始Observable生命周期事件的一种占位符
 * http://blog.chinaunix.net/uid-20771867-id-5206187.html
 * @author hiquanta
 *
 */
public class Do {
	public static void main(String[] args) {
		Observable.just(1,2,3,4).doOnEach(new Action1<Notification<? super Integer>>() {
			
			@Override
			public void call(Notification<? super Integer> t) {
				System.out.println("doOnEach"+(Integer)t.getValue());
			}
		}).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println("OnNext"+t);
			}
		});
	}
}
