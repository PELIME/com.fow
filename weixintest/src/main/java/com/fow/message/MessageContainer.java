package com.fow.message;

import java.util.LinkedList;
import java.util.List;

/**
 * 微信消息容器
 * @param <T>
 */
public interface MessageContainer<T> {
    static final List<MessageConverter> converters=new LinkedList<>();
    /**
     * 设置从微信接收到的消息
     * @param message 微信消息
     */
     void setMessage(T message);

    /**
     * 添加消息回复器
     * @param converter
     */
     void addConverter(MessageConverter converter);

    /**
     * 获取消息的类型
     * @return
     */
     String getType();
    /**
     *
     * @return 回复微信的消息
     */
     T reply();
}
