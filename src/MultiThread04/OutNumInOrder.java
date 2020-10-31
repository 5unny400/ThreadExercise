package MultiThread04;

public class OutNumInOrder {
    private Num object = null;

    public static void main(String[] args) throws InterruptedException {

        Num num = new Num();
        OutNumInOrder outNumInOrder = new OutNumInOrder(num);

        outNumInOrder.start();
    }

    public OutNumInOrder(Num object) {
        this.object = object;
    }

    public void start() {
        thread1.setName("A");
        thread2.setName("B");
        thread3.setName("C");

        thread3.start();
        thread1.start();
        thread2.start();
    }

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (object.count % 3 == 0) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("----------------");
                        System.out.println(Thread.currentThread().getName() + (object.countUp()));
                        object.notifyAll();
                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    });
    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (object.count % 3 == 1) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + (object.countUp()));
                        object.notifyAll();
                    } else
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        }
    });
    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (object.count % 3 == 2) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + (object.countUp()));
                        object.notifyAll();
                    } else
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        }
    });


    static class Num {
        private static int count;

        synchronized public static int getCount() {
            return count;
        }

        synchronized public int countUp() {
            if (count <= 100) {
                return count++;
            } else {
                System.exit(0);
            }
            return -1;
        }

    }
}
