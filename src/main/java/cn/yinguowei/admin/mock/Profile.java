package cn.yinguowei.admin.mock;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yinguowei@gmail.com 2018/3/16.
 */
public class Profile {


    public static final BasicGood[] BASIC_GOODS = {
            new BasicGood(
                    "1234561",
                    "矿泉水 550ml",
                    "12421432143214321",
                    "2.00",
                    "1",
                    "2.00"
            ),
            new BasicGood(
                    "1234562",
                    "凉茶 300ml",
                    "12421432143214322",
                    "3.00",
                    "2",
                    "6.00"
            ),
            new BasicGood(
                    "1234563",
                    "好吃的薯片",
                    "12421432143214323",
                    "7.00",
                    "4",
                    "28.00"
            ),
            new BasicGood(
                    "1234564",
                    "特别好吃的蛋卷",
                    "12421432143214324",
                    "8.50",
                    "3",
                    "25.50"
            )
    };

    public static final BasicProgress[] BASIC_PROGRESSES = {
            new BasicProgress(
                    "1",
                    "2017-10-01 14:10",
                    "联系客户",
                    "processing",
                    "取货员 ID1234",
                    "5mins"),
            new BasicProgress(
                    "2",
                    "2017-10-01 14:05",
                    "取货员出发",
                    "success",
                    "取货员 ID1234",
                    "1h"),
            new BasicProgress(
                    "3",
                    "2017-10-01 13:05",
                    "取货员接单",
                    "success",
                    "取货员 ID1234",
                    "5mins"),
            new BasicProgress(
                    "4",
                    "2017-10-01 13:00",
                    "申请审批通过",
                    "success",
                    "系统",
                    "1h"),
            new BasicProgress(
                    "5",
                    "2017-10-01 12:00",
                    "发起退货申请",
                    "success",
                    "用户",
                    "5mins")
    };

    public static final Object[] ProfileBasicData = {
            BASIC_GOODS, BASIC_PROGRESSES
    };

    public static final AdvancedOperation[] ADVANCED_OPERATIONS_1 = {
            new AdvancedOperation(
                    "op1",
                    "订购关系生效",
                    "曲丽丽",
                    "agree",
                    "2017-10-03  19:23:12",
                    "-"),
            new AdvancedOperation(
                    "op2",
                    "财务复审",
                    "付小小",
                    "reject",
                    "2017-10-03  19:23:12",
                    "不通过原因"),
            new AdvancedOperation(
                    "op3",
                    "部门初审",
                    "周毛毛",
                    "agree",
                    "2017-10-03  19:23:12",
                    "-"),
            new AdvancedOperation(
                    "op4",
                    "提交订单",
                    "林东东",
                    "agree",
                    "2017-10-03  19:23:12",
                    "很棒"),
            new AdvancedOperation(
                    "op5",
                    "创建订单",
                    "汗牙牙",
                    "agree",
                    "2017-10-03  19:23:12",
                    "-")
    };
    public static final AdvancedOperation[] ADVANCED_OPERATIONS_2 = {
            new AdvancedOperation(
                    "op1",
                    "订购关系生效",
                    "曲丽丽",
                    "agree",
                    "2017-10-03  19:23:12",
                    "-"
            )
    };
    public static final AdvancedOperation[] ADVANCED_OPERATIONS_3 = {
            new AdvancedOperation(
                    "op1",
                    "创建订单",
                    "汗牙牙",
                    "agree",
                    "2017-10-03  19:23:12",
                    "-"
            )
    };

    public static final Object[] ProfileAdvancedData = {
            ADVANCED_OPERATIONS_1,ADVANCED_OPERATIONS_2,ADVANCED_OPERATIONS_3
    };

}

@Data
@AllArgsConstructor
class BasicGood {

    String id;
    String name;
    String barcode;
    String price;
    String num;
    String amount;
}

@Data
@AllArgsConstructor
class BasicProgress {
    String key;
    String time;
    String rate;
    String status;
    String operator;
    String cost;
}

@Data
@AllArgsConstructor
class AdvancedOperation {
    String key;
    String type;
    String name;
    String status;
    String updatedAt;
    String memo;
}
/**
 * const advancedOperation1 = [
 * {
 * },
 * ];
 * <p>
 * export const getProfileBasicData = {
 * basicGoods,
 * basicProgress,
 * };
 * <p>
 * export const getProfileAdvancedData = {
 * advancedOperation1,
 * advancedOperation2,
 * advancedOperation3,
 * };
 * <p>
 * export default {
 * getProfileBasicData,
 * getProfileAdvancedData,
 * };
 */