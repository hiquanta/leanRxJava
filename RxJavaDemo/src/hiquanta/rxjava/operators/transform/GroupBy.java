package hiquanta.rxjava.operators.transform;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * ��һ��Observable�ֲ�ΪһЩObservables���ϣ������е�ÿһ������ԭʼObservable��һ��������
 * http://blog.csdn.net/Job_Hesc/article/details/46495281
 * @author hiquanta
 *
 */
public class GroupBy {
		public static void main(String[] args) {
			Observable.interval(1, TimeUnit.SECONDS).take(10).groupBy(new Func1<Long, Long>() {

				@Override
				public Long call(Long t) {
					//����keyΪ0,1,2��Ϊ3��
					return t % 3;
				}
			}).subscribe(new Action1<GroupedObservable<Long, Long>>() {

				@Override
				public void call(GroupedObservable<Long, Long> result) {
					result.subscribe(new Action1<Long>() {

						@Override
						public void call(Long t) {
							System.out.println("key:" + result.getKey() +", value:" + t);
							
						}
					});
				}
			});
			  try {
					Thread.sleep(Integer.MAX_VALUE);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
		}
}
