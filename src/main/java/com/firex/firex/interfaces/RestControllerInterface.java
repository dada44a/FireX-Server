package com.firex.firex.interfaces;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

public interface RestControllerInterface<I> {



    public I create(I data);
    public I update();
    public I read();
    public Map<String,String> delete(long id);
}
