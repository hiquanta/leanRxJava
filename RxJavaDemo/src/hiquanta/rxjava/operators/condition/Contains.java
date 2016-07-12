package hiquanta.rxjava.operators.condition;

import rx.Observable;
import rx.functions.Action1;

/**
 * 判定一个Observable是否发射一个特定的值
 * @author hiquanta
 *
 */
public class Contains {
	public static void main(String[] args) {
		Observable.just("大","小","dfa","asdf","asdfasdf").contains("小")
		.subscribe(new Action1<Boolean>() {

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
