package com.venkat.exception;

/*
 * simple class to demo a sequence generator
 * thread safe - a thread is spun off 
 * code in the thread calls for next sequence
 * the main thread goes on to demand next.
 * mentioned in Brian Goetz's book
 * 
 */
public class SafeSequence {
 
private int nextValue;
public synchronized int getNext() {
	return nextValue++;
}
public static void main(String[] args){
	SafeSequence ss = new SafeSequence();
	
	new Thread( new Runnable(){ 
		public void run(){
			for (int i = 0 ; i < 11 ; i++){
				System.out.println("getNext from new R" + ss.getNext() ) ;
			}
		}
	}).start() ;	
	
	for (int i = 0 ; i < 11 ; i++){
		System.out.println("getNext " + ss.getNext() ) ;
	}
	

}
}