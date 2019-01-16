package com.lemuria.gonoobgo.sentinel.dubbo.provider;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.Collections;

public class ProviderRuleLoader {

    private static final String RES_KEY = "com.lemuria.gonoobgo.dubbo.provider.TestServiceImpl:tsTest2(java.lang.String, java.lang.Object)";
    private static final String INTERFACE_RES_KEY = "com.lemuria.gonoobgo.dubbo.TestService";

    private static void initFlowRule() {
        FlowRule flowRule = new FlowRule();
        flowRule.setResource(RES_KEY);
        flowRule.setCount(100);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setLimitApp("default");
        FlowRuleManager.loadRules(Collections.singletonList(flowRule));
    }
}
