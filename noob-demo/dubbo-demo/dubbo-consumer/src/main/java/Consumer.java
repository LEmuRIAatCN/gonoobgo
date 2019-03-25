/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.lemuria.gonoobgo.dubbo.TestService;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    /*private static final ExecutorService pool = Executors.newFixedThreadPool(10,
            new DefaultThreadFactory("dubbo-consumer-pool"));*/

    /**
     * To get ipv6 address to work, add
     * System.setProperty("java.net.preferIPv6Addresses", "true");
     * before running your application.
     */
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-demo-consumer.xml"});
        context.start();
        TestService testService = (TestService) context.getBean("testService"); // get remote service proxy
        //TestService testService = (TestService) context.getBean("noobService"); // get remote service proxy
        GenericService noob = (GenericService) context.getBean("genericHelloService"); // get remote service proxy
        //while (true) {
        for (; ; ) {
            // pool.submit(() -> {
            try {

                Thread.sleep(1000);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                Object result = noob.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[] {"World"});
                System.out.println("generic Results:"+result);
                System.out.println(testService.tsTest2("asdf", "hahah"));
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                //RpcContext.getContext().setAttachment(i + "", i + "lal");

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            //});
        }
        //}
    }
}
