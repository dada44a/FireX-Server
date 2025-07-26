package com.firex.firex.interfaces;

public interface RestServiceInterface <I>{
    public I create(I data);
    public I update();
    public I read();
    public I delete();
}
