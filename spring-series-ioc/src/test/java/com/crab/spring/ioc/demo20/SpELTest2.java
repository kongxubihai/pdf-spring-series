package com.crab.spring.ioc.demo20;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/27 15:24
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class SpELTest2 {
    // 解析器
    SpelExpressionParser parser;
    // 评估上下文
    SimpleEvaluationContext context;

    @Before
    public void before() {
        parser = new SpelExpressionParser();
        context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
    }


    @Test
    public void test_literal() {
        ExpressionParser parser = new SpelExpressionParser();

        // 字符串 "Hello World"
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
        System.out.println(helloWorld);

        double num = (Double) parser.parseExpression("6.0221415E+23").getValue();
        System.out.println(num);

        // int  2147483647
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        System.out.println(maxValue);

        // 负数
        System.out.println((Integer) parser.parseExpression("-100").getValue());

        // boolean
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        System.out.println(trueValue);

        // null
        Object nullValue = parser.parseExpression("null").getValue();
        System.out.println(nullValue);
    }


    /**
     * 属性 数组 列表 map 索引
     */
    @Test
    public void test2() {
        Inventor inventor = new Inventor("发明家1", "中国");
        // 发明作品数组
        inventor.setInventions(new String[]{"发明1", "发明2", "发明3", "发明4"});

        // 1 属性
        String name = parser.parseExpression("name").getValue(context, inventor, String.class);
        System.out.println("属性： " + name);
        // 属性： 发明家1

        // 2 数组表达式
        String invention = parser.parseExpression("inventions[3]").getValue(context, inventor, String.class);
        System.out.println("数组表达式: " + invention);
        // 数组表达式: 发明4

        // 3 List
        List strList = Arrays.asList("str1", "str2", "str3");
        String str = parser.parseExpression("[0]").getValue(context, strList, String.class);
        System.out.println(str);
        // str1

        // 4 map
        Map map = new HashMap<String, String>();
        map.put("xxx", "ooo");
        map.put("xoo", "oxx");
        String value = parser.parseExpression("['xoo']").getValue(context, map, String.class);
        System.out.println(value);
        // oxx
    }


    // 内联List
    @Test
    public void test3() {
        List numbers = (List) parser.parseExpression("{1,3,5,7}").getValue(context);
        System.out.println(numbers);
        //[1, 3, 5, 7]
        List listOfList = (List) parser.parseExpression("{{1,3,5,7},{0,2,4,6}}").getValue(context);
        System.out.println(listOfList);
        // [[1, 3, 5, 7], [0, 2, 4, 6]]
    }

    /**
     * 4 内联Map
     */
    @Test
    public void test4() {
        Map<String, Object> infoMap =
                (Map<String, Object>) parser.parseExpression("{'name':'name', password:'111'}").getValue();
        System.out.println(infoMap);
        //{name=name, password=111}

        Map mapOfMap =
                (Map) parser.parseExpression("{name:{first:'xxx', last:'ooo'}, password:'111'}").getValue(context);
        System.out.println(mapOfMap);
        // {name={first=xxx, last=ooo}, password=111}
    }

    /**
     * 数组生成
     */
    @Test
    public void test5() {
        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(context);

        // 一维数组可以初始化
        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);

        // 多维数组不可以初始化
        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(context);
    }

    /**
     * 方法调用
     */
    @Test
    public void test6() {
        String bc = parser.parseExpression("'abc'.substring(1, 3)").getValue(String.class);
        System.out.println(bc);
        // bc

        Society societyContext = new Society();
        // 传递参数
        boolean isMember = parser.parseExpression("isMember('Mihajlo Pupin')").getValue(
                societyContext, Boolean.class);
        System.out.println(isMember);
        // false
    }

    /**
     * 关系运算符
     */
    @Test
    public void test7() {
        // true
        boolean trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
        // false
        boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        // false
        boolean falseValue2 = parser.parseExpression("2 gt -5.0").getValue(Boolean.class);
        // true
        boolean trueValue2 = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);

        // null 比任何比较数小
        // true
        Boolean value = parser.parseExpression("100 > null").getValue(boolean.class);
        // false
        Boolean value2 = parser.parseExpression("-1 < null").getValue(boolean.class);
        System.out.println(value);
        System.out.println(value2);


        // instanceof 支持
        // false
        Boolean aBoolean = parser.parseExpression("'xxx' instanceof T(Integer)").getValue(Boolean.class);
        System.out.println(aBoolean);

        // 支持正则表达式 matches
        // true
        Boolean match = parser.parseExpression(
                "'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        // false
        Boolean notMatch = parser.parseExpression(
                "'5.0067' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        System.out.println(match);
        System.out.println(notMatch);
    }

    /**
     * 逻辑运算符
     */
    @Test
    public void test8() {
        Society societyContext = new Society();

        // -- AND --
        // false
        boolean falseValue = parser.parseExpression("true and false").getValue(Boolean.class);
        // true
        String expression = "isMember('Nikola Tesla') and isMember('Mihajlo Pupin')";
        boolean trueValue = parser.parseExpression(expression).getValue(societyContext, Boolean.class);

        // -- OR --

        // true
        boolean trueValue2 = parser.parseExpression("true or false").getValue(Boolean.class);
        // true
        expression = "isMember('Nikola Tesla') or isMember('Albert Einstein')";
        boolean trueValue3 = parser.parseExpression(expression).getValue(societyContext, Boolean.class);

        // -- NOT --

        // false
        boolean falseValue2 = parser.parseExpression("!true").getValue(Boolean.class);

        // -- AND and NOT --
        expression = "isMember('Nikola Tesla') and !isMember('Mihajlo Pupin')";
        boolean falseValue3 = parser.parseExpression(expression).getValue(societyContext, Boolean.class);

    }

    /**
     * 数学运算符
     */
    @Test
    public void test9() {
        // Addition
        int two = parser.parseExpression("1 + 1").getValue(Integer.class);  // 2

        String testString = parser.parseExpression(
                "'test' + ' ' + 'string'").getValue(String.class);  // 'test string'

        // Subtraction
        int four = parser.parseExpression("1 - -3").getValue(Integer.class);  // 4

        double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class);  // -9000

        // Multiplication
        int six = parser.parseExpression("-2 * -3").getValue(Integer.class);  // 6

        double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class);  // 24.0

        // Division
        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class);  // -2

        double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class);  // 1.0

        // Modulus
        int three = parser.parseExpression("7 % 4").getValue(Integer.class);  // 3

        int value = parser.parseExpression("8 / 5 % 2").getValue(Integer.class);  // 1

        int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class);  // -21

    }

    /**
     * 赋值操作
     */
    @Test
    public void test10() {
        Inventor inventor = new Inventor();
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        // setValue 中
        parser.parseExpression("Name").setValue(context, inventor, "xxx");

        //  等价于在 getValue 赋值
        String name = parser.parseExpression(
                "Name = 'xxx'").getValue(context, inventor, String.class);

        System.out.println(name); // xxx
    }

    /**
     * 类类型
     */
    @Test
    public void test11() {
        // 1 获取类的Class java.lang包下的类可以不指定全路径
        Class value = parser.parseExpression("T(String)").getValue(Class.class);
        System.out.println(value);

        // 2 获取类的Class 非java.lang包下的类必须指定全路径
        Class dateValue = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        System.out.println(dateValue);

        // 3 类中的静态变量 静态方法属于Class 通过T(xxx)调用
        boolean trueValue = parser.parseExpression(
                        "T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
                .getValue(Boolean.class); // true
        System.out.println(trueValue);
        Long longValue = parser.parseExpression("T(Long).parseLong('9999')").getValue(Long.class);
        System.out.println(longValue);// 9999
    }

    /**
     * new 调用构造方法
     */
    @Test
    public void test12() {
        Inventor value =
                parser.parseExpression("new com.crab.spring.ioc.demo20.Inventor('ooo','xxx')").getValue(Inventor.class);
        System.out.println(value.getName() + " " + value.getNationality()); // ooo xxx

        String value1 = parser.parseExpression("new String('xxxxoo')").getValue(String.class);
        System.out.println(value1); // xxxxoo
    }

    /**
     * 变量 #
     */
    @Test
    public void test13() {
        Inventor inventor = new Inventor("xxx", "xxx");
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("newName", "new ooo");
        // 使用预先的变量赋值 Name 属性
        parser.parseExpression("Name = #newName").getValue(context, inventor);
        System.out.println(inventor.getName()); // new ooo
    }

    /**
     *
     */
    @Test
    public void test14() {
        // create an array of integers
        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17));

        // 定义变量 'primes'
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("primes", primes);


        // #this  变量始终被定义并引用当前评估对象。 此处是当前选择的元素
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
                "#primes.?[#this>10]").getValue(context);
        System.out.println(primesGreaterThanTen); // [11, 13, 17]
    }

    /**
     * 集合选择
     */
    @Test
    public void test15() {
        Society society = new Society();
        // 发明者列表
        for (int i = 0; i < 5; i++) {
            Inventor inventor = new Inventor("发明家" + i, i % 2 == 0 ? "中国" : "外国");
            society.getMembers().add(inventor);
        }
        // 1、 List 筛选 .?[selectionExpression]
        List<Inventor> list =
                (List<Inventor>) parser.parseExpression("members.?[nationality == '中国']").getValue(society);
        list.forEach(item -> {
            System.out.println(item.getName() + " : " + item.getNationality());
        });
        // 发明家0 : 中国
        // 发明家2 : 中国
        // 发明家4 : 中国

        // 2、 List  取第一个.^[selectionExpression]  取最后一个.$[selectionExpression]
        Inventor first = parser.parseExpression("members.^[nationality == '中国']").getValue(society,
                Inventor.class);
        Inventor last = parser.parseExpression("members.$[nationality == '中国']").getValue(society, Inventor.class);
        System.out.println(first.getName() + " : " + first.getNationality());// 发明家0 : 中国
        System.out.println(last.getName() + " : " + last.getNationality()); // 发明家4 : 中国

        // 3 Map 筛选维度是 Map.Entry，其键和值可作为用于选择的属性访问
        society.getOfficers().put("1", 100);
        society.getOfficers().put("2", 200);
        society.getOfficers().put("3", 300);
        Map mapNew = (Map) parser.parseExpression("officers.?[value>100]").getValue(society);
        System.out.println(mapNew); // {2=200, 3=300}
    }

    /**
     * 集合映射
     */
    @Test
    public void test16() {
        Society society = new Society();
        // 发明者列表
        for (int i = 0; i < 5; i++) {
            Inventor inventor = new Inventor("发明家" + i, i % 2 == 0 ? "中国" : "外国");
            society.getMembers().add(inventor);
        }
        // 1、 List<Inventor> 映射到 List<String> 只要name
        List<String> nameList = (List<String>) parser.parseExpression("members.![name]").getValue(society);
        System.out.println(nameList); // [发明家0, 发明家1, 发明家2, 发明家3, 发明家4]

        // 2 Map映射到List
        society.getOfficers().put("1", 100);
        society.getOfficers().put("2", 200);
        society.getOfficers().put("3", 300);
        List<String> kvList = (List<String>) parser.parseExpression("officers.![key + '-' + value]").getValue(society);
        System.out.println(kvList); // [1-100, 2-200, 3-300]
    }

    /**
     * 三目运算和简化
     */
    @Test
    public void test17() {
        Inventor inventor = new Inventor("not null name", "");
        String name = (String) parser.parseExpression("name != null ? name : 'null name'").getValue(inventor);
        System.out.println("三目：" + name);

        // 使用 Elvis运算符
        name = (String) parser.parseExpression("name?:'null name'").getValue(inventor);
        System.out.println("Elvis运算符：" + name);
    }

    /**
     * 多级属性安全访问
     */
    @Test
    public void test18() {
        Inventor inventor = new Inventor("xx", "oo");
        inventor.setPlaceOfBirth(new PlaceOfBirth("北京", "中国"));

        // 正常访问
        String city = parser.parseExpression("PlaceOfBirth?.city").getValue(context, inventor, String.class);
        System.out.println(city); // 北京

        // placeOfBirth为null
        inventor.setPlaceOfBirth(null);
        String city1 = parser.parseExpression("PlaceOfBirth?.city").getValue(context, inventor, String.class);
        System.out.println(city1); // null

        // 非安全访问 异常
        String city3 = parser.parseExpression("PlaceOfBirth.city").getValue(context, inventor, String.class);
        System.out.println(city3); // 抛出异常
    }

    /**
     * 表达式模板 #{}
     */
    @Test
    public void test19() {
        String randomStr = parser.parseExpression("随机数字是： #{T(java.lang.Math).random()}", new TemplateParserContext())
                .getValue(String.class);
        System.out.println(randomStr);
    }


    /**
     * 方法注册和使用
     */
    @Test
    public void test20() throws NoSuchMethodException {
        // 注册 org.springframework.util.StringUtils.startsWithIgnoreCase(String str,String prefix)
        Method method = StringUtils.class.getDeclaredMethod("startsWithIgnoreCase",String.class,String.class);

        // 方式1 变量方式
        SimpleEvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        simpleEvaluationContext.setVariable("startsWithIgnoreCase" ,method);
        Boolean startWith = parser.parseExpression("#startsWithIgnoreCase('123', '111')").getValue(simpleEvaluationContext,
                Boolean.class);
        System.out.println("方式1: " + startWith);

        // 方式2 明确方法方式
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        standardEvaluationContext.registerFunction("startsWithIgnoreCase" ,method);
        Boolean startWit2 =
                parser.parseExpression("#startsWithIgnoreCase('123', '111')").getValue(simpleEvaluationContext,
                Boolean.class);
        System.out.println("方式2: " + startWit2);
    }


    /**
     *
     */
    @Test
    public void test_debug(){
        SpelExpressionParser parser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        Boolean value = parser.parseExpression("1+1!=2").getValue(context, Boolean.class);
        System.out.println(value);
    }

    /**
     *
     */
    @Test
    public void test_debug2() {

        // 解析器
        SpelExpressionParser parser = new SpelExpressionParser();;
        // 评估上下文
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        context.setVariable("hello", "您好！");

        Inventor inventor = new Inventor("xx", "oo");
        inventor.setPlaceOfBirth(new PlaceOfBirth("北京", "中国"));

        // 正常访问
        String city =
                parser.parseExpression("#{PlaceOfBirth?.city}  #{#hello}", new TemplateParserContext()).getValue(context,
                inventor, String.class);
        System.out.println(city); // 北京


    }




}
