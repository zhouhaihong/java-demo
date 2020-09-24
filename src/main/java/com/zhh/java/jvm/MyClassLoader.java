package com.zhh.java.jvm;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String byteCodePath;

    public MyClassLoader(String byteCodePath) {
        this.byteCodePath = byteCodePath;
    }

    public MyClassLoader(ClassLoader parent, String byteCodePath) {
        super(parent);
        this.byteCodePath = byteCodePath;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        String loadClassPath = byteCodePath  +  className + ".class";
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            // 获取字节码输入流
            bis = new BufferedInputStream(new FileInputStream(loadClassPath));
            // 获取输出流
            baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] data = new byte[1024];
            while ((len = bis.read(data)) != -1){
                baos.write(data, 0, len);
            }

            byte[] bytesCode = baos.toByteArray();
            // 调用defineClass，将字节数组的数据转换为Class实例
            Class<?> aClass = defineClass(null, bytesCode, 0, bytesCode.length);
            return aClass;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
