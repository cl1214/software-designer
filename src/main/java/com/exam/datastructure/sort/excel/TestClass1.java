//package com.exam.datastructure.sort.excel;
//
//import com.deepoove.poi.XWPFTemplate;
//import com.deepoove.poi.config.Configure;
//import com.deepoove.poi.plugin.table.LoopRowTableRenderPolicy;
//
//import java.io.*;
//import java.util.*;
//
//public class TestClass1 {
//
//    public static void main(String[] args) throws IOException {
//        //创建行循环策略
//        LoopRowTableRenderPolicy rowTableRenderPolicy = new LoopRowTableRenderPolicy();
////告诉模板引擎，要在employees做行循环,绑定行循环策略
//       // Configure configure = Configure.builder().bind("subscribeItem", rowTableRenderPolicy).build();
//        Configure configure = Configure.builder()
//                .bind("subscribeItem", rowTableRenderPolicy).bind("process", rowTableRenderPolicy).build();
////创建目标文件
//
//        File sourceFile = new File("D:\\战略采购申购单模板.docx");
//
//        if (!sourceFile.exists()) {
//            sourceFile.createNewFile();
//        }
////构建数据
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("demandName", "2023/05战略采购需求清单");
//        map.put("subscribeName", "YQJF项目9G2申购单2001");
//        map.put("initiatorName", "徐可洋");
//        map.put("initiationTime", "2023-06-13 13:03");
//
//        map.put("subscribeItem", init());
//        map.put("process", initProcess());
//        OutputStream os = null;
//        try {
//            os = new FileOutputStream("D:\\Excel-综合填充.docx");
//            XWPFTemplate.compile(sourceFile, configure).render(map).writeAndClose(os);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////最终编译渲染并输出
//
//
//    }
//
//    private static List<StrategyDemandInventoryItemExport> init() {
//        List<StrategyDemandInventoryItemExport> result = new ArrayList<>();
//        for (int i = 1; i <= 5; i++) {
//            StrategyDemandInventoryItemExport item = new StrategyDemandInventoryItemExport();
//            item.setId(i);
//            item.setMaterialCode("M30*200-" + i);
//            item.setMaterialType("物料类别" + i);
//            result.add(item);
//        }
//        return result;
//    }
//    private static List<StepData> initProcess() {
//        List<StepData> result = new ArrayList<>();
//        for (int i = 1; i <= 3; i++) {
//            StepData item = new StepData();
//            item.setHandlerName("处理人" + i);
//            item.setStepDesc("审批节点" + i);
//            item.setHandleTime(new Date());
//            item.setHandleOpinion("审批意见" + i);
//            result.add(item);
//        }
//        return result;
//    }
//}
