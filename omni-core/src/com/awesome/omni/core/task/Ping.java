package com.awesome.omni.core.task;

public class Ping implements Task {

	@Override
	public void run() {
		System.out.println("piiiinggg"); 
	}

	@Override
	public String report() {
		return "finished ping";
	}

}
