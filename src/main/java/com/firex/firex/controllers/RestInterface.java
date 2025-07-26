package com.firex.firex.controllers;

public interface RestInterface<I> {

    public I create(I data);
    public I update();
    public I read();
    public I delete();
}
