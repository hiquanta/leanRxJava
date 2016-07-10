package hiquanta.rxjava.operators.transform;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * FlatMap��һ���������ݵ�Observable�任Ϊ���Observables��Ȼ�����Ƿ�������ݺϲ���Ž�һ��������Observable
 * http://blog.csdn.net/new_abc/article/details/48025513
 * http://www.jianshu.com/p/6d16805537ef
 * @author hiquanta
 *
 */
public class FlatMap {
	public static void main(String[] args) {
		Observable.just("��","С")
			.flatMap(new Func1<String, Observable<String>>() {

				@Override
				public Observable<String> call(String t) {
					return Observable.just(t+"sb");
				}
			}).subscribe(new Action1<String>() {

				@Override
				public void call(String t) {
					System.out.println(t);
				}
			});
	}
}
