package com.socode.lyf.interview.JVM;

import java.io.*;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/5 10:28
 */
public class MyClassLoader extends ClassLoader{

    private  String path;

    private String name;


    public MyClassLoader(String name, String path) {
        super(); // 让系统类
        this.name = name;
        this.path = path;
    }


    public MyClassLoader(ClassLoader parent,String path,String name) {
        super(parent);
        this.name = name;
        this.path = path;
    }

    /**
     * 加载我们自定义的类。通过我们自定义的这个ClassLoader
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data =   readClassFileToByteArray(name);
        return this.defineClass(name,data,0,data.length);
        //return super.findClass(name);
    }

    /**
     *  获取.class文件字节数组
     * @param name
     * @return
     */
    private byte[] readClassFileToByteArray(String name) {
        InputStream is = null;
        byte[] returnData = null;
        name = name.replaceAll("\\.", "/");

        String filePath = this.path +  name  + ".class";

        File file = new File(filePath);

        ByteArrayOutputStream  os  = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(file);
            int tmp = 0;
            while((tmp = is.read()) != -1){
                os.write(tmp);
            }
            returnData  = os.toByteArray();
            return  returnData;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
                os.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
        return  null;
    }
}
