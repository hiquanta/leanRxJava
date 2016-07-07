package hiquanta.rxjava.operators.transform;

import hiquanta.rxjava.sample.Data;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * http://blog.csdn.net/axuanqq/article/details/50698532
 * @author hiquanta
 *
 */
public class Buffer {
	//一次订阅2个
		public static void main(String[] args) {
			  Observable.range(1,5).buffer(2).subscribe(new Observer<List<Integer>>() {  
		            @Override  
		            public void onCompleted() {  
		               System.out.println("onCompleted");
		            }  
		  
		            @Override  
		            public void onError(Throwable e) {  
		            	 System.out.println("onError");
		            }  
		  
		            @Override  
		            public void onNext(List<Integer> i) {  
		            	 System.out.println("onNext"+i);
		            }  
		        });  
			//一次全部订阅  
			  System.out.println("=================================");
		      Observable.range(1,5).buffer(5).subscribe(new Observer<List<Integer>>() {  
		    	   @Override  
		            public void onCompleted() {  
		               System.out.println("onCompleted");
		            }  
		  
		            @Override  
		            public void onError(Throwable e) {  
		            	 System.out.println("onError");
		            }  
		  
		            @Override  
		            public void onNext(List<Integer> i) {  
		            	 System.out.println("onNext"+i);
		            } 
		      });  
		      System.out.println("每次剔除1个 ");
		    //每次剔除1个  
		      Observable.range(1, 5).buffer(5, 1).subscribe(new Observer<List<Integer>>() {  
		    	  @Override  
		            public void onCompleted() {  
		               System.out.println("onCompleted");
		            }  
		  
		            @Override  
		            public void onError(Throwable e) {  
		            	 System.out.println("onError");
		            }  
		  
		            @Override  
		            public void onNext(List<Integer> i) {  
		            	 System.out.println("onNext"+i);
		            } 
		      }); 
		      System.out.println("skip==count的时候，框架认为同一操作，一次就清除了count个元素");
		      Observable.range(1, 5).buffer(5, 5).subscribe(new Observer<List<Integer>>() {  
		    	  @Override  
		            public void onCompleted() {  
		               System.out.println("onCompleted");
		            }  
		  
		            @Override  
		            public void onError(Throwable e) {  
		            	 System.out.println("onError");
		            }  
		  
		            @Override  
		            public void onNext(List<Integer> i) {  
		            	 System.out.println("onNext"+i);
		            } 
		        });  
		      System.out.println("=================================");
		      Observable.create(new Observable.OnSubscribe<String>() {  
		           @Override  
		           public void call(Subscriber<? super String> subscriber) {  
		               if (subscriber.isUnsubscribed()) return;  
		               while (true) {  
		                   subscriber.onNext("消息" + System.currentTimeMillis());  
		                   try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}//每隔2s发送消息  
		               }  
		  
		           }  
		       }).subscribeOn(Schedulers.io()).  
		               buffer(3, TimeUnit.SECONDS).//每隔3秒 取出消息  
		               subscribe(new Observer<List<String>>() {  
		           @Override  
		           public void onCompleted() {  
		           }  
		  
		           @Override  
		           public void onError(Throwable e) {  
		           }  
		  
		           @Override  
		           public void onNext(List<String> strings) {  
		        	   System.out.println("onNext"+strings.size());
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
