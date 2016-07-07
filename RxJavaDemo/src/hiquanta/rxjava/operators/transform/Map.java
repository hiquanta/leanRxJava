package hiquanta.rxjava.operators.transform;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 对Observable发射的每一项数据应用一个函数，执行变换操作
 * @author hiquanta
 *
 */
public class Map {
	public static void main(String[] args) {
		Observable<String> observable=Observable.just("小");
		observable.map(new Func1<String, String>() {

			@Override
			public String call(String t) {
				
				return t+"sb";
			}
		}).subscribe(new Action1<String>() {

			@Override
			public void call(String t) {
				System.out.println(t);
				
			}
		});
	}

}
