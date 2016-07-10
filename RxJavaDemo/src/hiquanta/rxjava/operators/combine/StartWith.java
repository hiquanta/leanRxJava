package hiquanta.rxjava.operators.combine;

import rx.Observable;
import rx.Subscriber;

/**
 * 在数据序列的开头插入一条指定的项
 * http://blog.csdn.net/job_hesc/article/details/46612015
 * @author hiquanta
 *
 */
public class StartWith {
	public static void main(String[] args) {
		Observable.just(10,20,30).startWith(2, 3, 4).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error: " + e.getMessage());
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("Next:" + value);
            }
        });
	}
}
