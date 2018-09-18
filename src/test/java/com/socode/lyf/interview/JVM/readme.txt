1, JVM运行流程，jvm基本结构
     类加载器，执行引擎，运行时数据区，本地接口
     ClassFiles >> ClassLoader >> 运行时数据区  >> 执行引擎,本地库接口

     类的装载：
           加载，链接（验证，准备，解析），初始化，使用，卸载

       Class 保存类的定义或者结构

       初始化：执行类的构造器<clinit>， 味蕾的静态比阿拉ing赋予准确的初始值

       构造器：
                1, static 变量
                2， static{} 语句

       构造方法 实例化对象
2，类加载器双亲委派机制
   BootStrapClassloder   -- >> rt.jar
   Extension Classloader extends ClassLoader -- >> %JAVA_HOME%/lib/ext/*.jar

   AppClassloade extends Classloade  -- >> classpath 下


3，ClasssLoader 源码解析
4，