package com.fow.message.impl;

import com.fow.message.MessageContainer;
import com.fow.message.MessageConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.Reader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractMessageContainer implements MessageContainer<String> {
    protected String message;
    private Reader reader;
    @Override
    public void setMessage(String message) {
        this.message=message;
    }

    @Override
    public void addConverter(MessageConverter converter) {
        converters.add(converter);
        Collections.sort(converters);
    }
    @Override
    public String getType()
    {
        XStream xStream=new XStream(new StaxDriver());
        xStream.fromXML(reader);


    }

    @Override
    public String reply() {
        return null;
    }
}
