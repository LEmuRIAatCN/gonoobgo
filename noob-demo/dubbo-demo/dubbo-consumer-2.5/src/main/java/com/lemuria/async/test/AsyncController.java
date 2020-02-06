package com.lemuria.async.test;

import com.alibaba.dubbo.remoting.exchange.support.DefaultFuture;
import com.alibaba.dubbo.rpc.RpcContext;
import com.lemuria.async.test.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.FutureRequestExecutionMetrics;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.*;

@Controller
@Slf4j
public class AsyncController {
    @Autowired
    private AsyncService async;
    @RequestMapping("/async")
    @ResponseBody
    public String async() {
        long start = System.currentTimeMillis();
        Future<String> future = RpcContext.getContext().asyncCall(() -> async.test1());
        String ss = "";
        try {
            ss = future.get(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            log.info("Interrupt");
        } catch (ExecutionException e) {
            log.info("ExecutionException");
        } catch (TimeoutException e) {
            log.info("TimeoutException");
        }
        log.info("time consume: "+(System.currentTimeMillis()-start));
        return ss;
    }
}
