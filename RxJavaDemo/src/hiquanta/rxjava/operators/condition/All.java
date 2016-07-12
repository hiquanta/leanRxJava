package hiquanta.rxjava.operators.condition;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 判定是否Observable发射的所有数据都满足某个条件
 * @author hiquanta
 *
 */
public class All {
	public static void main(String[] args) {
		Observable.just("大","小","dfa","asdf","asdfasdf")
		.flatMap(new Func1<String, Observable<Boolean>>() {

			@Override
			public Observable<Boolean> call(String t) {
				return Observable.just(t).all(new Func1<String, Boolean>() {

					@Override
					public Boolean call(String t) {
						System.out.println(t+"");
						return t.equals("小");
					}
				});
			}
		}).subscribe(new Action1<Boolean>() {

			@Override
			public void call(Boolean t) {
				if(t)
				System.out.println("has");
				
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
