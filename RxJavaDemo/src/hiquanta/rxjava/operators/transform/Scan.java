package hiquanta.rxjava.operators.transform;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * �����ض��������е�ÿһ��Ӧ��һ��������Ȼ������������
 * @author hiquanta
 *
 */
public class Scan {
	public static void main(String[] args) {
		Observable.just(1,2,3,4,5).scan(new Func2<Integer, Integer, Integer>() {
			
			@Override
			public Integer call(Integer t1, Integer t2) {
				// TODO Auto-generated method stub
				return t1+t2;
			}
		}).subscribe(new Subscriber<Integer>() {
	        @Override
	        public void onNext(Integer item) {
	            System.out.println("Next: " + item);
	        }

	        @Override
	        public void onError(Throwable error) {
	            System.err.println("Error: " + error.getMessage());
	        }

	        @Override
	        public void onCompleted() {
	            System.out.println("Sequence complete.");
	        }
	    });
	}
	
}
