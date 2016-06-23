package com.awesome.omni.task;

import java.util.Date;

public class Ping implements Task {

	@Override
	public void execute() {
		System.out.println("ping");
		
	}

	@Override
	public ExecutionReport report() {
		return new ExecutionReport("1", "2", new Date(), new Date(), "ping ping ping");
	}

}
