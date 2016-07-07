package hiquanta.rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

public class RxJavaTest {
	public static void main(String[] args) {
		String[] str={"url1", "url2", "url3"};
//		Observable.from(str)  
//	    .subscribe(url -> System.out.println(url));  
//		query("Hello, world!")  
//	    .flatMap(urls -> Observable.from(urls))  
//	    .subscribe(url -> System.out.println(url));  
		
		
//		query("test").flatMap(new Func1<List<String>, Observable<? extends String>>() {
//
//			@Override
//			public Observable<? extends String> call(List<String> t) {
//			return	Observable.from(t);
//			}
//		}).take(3).subscribe(new Action1<String>() {
//
//			@Override
//			public void call(String t) {
//				System.out.println(t);
//				
//			}
//		});
		
//		Observable.just(str)
//		.flatMap(s->Observable.from(s))
//	    .map(s -> s+"test1")
//	    .map(new Func1<String, String>() {
//
//			@Override
//			public String call(String t) {
//				// TODO Auto-generated method stub
//				return t;
//			}
//		})
//	    .subscribe(new Subscriber<String>() {
//	        @Override
//	        public void onNext(String s) {
//	        	if(s.equals("url3test1test2"))
//					
//	        	System.out.println(s); }
//
//	        @Override
//	        public void onCompleted() { System.out.println("Completed!"); }
//
//	        @Override
//	        public void onError(Throwable e) { System.out.println("Ouch!"); }
//	    });
		Observable.timer(3,3,TimeUnit.SECONDS)
	    .subscribe(new Observer<Long>() {

	        @Override
	        public void onCompleted() {

	        }

	        @Override
	        public void onError(Throwable e) {

	        }

	        @Override
	        public void onNext(Long number) {
	        	System.out.println(number+""); 
	        }
	    });
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

	public static Observable<List<String>> query(String text) {
		List<String> list=new ArrayList<String>();
		for(int i=0;i<10;i++){
			list.add("test"+i);
			}
		
		return Observable.just(list);
	}
	public  Observable<Integer> getInt(){
	    return Observable.create(subscriber -> {
	        if(subscriber.isUnsubscribed()){
	            return;
	        }
	        System.out.println("ddd");
	        subscriber.onNext(42);
	        subscriber.onNext(42);
	        subscriber.onNext(42);
	        subscriber.onNext(42);
	        subscriber.onNext(42);
	        subscriber.onCompleted();
	    });
	
	}
}
