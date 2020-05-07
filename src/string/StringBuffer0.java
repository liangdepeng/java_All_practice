package string;
/**
 * StringBuffer:就是字符串缓冲区。
 * 用于存储数据的容器。
 * 特点：
 * 1，长度的可变的。
 * 2，可以存储不同类型数据。
 * 3，最终要转成字符串进行使用。
 * 4，可以对字符串进行修改。
 *
 *
 * 既然是一个容器对象。应该具备什么功能呢？
 * 1，添加：
 * 		StringBuffer append(data);
 * 		StringBuffer insert(index,data);
 * 2，删除：
 * 		StringBuffer delete(start,end):包含头，不包含尾。
 * 		StringBuffer deleteCharAt(int index):删除指定位置的元素
 * 3，查找：
 * 		char charAt(index);
 * 		int indexOf(string);
 * 		int lastIndexOf(string);
 * 4，修改：
 * 		StringBuffer replace(start,end,string);
 * 		void setCharAt(index,char);
 *
 * 增删改查  C(create)U(update)R(read)D(delete)
 *
 *
 *
 */
public class StringBuffer0 {
    public static void main(String[] args) {

        stringbuffer0();
    }

    public static void stringbuffer3() {
        StringBuffer sb = new StringBuffer("abce");

//        sb.delete(1, 3);

        // 清空缓冲区
        //sb.delete(0, sb.length());
//        StringBuffer sb = new StringBuffer(); // 注意区别
//        sb.replace(1, 3, "nba");

//        sb.setCharAt(2, 'q');
//        sb.setLength(10);

        sb.reverse();

        System.out.println(sb);

    }

    public static void stringbuffer1() {
        StringBuffer sb = new StringBuffer("abce");

        sb.append("xixi");
        sb.insert(2, "qq");

        System.out.println(sb.toString());
    }
    private static void stringbuffer0(){
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(4).append(false);// append进来以后都是变为字符串了
        stringBuffer.insert(1,"hello");
        stringBuffer.append(true);
        System.out.println(stringBuffer);
    }
}
