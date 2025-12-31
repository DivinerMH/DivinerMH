/*
package cn.menghuan.common.aspect;

import cn.hutool.core.util.StrUtil;
import cn.menghuan.common.utils.R;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jeecg.common.api.CommonAPI;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.system.vo.DictModel;
import org.jeecg.common.util.CustConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

*/
/**
 * @description: 字典aop类
 * @version: 1.0
 *//*

@Aspect
@Component
@Slf4j
public class DictAspect {

    @Lazy
    @Autowired
    private CommonAPI commonApi;
    @Autowired
    public RedisTemplate redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    private static final String JAVA_UTIL_DATE = "java.util.Date";

    */
/**
     * 主切点：匹配Controller或@Dict方法
     *//*

    @Pointcut(
            "execution(public * cn.menghuan..*.*Controller.*(..)) " +
                    "|| @annotation(cn.menghuan.common.aspect.annotation.Dict)"
    )
    public void mainPointcut() {
    }

    */
/**
     * 排除的切点：匹配 Service 层方法
     *//*

    @Pointcut("execution(* cn.menghuan..*Service.*(..))")
    public void excludeService() {
    }

    */
/**
     * 最终切点：主逻辑 - 排除 Service 层方法
     *//*

    @Pointcut("mainPointcut() && !excludeService()")
    public void finalPointcut() {
    }

    */
/**
     * 环绕通知：用于统计目标方法的执行耗时，并对返回结果进行字典文本解析和注入
     * @param pjp 切入点对象，用于执行目标方法 - ProceedingJoinPoint pjp：连接点对象，可获取目标方法信息，并通过 pjp.proceed() 执行目标方法
     * @return 经过字典处理后的结果对象
     *//*

    @Around("finalPointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long requestStartTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        log.debug("获取JSON数据耗时: {}ms", System.currentTimeMillis() - requestStartTime);

        long parseStartTime = System.currentTimeMillis();
        result = this.parseDictText(result);
        log.debug("注入字典到JSON数据耗时: {}ms", System.currentTimeMillis() - parseStartTime);
        return result;
    }

    */
/**
     * 本方法针对返回对象为 Result 的 IPage 的分页列表数据进行动态字典注入
     *      1、支持 IPage、List、Po - 250306
     * 字典注入实现 通过对实体类添加注解 @dict 来标识需要的字典内容,字典分为单字典code即可 ，table字典 code table text
     * 示例为 SysUser 字段为sex 添加了注解 @Dict(dicCode = "sex") 会在字典服务立马查出来对应的 text,
     * 然后在请求 list 的时候将这个字典 text，已字段名称加_dictText形式返回到前端
     *
     * 例：输入当前返回值的就会多出一个 sex_dictText 字段
     * {
     *      sex:1,
     *      sex_dictText:"男"
     * }
     * 前端直接取值 sex_dictText 在 table 里面无需再进行前端的字典转换了
     *  customRender:function (text) {
     *               if(text==1){
     *                 return "男";
     *               }else if(text==2){
     *                 return "女";
     *               }else{
     *                 return text;
     *               }
     *             }
     *             目前 vue 是这么进行字典渲染到 table 上的多了就很麻烦了，这个直接在服务端渲染完成前端可以直接用
     * @param result 转化后的结果集
     *//*

    private Object parseDictText(Object result) {
        // 构建容器
        List<JSONObject> items = new ArrayList<>();
        // 筛选出加了 Dict 注解的字段列表
        List<Field> dictFieldList = new ArrayList<>();
        // 字典数据列表， key = 字典code，value=数据列表
        Map<String, List<String>> dataListMap = new HashMap<>(5);

        // 判断 result 是否是 Result 类型（或其子类/实现类）的实例
        if (result instanceof R) {
            // 判断 ((Result) result).getResult() 是否是 IPage 类型
            if (((R)result).getData() instanceof IPage) {
                // 取出结果集
                List<Object> records = ((IPage)((R)result).getData()).getRecords();
                // 判断是否含有字典注解，没有注解返回
                Boolean hasDict = checkHasDict(records);
                if (!hasDict) {
                    return result;
                }
                // 数据转换
                dataConversion(items, dictFieldList, dataListMap, records);
                // 覆写
                ((IPage)((R)result).getData()).setRecords(items);
                // 卫函数
                return result;
            }
            // 判断 ((Result) result).getResult() 是否是 List 类型
            if (((R)result).getData() instanceof List) {
                // 取出结果集
                List<Object> records = ((List)((R)result).getData());
                Boolean hasDict = checkHasDict(records);
                if (!hasDict) {
                    return result;
                }
                dataConversion(items, dictFieldList, dataListMap, records);
                ((R)result).setData(items);
                return result;
            }
            // 判断 ((Result) result).getResult() 是否是 单实体类 类型
            if (((R)result).getData() instanceof Object) {
                // 取出结果集
                List<Object> records = Arrays.asList(((R)result).getData());
                Boolean hasDict = checkHasDict(records);
                if (!hasDict) {
                    return result;
                }
                dataConversion(items, dictFieldList, dataListMap, records);
                ((R)result).setData(items.get(0));
                return result;
            }
        }
        return result;
    }

    */
