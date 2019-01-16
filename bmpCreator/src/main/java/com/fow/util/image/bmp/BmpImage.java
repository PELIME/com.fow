package com.fow.util.image.bmp;

import java.io.*;

public class BmpImage {
    private byte[] fileHeader;
    private byte[] imageHeader;

    private byte[] body;
    boolean useInnerBody=false;
    File outFile=null;

    public BmpImage(byte[] fileHeader, byte[] imageHeader) {
        this.fileHeader = fileHeader;
        this.imageHeader = imageHeader;
    }

    public void setOutFile(File out) {
        if(!out.exists()) {
            try {
                out.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.outFile = out;
    }

    public int create()
    {
        if(!useInnerBody||outFile==null)
        {
            return -1;
        }
        try {
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(outFile));
            bos.write(fileHeader);
            bos.write(imageHeader);
            bos.write(body);
            bos.close();
            return 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public byte[] getFileHeader() {
        return fileHeader;
    }

    public void setFileHeader(byte[] fileHeader) {
        this.fileHeader = fileHeader;
    }

    public byte[] getImageHeader() {
        return imageHeader;
    }

    public void setImageHeader(byte[] imageHeader) {
        this.imageHeader = imageHeader;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
