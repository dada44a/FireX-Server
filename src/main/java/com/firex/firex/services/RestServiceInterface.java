package com.firex.firex.services;

public interface RestServiceInterface <I>{
    public I create(I data);
    public I update();
    public I read();
    public I delete();
}
