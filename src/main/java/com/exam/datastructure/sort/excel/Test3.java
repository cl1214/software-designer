package com.exam.datastructure.sort.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import org.apache.poi.ss.util.CellRangeAddress;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    /**
     *@param templateFilePath 模板文件路径
     *@param filePath 导出文件路径
     */
    public static void test3(String templateFilePath, String filePath) {
        Map<String, List<ExcelDto>> map = new HashMap<>();
        map.put("a", getListDtos());
        Map<String, Object> testMap = new HashMap<>();
        testMap.put("date", LocalDateTime.now());
        testMap.put("title", "测试");
        // 添加合并单元格地址
        List<CellRangeAddress> list = new ArrayList<>();
        //new CellRangeAddress(开始行，结束行，开始列，结束列)
        list.add(new CellRangeAddress(1, 1, 2, 3));
        list.add(new CellRangeAddress(1, 1, 5, 6));
        // 创建ExcelWriterBuilder
        ExcelWriterBuilder excelWriterBuilder = EasyExcel.write(filePath)
                .withTemplate(templateFilePath);
        ExcelWriter excelWriter = excelWriterBuilder.build();
        // 创建writeSheet，并注册合并单元格handler
        WriteSheet writeSheet = EasyExcel.writerSheet()
                .registerWriteHandler(new MyHandler(0,list))
                .build();
        WriteSheet writeSheet1 = EasyExcel.writerSheet().build();
        // 填写配置，forceNewRow true表示自动创建一行，后面的数据后移
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        //填写数据
        excelWriter.fill(new FillWrapper("a", getListDtos()), fillConfig, writeSheet);
        excelWriter.fill(testMap,writeSheet1);
        // 关闭填写
        excelWriter.finish();
    }

    public static List<ExcelDto> getListDtos() {
        List<ExcelDto> list = new ArrayList<>();
        int i = 0;
        while (i < 1) {
            list.add(new ExcelDto("张三", 2, 2, "打工仔", "打工仔"));
            list.add(new ExcelDto("李四1", 2, 2, "打工仔", "打工仔"));
            list.add(new ExcelDto("李四2", 2, 2, "打工仔", "打工仔"));
            list.add(new ExcelDto("李四3", 2, 2, "打工仔", "打工仔"));
            list.add(new ExcelDto("李四4", 2, 2, "打工仔", "打工仔"));
            list.add(new ExcelDto("李四5", 2, 2, "打工仔", "打工仔"));
            i++;
        }
        return list;
    }
}
