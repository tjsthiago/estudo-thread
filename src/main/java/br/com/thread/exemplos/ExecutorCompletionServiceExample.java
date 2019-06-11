package br.com.thread.exemplos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.thread.model.ExemploCallable;

public class ExecutorCompletionServiceExample {

public static void main(String[] args) {
		
		System.out.println("stard: " + new Date());	
	
		int initialCapacity = 1000;
		int poolSize = 10;
		
		List<ExemploCallable> tarefas = new ArrayList<>(initialCapacity);
		ExecutorService threadPool = Executors.newFixedThreadPool(poolSize);
		ExecutorCompletionService<ExemploCallable> completionService = new ExecutorCompletionService<ExemploCallable>(threadPool);
		
		for (int i = 0; i < initialCapacity; i++) {
			tarefas.add(new ExemploCallable());
		}
		
        for (ExemploCallable tarefa : tarefas) {
            completionService.submit(tarefa);
        }
       
         
        for (int i = 0; i < initialCapacity; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println("end: " + new Date());
  
        threadPool.shutdown();
        
    }
	
}
