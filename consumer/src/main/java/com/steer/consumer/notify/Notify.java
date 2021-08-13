package com.steer.consumer.notify;

public interface Notify {

    /**
     * 至少要有一个入参且第一个入参类型为Throwable或其子类，接收返回结果.例如，onthrow(Throwable ex)
     * 可以有多个参数，多个参数的情况下，第一个后边的所有参数都是用来接收sayHello入参的：例如，onthrow(Throwable ex, String name)
     * @param t
     */
    public void onthrow(Throwable t);
    /**
     * 调用之前
     * 必须具有与真实的被调用方法notify相同的入参列表
     * @param name
     */
    public void oninvoke(String name);
    /**
     * 调用之后
     * 可以有多个参数，多个参数的情况下，第一个后边的所有参数都是用来接收notify入参的
     * @param result
     * @param name
     */
    public void onreturn(String result,String name);
    /**
     * 调用之后
     * 至少要有一个入参且第一个入参必须与notify的返回类型相同，接收返回结果
     * @param result
     */
    public void onreturnWithoutParam(String result);

}
