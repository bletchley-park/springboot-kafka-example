package com.rd.intern.app.consts;

public interface GlobalConsts {
	
	interface CONSUMER_ORDER_SERVICE {
	String ONE  = "orderConsumerInstance1Service";
	String TWO  = "orderConsumerInstance2Service";
	}
	
	interface CONSUMER_CONFIG_SERVICE  {
		String ONE  = "consumerConfigInstance1Service";
		String TWO  = "consumerConfigInstance2Service";
	}
	
	interface CONSUMER_FACTORY_SERVICE{
		String ONE  = "consumerFactoryInstance1Service";
		String TWO  = "consumerFactoryInstance2Service";
	}
	
	interface CONSUMER_NOTIFICATION_SERVICE {
		String ORDER  = "orderConsumerNotificationService";
		String CONFIG  = "consumerConfigNotificationService";
		String FACTORY  = "orderConsumerFactoryNotificationService";
	}
	
	interface CONTAINER_FACTORY_SERVICE {
		String ONE  = "containerFactoryInstance1Service";
		String TWO  = "containerFactoryInstance2Service";
		String NOTIFICATION  = "containerFactoryNotificationService";
		
	}
}
