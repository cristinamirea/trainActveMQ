package com.train.test;

import com.train.SampleAmqApplication;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

@SpringBootTest(classes = SampleAmqApplication.class)
public class SampleAmqApplicationTests {

    @Autowired
    private CamelContext camelContext;

    @Ignore("Requires a running activemq broker")
    public void shouldProduceMessages() throws Exception {
        NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();

        assertTrue(notify.matches(10, TimeUnit.SECONDS));
    }
}