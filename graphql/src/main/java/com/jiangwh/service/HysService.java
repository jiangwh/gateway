package com.jiangwh.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class HysService {
	public static void main(String[] args) throws InterruptedException {
		HystrixCommandGroupKey key = HystrixCommandGroupKey.Factory.asKey("cmd");
		HystrixCommand.Setter setter = HystrixCommand.Setter.withGroupKey(key);
		/////////////////////////////////////////
		HystrixCommandProperties.Setter proSetter = HystrixCommandProperties.defaultSetter();
		proSetter.withCircuitBreakerEnabled(true);
		proSetter.withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE);
		proSetter.withExecutionTimeoutEnabled(true);
		proSetter.withExecutionIsolationSemaphoreMaxConcurrentRequests(2);
		proSetter.withExecutionIsolationThreadInterruptOnTimeout(true);
		proSetter.withExecutionTimeoutInMilliseconds(5 * 1000);
		setter.andCommandPropertiesDefaults(proSetter);

		/////////////////////////////////////////
		HystrixThreadPoolProperties.Setter threadSetter = HystrixThreadPoolProperties.defaultSetter();

		setter.andThreadPoolPropertiesDefaults(threadSetter);

		HystrixCommand<String> hystrixCommand = new HystrixCommand<String>(setter) {
			@Override
			protected String run() throws Exception {
				return "finish";
			}

			@Override
			protected String getFallback() {
				return "fallback";
			}
		};

		String res = hystrixCommand.execute();
		System.out.println(res);

	}
}
