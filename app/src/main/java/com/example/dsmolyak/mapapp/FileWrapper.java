package com.example.dsmolyak.mapapp;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Drew on 1/14/2016.
 */
public class FileWrapper {
    InputStream in;
    File file;
    public FileWrapper(InputStream in , File file){
        this.file=file;
        this.in=in;
    }
    public File getFile(){
        return file;
    }
    public InputStream getInputStream(){
        return in;
    }
}
