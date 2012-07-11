package com.taobao.meta.test;

import org.junit.Test;

/**
 * meta���ɲ���_SubscribeWrongTopicTest
 * 
 * @author gongyangyu(gongyangyu@taobao.com)
 * 
 */

public class SubscribeWrongTopicTest extends BaseMetaTest {

	private final String topic = "meta-test";

	@Test
	public void sendConsume() throws Exception {
		createProducer();
		producer.publish(this.topic);
		// �����߱���ָ������
		createConsumer("group1");

		try {
			// ������Ϣ
			final int count = 5;
			sendMessage(count, "hello", this.topic);

			// ���Ľ�����Ϣ����֤������ȷ
			subscribe("gongyangyu", 1024*1024, 0);
		} finally {
			producer.shutdown();
			consumer.shutdown();
		}
	}
}