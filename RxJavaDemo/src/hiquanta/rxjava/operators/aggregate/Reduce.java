package hiquanta.rxjava.operators.aggregate;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * ��˳���Observable�����ÿ������Ӧ��һ���������������յ�ֵ
 * @author hiquanta
 *
 */
public class Reduce {
	public static void main(String[] args) {
		Observable.just(1,2,3,9).reduce(new Func2<Integer, Integer, Integer>() {
			
			@Override
			public Integer call(Integer t1, Integer t2) {
				// TODO Auto-generated method stub
				return t1+t2;
			}
		}).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t);
				
			}
		});
	}
}
