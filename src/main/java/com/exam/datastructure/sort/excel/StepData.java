package com.purchase;

import java.util.Date;
@lombok.Data
public class StepData {
    /**
     * 流程名称
     */
    private String stepDesc;

    /**
     * 流程状态代码
     */
    private String handlerName;

    /**
     * 处理时间
     */
    private Date handleTime;

    /**
     * 处理结果编码
     */
    private String handleResult;

    /**
     * 审批意见
     */
    private String handleOpinion;
}
