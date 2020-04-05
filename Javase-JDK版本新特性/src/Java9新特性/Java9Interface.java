package Java9新特性;

/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

/**
 * java9新特性四：接口的私有方法
 *
 *@author 今天也要努力的小白
 *@creat 2020/4/5 11:18
 */
interface MyInterface {

    //如下的三个方法的权限修饰符默认都为public(!!!)

    void methodAbstract();

    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }

    default void methodDefault(){
        System.out.println("我是接口中的默认方法");

        methodPrivate();
    }


    //jdk 9中允许接口中定义私有的方法
    private void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }

}

class MyInterfaceImpl implements MyInterface {

    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() {
        System.out.println("实现类重写了接口中的默认方法");
    }


    public static void main(String[] args) {

        //1.接口中的静态方法只能由接口自己调用(不能用实现类对象调用)
        MyInterface.methodStatic();

        //接口的实现类不能调用接口的静态方法
//        MyInterfaceImpl.methodStatic();

        //2.接口实现类对象可以调用接口的默认方法
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.methodDefault();

        //3.接口的私有方法，不能在接口外部调用
//        impl.methodPrivate();
    }

}
