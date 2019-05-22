package com.train.controller;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
//made by cristin
@Component
public class SampleAutowiredAmqRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("jms:foo")
                .to("jms:queue:bar");

        from("jms:foo")
                .to("jms:queue:bar1");

        from("timer:bar")
                .setBody(constant("Hello from Camel"))
                .to("jms:queue:foo");
    }

}

