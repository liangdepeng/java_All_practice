package ldp.datastructure;


import ldp.utils.SystemOutputUtils;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列   - 先进先出 后进后出
 * <p>
 * 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
 * <p>
 * LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用
 * <p>
 * <p>
 * ---------public class ArrayDeque<E> extends AbstractCollection<E>----
 * ------ ArrayDeque----------
 * Deque接口的可调整大小的数组实现。
 * 阵列双端队列没有容量限制。它们会根据需要增长以支持使用。
 * 它们不是线程安全的。在没有外部同步的情况下，它们不支持多个线程的并发访问。
 * 空元素是禁止的。用作堆栈时，此类可能比Stack快，而用作队列时，此类则比LinkedList快。
 * 大多数ArrayDeque操作均以固定的固定时间运行。异常包括remove，removeFirstOccurrence，
 * removeLastOccurrence，contains，iterator.remove（）和批量操作，所有这些操作均以线性时间运行。
 * 此类的迭代器方法返回的迭代器是快速失败的：如果在创建迭代器后的任何时间修改了双端队列，
 * 则除了通过迭代器自己的remove方法之外，该迭代器通常会抛出ConcurrentModificationException。
 * 因此，面对并发修改，迭代器会快速干净地失败，而不会在未来的不确定时间内冒任意，不确定的行为的风险。
 * 请注意，迭代器的快速失败行为无法得到保证，因为通常来说，在存在不同步的并发修改的情况下，不可能做出任何严格的保证。
 * 快速失败的迭代器会尽最大努力抛出ConcurrentModificationException。
 * 因此，编写依赖于此异常的程序的正确性是错误的：迭代器的快速失败行为应仅用于检测错误。
 * 此类及其迭代器实现Collection和Iterator接口的所有可选方法。此类是Java Collections Framework的成员。
 * 从以下版本开始：1.6作者：Josh Bloch和Doug Lea类型参数：<E> –此集合中包含的元素的类型
 * <p>
 * <p>
 * <p>
 * ----- public class ArrayQueue<T> extends AbstractList<T>-----
 * ----- AbstractList----
 * 此类提供了List接口的基本实现，以最大程度地减少实现由“随机访问”数据存储（例如数组）支持的此接口所需的工作。
 * 对于顺序访问数据（例如链表），应优先使用AbstractSequentialList而不是此类。要实现不可修改的列表，
 * 程序员只需要扩展此类并为get（int）和size（）方法提供实现即可。要实现可修改的列表，
 * 程序员必须另外重写set（int，E）方法（否则将抛出UnsupportedOperationException）。
 * 如果列表是可变大小的，则程序员必须另外重写add（int，E）和remove（int）方法。
 * 根据Collection接口规范中的建议，程序员通常应提供一个void（无参数）和collection构造函数。
 * 与其他抽象集合实现不同，程序员不必提供迭代器实现。
 * 迭代器和列表迭代器由此类在“随机访问”方法之上实现：get（int），set（int，E），add（int，E）和remove（int）。
 * 此类中每个非抽象方法的文档都详细描述了其实现。如果正在实现的集合允许更有效的实现，则可以覆盖这些方法中的每一个。
 * 此类是Java Collections Framework的成员。从：1.2作者：乔什·布洛赫（Josh Bloch）和尼尔·冈特（Neal Gafter）
 */
public class DataStructurePartThree {

    private static final String[] s = new String[]{"test1", "test2", "test3", "test4", "test5", "testLast"};

    public static void main(String[] args) {

        initLinkedList();


        ArrayQueue<String> arrayQueue = new ArrayQueue<>(10);

        for (String item : s) {
            // 入队
            arrayQueue.add(item);
        }

        // 出队
        while (!arrayQueue.isEmpty()) {
            // i 只能 == 0 源码写的 wtf 为了代码而代码
            arrayQueue.remove(0);

            for (int i = 0; i < arrayQueue.size(); i++) {
                SystemOutputUtils.print(arrayQueue.get(i) + "   ");
            }
            SystemOutputUtils.println(" ");
        }

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        for (String item : s) {
            arrayDeque.push(item);
        }

        arrayDeque.addFirst("test_addFirst");
        arrayDeque.addLast("test_addLast");

        arrayDeque.poll();

    }

    private static void initLinkedList() {

        LinkedList<String> queue = new LinkedList<>();

        // 添加元素 //add()和remove()方法在失败的时候会抛出异常(不推荐)
        for (String item : s) {
            queue.offer(item);
        }

        SystemOutputUtils.print(queue.element() + "  ");//返回第一个元素 会抛异常

        SystemOutputUtils.println(queue.peek());//返回第一个元素

        while (!queue.isEmpty()) {
            queue.poll();// 返回第一个元素并且移除第一个元素

            for (int i = 0; i < queue.size(); i++) {
                SystemOutputUtils.print(queue.get(i) + "  ");
            }

            SystemOutputUtils.println("  ");
        }


        SystemOutputUtils.println("  ");
        SystemOutputUtils.println("  ");
    }

}
/**
 * This class provides a skeletal implementation of the List interface to minimize the effort required to implement this interface backed by a "random access" data store (such as an array). For sequential access data (such as a linked list), AbstractSequentialList should be used in preference to this class.
 * To implement an unmodifiable list, the programmer needs only to extend this class and provide implementations for the get(int) and size() methods.
 * To implement a modifiable list, the programmer must additionally override the set(int, E) method (which otherwise throws an UnsupportedOperationException). If the list is variable-size the programmer must additionally override the add(int, E) and remove(int) methods.
 * The programmer should generally provide a void (no argument) and collection constructor, as per the recommendation in the Collection interface specification.
 * Unlike the other abstract collection implementations, the programmer does not have to provide an iterator implementation; the iterator and list iterator are implemented by this class, on top of the "random access" methods: get(int), set(int, E), add(int, E) and remove(int).
 * The documentation for each non-abstract method in this class describes its implementation in detail. Each of these methods may be overridden if the collection being implemented admits a more efficient implementation.
 * This class is a member of the Java Collections Framework.
 * Since:
 * 1.2
 * Author:
 * Josh Bloch, Neal Gafter
 */