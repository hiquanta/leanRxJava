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
	//һ�ζ���2��
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
			//һ��ȫ������  
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
		      System.out.println("ÿ���޳�1�� ");
		    //ÿ���޳�1��  
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
		      System.out.println("skip==count��ʱ�򣬿����Ϊͬһ������һ�ξ������count��Ԫ��");
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
		                   subscriber.onNext("��Ϣ" + System.currentTimeMillis());  
		                   try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}//ÿ��2s������Ϣ  
		               }  
		  
		           }  
		       }).subscribeOn(Schedulers.io()).  
		               buffer(3, TimeUnit.SECONDS).//ÿ��3�� ȡ����Ϣ  
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
