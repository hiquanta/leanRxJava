package hiquanta.rxjava.operators.condition;

import rx.Observable;
import rx.functions.Action1;

/**
 * �ж�һ��Observable�Ƿ���һ���ض���ֵ
 * @author hiquanta
 *
 */
public class Contains {
	public static void main(String[] args) {
		Observable.just("��","С","dfa","asdf","asdfasdf").contains("С")
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
