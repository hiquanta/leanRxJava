package hiquanta.rxjava.operators.aggregate;

	

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 *  Collect操作符类似于Reduce，但是其目的不同，collect用来将源Observable发射的数据给收集到一个数据结构里面，需要使用两个参数：
    1.一个产生收集数据结构的函数。
    2.一个接收第一个函数产生的数据结构和源Observable发射的数据作为参数的函数。
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
