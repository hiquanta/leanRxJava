package hiquanta.rxjava.operators.helper;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Materialize将数据项和事件通知都当做数据项发射，Dematerialize刚好相反。
 * http://blog.chinaunix.net/uid-20771867-id-5206187.html
 * @author hiquanta
 *
 */
public class Materialize_Dematerialize {
		public static void main(String[] args) {
			
			Observable.just(1, 2, 3).materialize().subscribe(i->System.out.println(i.getValue()));
			System.out.println("======================================");
			
		}
		
}