/**
     * 数据翻译
     * @param items
     * @param dictFieldList
     * @param dataListMap
     * @param records
     *//*

    private void dataConversion(List<JSONObject> items, List<Field> dictFieldList,
                                Map<String, List<String>> dataListMap, List<Object> records) {
        log.debug(" —— 进入字典翻译切面 DictAspect —— ");
        // update-end--Author:zyf -- Date:20220606 ----for：【VUEN-1230】 判断是否含有字典注解,没有注解返回-----
        for (Object record : records) {
            String json = "{}";
            try {
                // update-begin--Author:zyf -- Date:20220531 ----for：【issues/#3629】 DictAspect Jackson序列化报错-----
                // 解决@JsonFormat注解解析不了的问题详见SysAnnouncement类的@JsonFormat
                json = objectMapper.writeValueAsString(record);
                // update-end--Author:zyf -- Date:20220531 ----for：【issues/#3629】 DictAspect Jackson序列化报错-----
            } catch (JsonProcessingException e) {
                log.error("json解析失败" + e.getMessage(), e);
            }
            // update-begin--Author:scott -- Date:20211223 ----for：【issues/3303】restcontroller返回json数据后key顺序错乱 -----
            JSONObject item = JSONObject.parseObject(json, Feature.OrderedField);
            // update-end--Author:scott -- Date:20211223 ----for：【issues/3303】restcontroller返回json数据后key顺序错乱 -----

            // update-begin--Author:scott -- Date:20190603 ----for：解决继承实体字段无法翻译问题------
            // for (Field field : record.getClass().getDeclaredFields()) {
            // 遍历所有字段，把字典Code取出来，放到 map 里
            for (Field field : CustConvertUtils.getAllFields(record)) {
                String value = item.getString(field.getName());
                if (CustConvertUtils.isEmpty(value)) {
                    continue;
                }
                // update-end--Author:scott -- Date:20190603 ----for：解决继承实体字段无法翻译问题------
                if (field.getAnnotation(Dict.class) != null) {
                    if (!dictFieldList.contains(field)) {
                        dictFieldList.add(field);
                    }
                    String code = field.getAnnotation(Dict.class).dicCode();
                    String text = field.getAnnotation(Dict.class).dicText();
                    String table = field.getAnnotation(Dict.class).dictTable();
                    String defaultWhere = field.getAnnotation(Dict.class).dictWhere();

                    List<String> dataList;
                    String dictCode = code;
                    if (!StringUtils.isEmpty(table)) {
                        if (StrUtil.isBlank(defaultWhere)) {
                            dictCode = String.format("%s,%s,%s", table, text, code);
                        } else {
                            dictCode = String.format("%s,%s,%s,%s", table, text, code, defaultWhere);
                        }
                    }
                    dataList = dataListMap.computeIfAbsent(dictCode, k -> new ArrayList<>());
                    this.listAddAllDeduplicate(dataList, Arrays.asList(value.split(",")));
                }
                // date类型默认转换string格式化日期
                // update-begin--Author:zyf -- Date:20220531 ----for：【issues/#3629】 DictAspect Jackson序列化报错-----
                // if
                // (JAVA_UTIL_DATE.equals(field.getType().getName())&&field.getAnnotation(JsonFormat.class)==null&&item.get(field.getName())!=null){
                // SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // item.put(field.getName(), aDate.format(new Date((Long) item.get(field.getName()))));
                // }
                // update-end--Author:zyf -- Date:20220531 ----for：【issues/#3629】 DictAspect Jackson序列化报错-----
            }
            items.add(item);
        }

        // step.2 调用翻译方法，一次性翻译
        Map<String, List<DictModel>> translText = this.translateAllDict(dataListMap);

        // step.3 将翻译结果填充到返回结果里
        for (JSONObject record : items) {
            for (Field field : dictFieldList) {
                String code = field.getAnnotation(Dict.class).dicCode();
                String text = field.getAnnotation(Dict.class).dicText();
                String table = field.getAnnotation(Dict.class).dictTable();
                String defaultWhere = field.getAnnotation(Dict.class).dictWhere();

                String fieldDictCode = code;
                if (!StringUtils.isEmpty(table)) {
                    if (StrUtil.isBlank(defaultWhere)) {
                        fieldDictCode = String.format("%s,%s,%s", table, text, code);
                    } else {
                        fieldDictCode = String.format("%s,%s,%s,%s", table, text, code, defaultWhere);
                    }
                }

                String value = record.getString(field.getName());
                if (CustConvertUtils.isNotEmpty(value)) {
                    List<DictModel> dictModels = translText.get(fieldDictCode);
                    if (dictModels == null || dictModels.size() == 0) {
                        continue;
                    }

                    String textValue = this.translDictText(dictModels, value);
                    log.debug(" 字典Val : " + textValue);
                    log.debug(" __翻译字典字段__ " + field.getName() + CommonConstant.DICT_TEXT_SUFFIX + "： " + textValue);

                    // TODO-sun 测试输出，待删
                    log.debug(" ---- dictCode: " + fieldDictCode);
                    log.debug(" ---- value: " + value);
                    log.debug(" ----- text: " + textValue);
                    log.debug(" ---- dictModels: " + JSON.toJSONString(dictModels));

                    record.put(field.getName() + CommonConstant.DICT_TEXT_SUFFIX, textValue);
                }
            }
        }
    }

    */
