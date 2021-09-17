package base.collection;

import java.util.ArrayList;
import java.util.List;
/**
 * foreach语句：
 * 格式：
 * for(类型  变量   ：Collection集合|数组)
 * {
 *
 * }
 *
 * 传统for和高级for的区别？
 * 传统for可以完成对语句执行很多次，因为可以定义控制循环的增量和条件。
 *
 * 高级for是一种简化形式。
 * 它必须有被遍历的目标。该目标要是数组，要么是Collection单列集合。
 *
 * 对数组的遍历如果仅仅是获取数组中的元素，可以使用高级for。
 * 如果要对数组的角标进行操作建议使用传统for。
 *
 */
public class ForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //List list = new ArrayList();
        list.add("123");
        list.add("adc");
        list.add("456");
        list.add("xyz");

        for (String s : list){
            System.out.println(s);
        }
    }
}
