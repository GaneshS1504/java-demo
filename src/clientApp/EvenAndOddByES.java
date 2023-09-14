package clientApp;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenAndOddByES {
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		IntStream.rangeClosed(1, 10)
			.forEach(num -> {
				CompletableFuture<Integer> cf1 = CompletableFuture.completedFuture(num)
						.thenApplyAsync(n1->{
							if(n1%2!=0) {
								System.out.println("Thread name:"+Thread.currentThread().getName()+", value:"+n1);
							}
							return n1;
						}, es);
				
				cf1.join();
				
				CompletableFuture<Integer> cf2 = CompletableFuture.completedFuture(num)
						.thenApplyAsync(n1->{
							if(n1%2== 0) {
								System.out.println("Thread name:"+Thread.currentThread().getName()+", value:"+n1);
							}
							return n1;
						}, es);
				
				cf2.join();
			});
		
		es.shutdown();
	}
}