/**
     * list 去重添加
     *//*

    private void listAddAllDeduplicate(List<String> dataList, List<String> addList) {
        // 筛选出dataList中没有的数据
        List<String> filterList = addList.stream().filter(i -> !dataList.contains(i)).collect(Collectors.toList());
        dataList.addAll(filterList);
    }

    */
/**
     * 一次性把所有的字典都翻译了
     * ----1. 所有的普通数据字典的所有数据只执行一次SQL
     * ----2. 表字典相同的所有数据只执行一次SQL
     *
     * @param dataListMap
     * @return
     *//*

    private Map<String, List<DictModel>> translateAllDict(Map<String, List<String>> dataListMap) {
        // 翻译后的字典文本，key=dictCode
        Map<String, List<DictModel>> translText = new HashMap<>(5);
        // 需要翻译的数据（有些可以从redis缓存中获取，就不走数据库查询）
        List<String> needTranslData = new ArrayList<>();
        // step.1 先通过redis中获取缓存字典数据
        for (String dictCode : dataListMap.keySet()) {
            List<String> dataList = dataListMap.get(dictCode);
            if (dataList.size() == 0) {
                continue;
            }
            // 表字典需要翻译的数据
            List<String> needTranslDataTable = new ArrayList<>();
            for (String s : dataList) {
                String data = s.trim();
                if (data.length() == 0) {
                    // 跳过循环
                    continue;
                }
                if (dictCode.contains(",")) {
                    String keyString = String.format("sys:cache:dictTable::SimpleKey [%s,%s]", dictCode, data);
                    if (redisTemplate.hasKey(keyString)) {
                        try {
                            String text = CustConvertUtils.getString(redisTemplate.opsForValue().get(keyString));
                            List<DictModel> list = translText.computeIfAbsent(dictCode, k -> new ArrayList<>());
                            list.add(new DictModel(data, text));
                        } catch (Exception e) {
                            log.warn(e.getMessage());
                        }
                    } else if (!needTranslDataTable.contains(data)) {
                        // 去重添加
                        needTranslDataTable.add(data);
                    }
                } else {
                    String keyString = String.format("sys:cache:dict::%s:%s", dictCode, data);
                    if (redisTemplate.hasKey(keyString)) {
                        try {
                            String text = CustConvertUtils.getString(redisTemplate.opsForValue().get(keyString));
                            List<DictModel> list = translText.computeIfAbsent(dictCode, k -> new ArrayList<>());
                            list.add(new DictModel(data, text));
                        } catch (Exception e) {
                            log.warn(e.getMessage());
                        }
                    } else if (!needTranslData.contains(data)) {
                        // 去重添加
                        needTranslData.add(data);
                    }
                }

            }
            // step.2 调用数据库翻译表字典
            if (needTranslDataTable.size() > 0) {
                String[] arr = dictCode.split(",");
                String table = arr[0], text = arr[1], code = arr[2];
                String defaultWhere = arr.length > 3 ? arr[3] : "";
                String values = String.join(",", needTranslDataTable);
                log.debug("translateDictFromTableByKeys.dictCode:" + dictCode);
                log.debug("translateDictFromTableByKeys.values:" + values);
                List<DictModel> texts = null;
                if (StrUtil.isBlank(defaultWhere)) {
                    texts = commonApi.translateDictFromTableByKeys(table, text, code, values);
                } else {
                    texts = commonApi.translateDictFromTableByKeysWhere(table, text, code, values, defaultWhere);
                }
                log.debug("translateDictFromTableByKeys.result:" + texts);
                List<DictModel> list = translText.computeIfAbsent(dictCode, k -> new ArrayList<>());
                list.addAll(texts);

                // 做 redis 缓存
                for (DictModel dict : texts) {
                    String redisKey =
                            String.format("sys:cache:dictTable::SimpleKey [%s,%s]", dictCode, dict.getValue());
                    try {
                        // update-begin-author:taoyan date:20211012 for: 字典表翻译注解缓存未更新 issues/3061
                        // 保留5分钟
                        redisTemplate.opsForValue().set(redisKey, dict.getText(), 300, TimeUnit.SECONDS);
                        // update-end-author:taoyan date:20211012 for: 字典表翻译注解缓存未更新 issues/3061
                    } catch (Exception e) {
                        log.warn(e.getMessage(), e);
                    }
                }
            }
        }

        // step.3 调用数据库进行翻译普通字典
        if (needTranslData.size() > 0) {
            List<String> dictCodeList = Arrays.asList(dataListMap.keySet().toArray(new String[] {}));
            // 将不包含逗号的字典code筛选出来，因为带逗号的是表字典，而不是普通的数据字典
            List<String> filterDictCodes =
                    dictCodeList.stream().filter(key -> !key.contains(",")).collect(Collectors.toList());
            String dictCodes = String.join(",", filterDictCodes);
            String values = String.join(",", needTranslData);
            log.debug("translateManyDict.dictCodes:" + dictCodes);
            log.debug("translateManyDict.values:" + values);
            Map<String, List<DictModel>> manyDict = commonApi.translateManyDict(dictCodes, values);
            log.debug("translateManyDict.result:" + manyDict);
            for (String dictCode : manyDict.keySet()) {
                List<DictModel> list = translText.computeIfAbsent(dictCode, k -> new ArrayList<>());
                List<DictModel> newList = manyDict.get(dictCode);
                list.addAll(newList);

                // 做 redis 缓存
                for (DictModel dict : newList) {
                    String redisKey = String.format("sys:cache:dict::%s:%s", dictCode, dict.getValue());
                    try {
                        redisTemplate.opsForValue().set(redisKey, dict.getText());
                    } catch (Exception e) {
                        log.warn(e.getMessage(), e);
                    }
                }
            }
        }
        return translText;
    }

    */
