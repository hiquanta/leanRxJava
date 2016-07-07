package hiquanta.rxjava.operators.create;

import rx.Observable;
import rx.Subscriber;
/**
 * 使用一个函数从头开始创建一个Observable
 * @author hiquanta
 *
 */
public class Create {
	
		public static void main(String[] args) {
			Observable.create(new Observable.OnSubscribe<Integer>() {

				@Override
				public void call(Subscriber<? super Integer> t) {
					 try {
				            if (!t.isUnsubscribed()) {
				                for (int i = 1; i < 5; i++) {
				                    t.onNext(i);
				                }
				                t.onCompleted();
				            }
				        } catch (Exception e) {
				            t.onError(e);
				        }
					
				}
			}).subscribe(new Subscriber<Integer>() {

				@Override
				public void onCompleted() {
					 System.out.println("Sequence complete.");
				}

				@Override
				public void onError(Throwable e) {
					 System.err.println("Error: " + e.getMessage());
				}

				@Override
				public void onNext(Integer t) {
					System.out.println("Next: " + t);
				}
			});
		}

}
