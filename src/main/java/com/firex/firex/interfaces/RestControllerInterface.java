package com.firex.firex.interfaces;

import org.springframework.web.bind.annotation.PostMapping;

public interface RestControllerInterface<I> {



    public I create(I data);
    public I update();
    public I read();
    public I delete();
}
