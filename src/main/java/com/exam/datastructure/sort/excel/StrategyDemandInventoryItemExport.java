package com.exam.datastructure.sort.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 采购需求条目Excel导入类型
 * @author chenlin
 * @date 2023/3/6 11:59
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@ColumnWidth(12)
@HeadFontStyle(fontHeightInPoints = 12)
@ContentFontStyle(fontHeightInPoints = 12)
public class StrategyDemandInventoryItemExport {

    /**
     * 清单项id
     */
    @ExcelProperty(value = "序号")
    private Integer id;

    /**
     * 物料编码
     */
    @ExcelProperty(value = "物料编码")
    private String materialCode;

    /**
     * 物料类别
     */
    @ExcelProperty(value = "物料类别")
    private String materialType;

    /**
     * 物料说明
     */
    @ExcelProperty(value = "物料说明")
    private String materialDescription;

    /**
     * 项目名称
     */
    @ExcelProperty(value = "项目名称")
    private String projectName;

    /**
     * 施工单元
     */
    @ExcelProperty(value = "施工单元")
    private String constructionUnit;

    /**
     * 需求时间
     */
    @ExcelProperty(value = "需求时间")
    @DateTimeFormat("yyyy-MM-dd")
    private Date demandTime;

    /**
     * 需求数量
     */
    @ExcelProperty(value = "需求数量")
    private BigDecimal demandCount;

    /**
     * 已申购数量
     */
    @ExcelProperty(value = "已申购数量")
    private BigDecimal subscribeCount;

    /**
     * 单位
     */
    @ExcelProperty(value = "单位")
    private String unit;

    /**
     * 无项目库存总量
     */
    @ExcelProperty(value = "公共库存")
    private BigDecimal stockWithoutProjectCount;

    /**
     * 可用库存
     */
    @ExcelProperty(value = "在库公共库存")
    private BigDecimal stockAvailableCount;

    /**
     * 无项目在途订单
     */
    @ExcelProperty(value = "未入库公共库存")
    private BigDecimal orderWithoutProjectCount;

    /**
     * 特殊钢板尺寸
     */
    @ExcelProperty(value = "特殊钢板尺寸")
    private String specialSteelPlateSize;

    /**
     * 需求公司
     */
    @ExcelProperty(value = "需求公司")
    private String demandCompany;

    /**
     * 到货地址
     */
    @ExcelProperty(value = "到货地址")
    private String arrivalAddress;

    /**
     * 指定钢厂
     */
    @ExcelProperty(value = "指定钢厂")
    private String designatedSteelPlant;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remarks;
}
