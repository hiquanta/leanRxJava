package hiquanta.rxjava.operators.condition;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * ����Observable��������ݣ�ֱ��һ��ָ��������������
 * @author hiquanta
 *
 */
public class SkipWhile {
	public static void main(String[] args) {
		Observable.interval(1, TimeUnit.SECONDS).skipWhile(new Func1<Long, Boolean>() {

			@Override
			public Boolean call(Long t) {
				// TODO Auto-generated method stub
				return t<6;
			}
		}).subscribe(new Action1<Long>() {

			@Override
			public void call(Long t) {
				System.out.println(t);
				
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
