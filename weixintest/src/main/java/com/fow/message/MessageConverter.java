package com.fow.message;

/**
 * 微信消息回复器
 */
public interface MessageConverter extends Comparable {
    /**
     * 微信消息转换方法，调用前先查看是否支持消息类型。
     * @return 是否支持该类型消息
     */
    boolean convert();

    /**
     * 子类支持的消息类型
     * @param msgType 类型参数
     * @return 是否支持该类型消息
     */
    boolean support(String msgType);

    /**
     * 转换器排序，用于实现Comparable接口中调用
     * @return
     */
    int getOrder();
}
