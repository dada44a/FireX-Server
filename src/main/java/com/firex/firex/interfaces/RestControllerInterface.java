package com.firex.firex.interfaces;

public interface RestControllerInterface<I> {

    public I create(I data);
    public I update();
    public I read();
    public I delete();
}
