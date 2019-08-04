package com.test.thread;

/**
 *  通常我们通过匿名内部类的方式定义ThreadLocal的子类，提供初始的变量值，如例子中①处所示。TestClient线程产生一组序列号，在③处，我们生成3个TestClient，它们共享同一个TestNum实例。
 *  运行以上代码，在控制台上输出以下的结果：
 * thread[Thread-0] --> sn[1]
 * thread[Thread-1] --> sn[1]
 * thread[Thread-2] --> sn[1]
 * thread[Thread-1] --> sn[2]
 * thread[Thread-0] --> sn[2]
 * thread[Thread-1] --> sn[3]
 * thread[Thread-2] --> sn[2]
 * thread[Thread-0] --> sn[3]
 * thread[Thread-2] --> sn[3]
 * 考察输出的结果信息，我们发现每个线程所产生的序号虽然都共享同一个TestNum实例，但它们并没有发生相互干扰的情况，而是各自产生独立的序列号，
 * 这是因为我们通过ThreadLocal为每一个线程提供了单独的副本。
 *
 * ThreadLocal类接口很简单，只有4个方法，我们先来了解一下：
 *
 * void set(Object value)设置当前线程的线程局部变量的值。
 * public Object get()该方法返回当前线程所对应的线程局部变量。
 * public void remove()将当前线程局部变量的值删除，目的是为了减少内存的占用，该方法是JDK 5.0新增的方法。
 *      需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，所以显式调用该方法清除线程的局部变量并不是必须的操作，但它可以加快内存回收的速度。
 * protected Object initialValue()返回该线程局部变量的初始值，该方法是一个protected的方法，显然是为了让子类覆盖而设计的。
 *      这个方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，并且仅执行1次。ThreadLocal中的缺省实现直接返回一个null。
 */
public class TestThreadLocal {
    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    // ②获取下一个序列值
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        TestThreadLocal sn = new TestThreadLocal();
        // ③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private TestThreadLocal sn;

        public TestClient(TestThreadLocal sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                // ④每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                        + sn.getNextNum() + "]");
            }
        }
    }
}
