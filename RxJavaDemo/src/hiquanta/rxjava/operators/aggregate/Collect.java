package hiquanta.rxjava.operators.aggregate;

	

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 *  Collect������������Reduce��������Ŀ�Ĳ�ͬ��collect������ԴObservable��������ݸ��ռ���һ�����ݽṹ���棬��Ҫʹ������������
    1.һ�������ռ����ݽṹ�ĺ�����
    2.һ�����յ�һ���������������ݽṹ��ԴObservable�����������Ϊ�����ĺ�����
 * @author hiquanta
 *
 */
public class Collect {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		Observable.from(list).collect(() -> new ArrayList<>(), new Action2<List<Integer>, Integer>() {

			@Override
			public void call(List<Integer> t1, Integer t2) {
				t1.add(t2);
				
			}
		}).subscribe(new Action1<List<Integer>>() {

			@Override
			public void call(List<Integer> t) {
				System.out.println(t.toString());
				
			}

			
		});
	}
}
