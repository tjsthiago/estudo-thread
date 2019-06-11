package br.com.thread.exemplos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import br.com.thread.model.ExemploCallable;

public class ExecutorServiceExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("stard: " + new Date());
		
		int initialCapacity = 1000;
		int poolSize = 10;
		ExecutorService threadPool = Executors.newFixedThreadPool(poolSize);
		List<ExemploCallable> tarefas = new ArrayList<>(initialCapacity);

		for (int i = 0; i < initialCapacity; i++) {
			tarefas.add(new ExemploCallable());
		}
		
		List<Future<ExemploCallable>> updatesList = threadPool.invokeAll(tarefas);
		 
		for(Future<ExemploCallable> f : updatesList) {
			System.out.println(f.get().getName());
		}
		
		System.out.println("end: " + new Date());

		threadPool.shutdown();
		
	}

}