/**
     * 字典值替换文本
     *
     * @param dictModels
     * @param values
     * @return
     *//*

    private String translDictText(List<DictModel> dictModels, String values) {
        List<String> result = new ArrayList<>();

        // 允许多个逗号分隔，允许传数组对象
        String[] splitVal = values.split(",");
        for (String val : splitVal) {
            String dictText = val;
            for (DictModel dict : dictModels) {
                if (val.equals(dict.getValue())) {
                    dictText = dict.getText();
                    break;
                }
            }
            result.add(dictText);
        }
        return String.join(",", result);
    }

    */
/**
     * 翻译字典文本
     *
     * @param code
     * @param text
     * @param table
     * @param key
     * @return
     *//*

    @Deprecated
    private String translateDictValue(String code, String text, String table, String key) {
        if (CustConvertUtils.isEmpty(key)) {
            return null;
        }
        StringBuffer textValue = new StringBuffer();
        String[] keys = key.split(",");
        for (String k : keys) {
            String tmpValue = null;
            log.debug(" 字典 key : " + k);
            if (k.trim().length() == 0) {
                continue; // 跳过循环
            }
            // update-begin--Author:scott -- Date:20210531 ----for： !56 优化微服务应用下存在表字段需要字典翻译时加载缓慢问题-----
            if (!StringUtils.isEmpty(table)) {
                log.debug("--DictAspect------dicTable=" + table + " ,dicText= " + text + " ,dicCode=" + code);
                String keyString =
                        String.format("sys:cache:dictTable::SimpleKey [%s,%s,%s,%s]", table, text, code, k.trim());
                if (redisTemplate.hasKey(keyString)) {
                    try {
                        tmpValue = CustConvertUtils.getString(redisTemplate.opsForValue().get(keyString));
                    } catch (Exception e) {
                        log.warn(e.getMessage());
                    }
                } else {
                    tmpValue = commonApi.translateDictFromTable(table, text, code, k.trim());
                }
            } else {
                String keyString = String.format("sys:cache:dict::%s:%s", code, k.trim());
                if (redisTemplate.hasKey(keyString)) {
                    try {
                        tmpValue = CustConvertUtils.getString(redisTemplate.opsForValue().get(keyString));
                    } catch (Exception e) {
                        log.warn(e.getMessage());
                    }
                } else {
                    tmpValue = commonApi.translateDict(code, k.trim());
                }
            }
            // update-end--Author:scott -- Date:20210531 ----for： !56 优化微服务应用下存在表字段需要字典翻译时加载缓慢问题-----

            if (tmpValue != null) {
                if (!"".equals(textValue.toString())) {
                    textValue.append(",");
                }
                textValue.append(tmpValue);
            }

        }
        return textValue.toString();
    }

    */
/**
     * 检测返回结果集中是否包含Dict注解
     *
     * @param records
     * @return
     *//*

    private Boolean checkHasDict(List<Object> records) {
        if (CustConvertUtils.isNotEmpty(records) && records.size() > 0) {
            for (Field field : CustConvertUtils.getAllFields(records.get(0))) {
                if (CustConvertUtils.isNotEmpty(field.getAnnotation(Dict.class))) {
                    return true;
                }
            }
        }
        return false;
    }

}
*/
