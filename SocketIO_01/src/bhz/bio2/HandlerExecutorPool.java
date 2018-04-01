package bhz.bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerExecutorPool {

	private ExecutorService executor;
	
	public HandlerExecutorPool(int maxPoolSize, int queueSize){
		this.executor = new ThreadPoolExecutor(
				Runtime.getRuntime().availableProcessors(), //corePoolSize 核心线程数
				maxPoolSize,    //最大线程数 maximumPoolSize
				120L,   //线程空闲时存活多少时间
				TimeUnit.SECONDS,//秒
				new ArrayBlockingQueue<Runnable>(queueSize));  //指定一种队列 （有界队列）
	}
	
	public void execute(Runnable task){
		this.executor.execute(task);
	}
	
	
	
}
