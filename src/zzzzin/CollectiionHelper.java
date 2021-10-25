package zzzzin;

/**
 * （1）同步集合类
 * 包括Hashtable、Vector、同步集合包装类，Collections.synchronizedMap()和Collections.synchronizedList()
 * <p>
 * （2）并发集合类
 * 包括ConcurrentHashMap、CopyOnWriteArrayList、CopyOnWriteHashSet
 * <p>
 * 1、性能
 * 同步集合比并发集合会慢得多，主要原因是锁，同步集合会对整个Map或List加锁
 */
public class CollectiionHelper {
    public static void main(String[] args) {

    }
}
/**
 * Collection是最基本的集合接口，存储对象元素集合。一个Collection代表一组Object（元素）。
 * 有些容器允许重复元素有的不允许，有些有序有些无需。由Collection接口派生的两个接口是List和Set。这个接口的设计目的是希望能最大程度抽象出元素的操作。
 * <p>
 * 1 ArrayList实现了List接口的可变大小的数组。（数组可动态创建，如果元素个数超过数组容量，那么就创建一个更大的新数组）
 * <p>
 * 2  1、LinkedList是一个实现了List接口的链表维护的序列容器
 * * 2、允许null元素。
 * * 3、LinkedList提供额外的get，remove，insert方法在LinkedList的首部或尾部。这些操作使LinkedList可被用作堆栈（stack），队列（queue）或双向队列（deque）。
 * * 4、LinkedList没有同步方法。如果多个线程同时访问一个List，则必须自己实现访问同步。
 * <p>
 * Vector非常类似ArrayList。
 * Vector是同步的。
 * <p>
 * Stack继承自Vector，实现一个后进先出的堆栈。
 * <p>
 * HashSet实现了Set接口，基于HashMap进行存储。遍历时不保证顺序，并且不保证下次遍历的顺序和之前一样。HashSet中允许null元素。
 * <p>
 * LinkedHashSet的核心概念相对于HashSet来说就是一个可以保持顺序的Set集合
 * <p>
 * TreeSet即是一组有次序的集合，如果没有指定排序规则Comparator，则会按照自然排序。（自然排序即e1.compareTo(e2) == 0作为比较）
 * TreeSet源码的算法即基于TreeMap
 * <p>
 * LinkedList类实现了Deque接口，所以通常我们可以使用LinkedList来创建一个队列。PriorityQueue类实现了一个优先队列，
 * 优先队列中元素被赋予优先级，拥有高优先级的先被删除。
 * <p>
 * Hashtable继承Map接口，实现一个key-value映射的哈希表。任何非空（non-null）的对象都可作为key或者value。
 * 添加数据使用put(key, value)，取出数据使用get(key)，这两个基本操作的时间开销为常数。HashTable是同步方法，线程安全但是效率低。
 * <p>
 * HashMap和Hashtable类似，不同之处在于HashMap是非同步的，并且允许null，即null value和null key。
 * 定义
 * HashMap就是最基础最常用的一种Map，它无序，以散列表的方式进行存储。之前提到过，HashSet就是基于HashMap，只使用了HashMap的key作为单个元素存储。
 * HashMap实现了Map接口，即允许放入key为null的元素，也允许插入value为null的元素；除该类未实现同步外，其余跟Hashtable大致相同；跟TreeMap不同，该容器不保证元素顺序，根据需要该容器可能会对元素重新哈希，元素的顺序也会被重新打散，因此不同时间迭代同一个HashMap的顺序可能会不同。 根据对冲突的处理方式不同，哈希表有两种实现方式，一种开放地址方式（Open addressing），另一种是冲突链表方式（Separate chaining with linked lists）。Java HashMap采用的是冲突链表方式。
 * HashMap的访问方式就是继承于Map的最基础的3种方式
 * <p>
 * LinkedHashSet是用一个链表实现来扩展HashSet类，它支持对规则集内的元素排序。HashSet中的元素是没有被排序的，而LinkedHashSet中的元素可以按照它们插入规则集的顺序提取。
 * 其实LinkedHashMap的存储还是跟HashMap一样，采用哈希表方法存储，只不过LinkedHashMap多维护了一份head，tail链表
 */
