package br.com.thread.model;

import java.util.concurrent.Callable;

public class ExemploCallable implements Callable<ExemploCallable> {
	  
    private String name;
    private boolean valid;


	public ExemploCallable() {
		
	}

	public ExemploCallable call() throws Exception {
        Thread.sleep(1000);
        
        ExemploCallable result = new ExemploCallable();
        result.setName(Thread.currentThread().getName());
        
        return result;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}


	@Override
	public String toString() {
		return "ExemploCallable [name=" + name + ", valid=" + valid + "]";
	}
	
	
}
