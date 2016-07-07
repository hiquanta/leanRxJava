package hiquanta.rxjava.operators.transform;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * ��Observable�����ÿһ������Ӧ��һ��������ִ�б任����
 * @author hiquanta
 *
 */
public class Map {
	public static void main(String[] args) {
		Observable<String> observable=Observable.just("С");
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
