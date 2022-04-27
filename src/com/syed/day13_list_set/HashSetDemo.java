package com.syed.day13_list_set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @program: MyJavaSE
 * @description: java.util.HashSet 无序不可重复
 *  特点
 * 无序: 元素添加的顺序和存储的数据不一定一致,而且元素没有下标(所有跟下标有关的方法它都没有)
 * 不可重复: 集合中没有重复元素,第二次添加的重复元素不能加入到集合中
 * @author: USER
 * @create: 2022-03-28
 */
public class HashSetDemo {
    public static void main(String[] args) {
        /**
         * set集合的初始化容量为16,加载因子为0.75
         * 加载因子 = 填入集合的元素个数/集合的容量
         *
         * 加载因子越大,则填入集合的元素就越多,则空间利用率就越高,但发生冲突的机会也就变大了
         * 加载因子越小,填满的元素就越少,冲突的几率减小,但是空间利用率不高,而且还无形中提高了扩容操作次数(rehash)
         * 即官方默认的这个0.75其实是在冲突几率和空间使用率之间的一个平衡!
         */
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);

        /**遍历方法*/
        //直接打印
        System.out.println(hashSet);

        //普通for不可以（建立在下标下遍历）

        //增强for
        for(Integer e: hashSet){
            System.out.println(e);
        }

        //forEach
        hashSet.forEach(System.out::println);

        //迭代器
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        User u1 = new User("AA","111");
        User u2 = new User("BB","222");
        User u3 = new User("AA","111");
        User u4 = new User("DD","444");
        User u5 = new User("CC","333");

        /**
         * Set集合的无序,不可重复原理:
         * 一:set集合默认情况下是判断集合存放元素(对象类型)的内存地址,地址相同,则认为是同一个对象,地址不同,则视为不同对象
         * 二:通过重写元素对象的hashCode()和equals()方法,来使得不同对象比较时看的是属性值是否相同,而不是看真正的内存地址
         */
        Set<User> users = new HashSet<>();
        /**1.当第一个元素添加到set集合中时,会调用这个元素对象的hashCode()方法得到一个哈希值(散列码),然后会根据这个散列码
         来决定该元素存放在集合的哪个位置.*/
        users.add(u1);
        /**2.当第二个元素添加到set集合中时,仍然会调用这个元素对象的hashCode()方法得到一个散列码,根据这个散列码来放位置*/
        users.add(u2);
        /**3.当第三个元素添加到set集合中时,仍然会调用这个元素对象的hashCode()方法得到一个散列码,此时这个散列码会和第一个添加的元素重复,
         则会自动调用对象的equals()方法,出现以下两种情况:
         a.equals()方法返回true,说明两个对象时同一个对象,则该对象就不被添加到set集合中了
         b.equals()方法返回false,说明这两个对象不是同一个对象,只不过它们的散列码一致,所以该对象要添加到集合中,以链表的方式追加到
         同散列码的元素上,这种情况叫做元素碰撞
         注意:
         如果元素碰撞过多,则会导致该集合的遍历性能下降,所以,在JDK8.0开始提供了如下改进
         当链表长度超过8时,则自动把链表转换成红黑树,从而,提高检索性能
         */
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.forEach(System.out::println);
    }
}

@AllArgsConstructor
@ToString
@Setter
@Getter
class User{
    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
