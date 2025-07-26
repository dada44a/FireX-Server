package com.firex.firex.interfaces;

import java.util.Map;

public interface RestServiceInterface <I>{
    public I create(I data);
    public I update();
    public I read();
    public Map<String,String> delete(long id);
}
