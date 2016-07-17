package hiquanta.rxjava.operators.combine;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * �κ�ʱ��ֻҪ����һ��Observable��������ݶ����ʱ�䴰���ڣ����Observable������һ�����ݣ��ͽ������Observable���������
 * 
 * ������RxJava�е�join����
 * 
 * @author hiquanta
 *
 */
public class Join {
	public static void main(String[] args) {
		//����0,5,10,15,20����
        Observable<Long> observable1 = Observable.timer(0, 1000, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return aLong * 5;
                    }
                });

        //����0,10,20,30,40����
        Observable<Long> observable2 = Observable.timer(500, 1000, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return aLong * 10;
                    }
                });

        observable1.join(observable2, new Func1<Long, Observable<String>>() {

			@Override
			public Observable<String> call(Long t) {
				// TODO Auto-generated method stub
				return Observable.just(t.toString());
			}
           
        }, new Func1<Long, Observable<Long>>() {
            @Override
            public Observable<Long> call(Long aLong) {
                //ʹObservable�ӳ�600����ִ��
                return Observable.just(aLong).delay(600, TimeUnit.MILLISECONDS);
            }
        }, new Func2<Long, Long, String>() {
            @Override
            public String call(Long aLong, Long aLong2) {
                return aLong +":" +aLong2;
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error: " + e.getMessage());
            }

            @Override
            public void onNext(String aLong) {
                System.out.println("Next: " + aLong);
            }
        });
        try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
