package com.purchase;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.purchase.excel.strategy.StrategyDemandInventoryItemExport;

import java.util.*;

public class TestClass {

    public static void main(String[] args) {
        String template = "D:\\战略审批单模板.xlsx";

        //创建workBook
        ExcelWriter workBook = EasyExcel.write("D:\\Excel-综合填充.xlsx").withTemplate(template).build();

        //创建Sheet
        WriteSheet sheet = EasyExcel.writerSheet().build();
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();

        //准备单组和数据
        Map<String,String> map = new HashMap<>();
        map.put("demandName", "2023/05战略采购需求清单");
        map.put("demandName1", "2023/05战略采购需求清单");

        List<StrategyDemandInventoryItemExport> list = init();
        List<StepData> process = initProcess();
        workBook.fill(list, fillConfig, sheet);
       // workBook.fill(new FillWrapper("data1", list), fillConfig, sheet);

        workBook.fill(map, sheet);


        //workBook.fill(new FillWrapper("data2", process), sheet);
        workBook.finish();
    }

    private static List<StrategyDemandInventoryItemExport> init() {
        List<StrategyDemandInventoryItemExport> result = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            StrategyDemandInventoryItemExport item = new StrategyDemandInventoryItemExport();
            item.setId(i);
            item.setMaterialCode("M30*200-" + i);
            item.setMaterialType("物料类别" + i);
            result.add(item);
        }
        return result;
    }
    private static List<StepData> initProcess() {
        List<StepData> result = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            StepData item = new StepData();
            item.setHandlerName("处理人" + i);
            item.setStepDesc("审批节点" + i);
            item.setHandleTime(new Date());
            item.setHandleOpinion("审批意见" + i);
            result.add(item);
        }
        return result;
    }
}
