package com.fow.util.image.bmp;

import java.util.Arrays;

public class BmpBuilder {
    //
    private byte[] bfType={66,77}; //位图文件的类型，必须为BM(1-2字节）
    private int bfSizeNum=0;
    private byte[] bfSize={0,0,0,0}; //位图文件的大小，以字节为单位（3-6字节，低位在前）
    private byte[] bfReserved1={0,0}; //位图文件保留字，必须为0(7-8字节）
    private byte[] bfReserved2={0,0}; //位图文件保留字，必须为0(9-10字节）
    private int bfOffBitsNum=54;
    private byte[] bfOffBits={54,0,0,0}; //位图数据的起始位置，以相对于位图（11-14字节，低位在前）
    //文件头的偏移量表示，以字节为单位
    private int biSizeNum=40;
    private byte[] biSize={40,0,0,0};//本结构所占用字节数（15-18字节）
    private byte[] biWidth={0,0,0,0};//位图的宽度，以像素为单位（19-22字节）
    private byte[] biHeight={0,0,0,0};//位图的高度，以像素为单位（23-26字节）
    private byte[] biPlanes={1,0};//目标设备的级别，必须为1(27-28字节）
    private int biBitCountNum=1;
    private byte[] biBitCount={1,0};//每个像素所需的位数，必须是1（双色），（29-30字节）
    //4(16色），8(256色）16(高彩色)或24（真彩色）之一
    private byte[] biCompression={0,0,0,0};//位图压缩类型，必须是0（不压缩），（31-34字节）
    //1(BI_RLE8压缩类型）或2(BI_RLE4压缩类型）之一
    private byte[] biSizeImage={0,0,0,0};//位图的大小(其中包含了为了补齐行数是4的倍数而添加的空字节)，以字节为单位（35-38字节）
    private byte[] biXPelsPerMeter={0,0,0,0};//位图水平分辨率，每米像素数（39-42字节）
    private byte[] biYPelsPerMeter={0,0,0,0};//位图垂直分辨率，每米像素数（43-46字节)
    private byte[] biClrUsed={0,0,0,0};//位图实际使用的颜色表中的颜色数（47-50字节）
    private byte[] biClrImportant={0,0,0,0};//位图显示过程中重要的颜色数（51-54字节）


    public BmpBuilder bfSize(int size)
    {
        if(size<0)
            throw new  IllegalArgumentException("图片大小必须大于0");
        bfSizeNum=size;
        integerToBytes(bfSize,4,size);
        return this;
    }
    public BmpBuilder bfOffBits(int off)
    {
        if(off<54)
            throw new  IllegalArgumentException("位图数据起始位置必须大于54");
        bfOffBitsNum=off;
        integerToBytes(bfOffBits,4,off);
        return this;
    }
    public BmpBuilder biSize(int size)
    {
        if(size<40)
            throw new  IllegalArgumentException("位图数据起始位置必须大于40");
        biSizeNum=size;
        integerToBytes(biSize,biSize.length,size);
        return this;
    }
    public BmpBuilder biBitCount(int count)
    {
        if(count!=1||count!=2||count!=4||count!=8||count!=16||count!=32)
            throw new  IllegalArgumentException("每个像素说需要的位数必须为{1,2,4,8,16,32}中选择");
        if(biBitCountNum!=count)
        {
            biBitCountNum=count;
            integerToBytes(biBitCount,biBitCount.length,count);
        }
        return this;
    }
    public BmpBuilder width(int width)
    {
        if(width<0)
            throw new  IllegalArgumentException("图片宽必须大于0");
        integerToBytes(biWidth,4,width);
        return this;
    }
    public BmpBuilder height(int height)
    {
        if(height<0)
            throw new  IllegalArgumentException("图片高必须大于0");
        integerToBytes(biHeight,4,height);
        return this;
    }
    public BmpBuilder biSizeImage(int size)
    {
        if(size<0)
            throw new  IllegalArgumentException("图片大小必须大于0");
        integerToBytes(biSizeImage,biSizeImage.length,size);
        return this;
    }
    public BmpBuilder biXPelsPerMeter(int xMeter)
    {
        if(xMeter<0)
            throw new  IllegalArgumentException("分辨率必须大于0");
        integerToBytes(biXPelsPerMeter,biXPelsPerMeter.length,xMeter);
        return this;
    }
    public BmpBuilder biYPelsPerMeter(int yMeter)
    {
        if(yMeter<0)
            throw new  IllegalArgumentException("分辨率必须大于0");
        integerToBytes(biYPelsPerMeter,biYPelsPerMeter.length,yMeter);
        return this;
    }

    public BmpImage build()
    {
        return new BmpImage(buildFileHeader(),buildImageHeader());
    }
    public byte[] buildFileHeader()
    {
        byte[] header=new byte[14];
        int start=0;
        System.arraycopy(bfType,0,header,start,bfType.length);
        start+=bfType.length;
        System.arraycopy(bfSize,0,header,start,bfSize.length);
        start+=bfSize.length;
        System.arraycopy(bfReserved1,0,header,start,bfReserved1.length);
        start+=bfReserved1.length;
        System.arraycopy(bfReserved2,0,header,start,bfReserved2.length);
        start+=bfReserved2.length;
        System.arraycopy(bfOffBits,0,header,start,bfOffBits.length);
        return header;
    }
    public byte[] buildImageHeader()
    {
        byte[] header=new byte[biSizeNum];
        int start=0;
        System.arraycopy(biSize,0,header,start,biSize.length);
        start+=biSize.length;
        System.arraycopy(biWidth,0,header,start,biWidth.length);
        start+=biWidth.length;
        System.arraycopy(biHeight,0,header,start,biHeight.length);
        start+=biHeight.length;
        System.arraycopy(biPlanes,0,header,start,biPlanes.length);
        start+=biPlanes.length;
        System.arraycopy(biBitCount,0,header,start,biBitCount.length);
        start+=biBitCount.length;
        System.arraycopy(biCompression,0,header,start,biCompression.length);
        start+=biCompression.length;
        System.arraycopy(biSizeImage,0,header,start,biSizeImage.length);
        start+=biSizeImage.length;
        System.arraycopy(biXPelsPerMeter,0,header,start,biXPelsPerMeter.length);
        start+=biXPelsPerMeter.length;
        System.arraycopy(biYPelsPerMeter,0,header,start,biYPelsPerMeter.length);
        start+=biYPelsPerMeter.length;
        System.arraycopy(biClrUsed,0,header,start,biClrUsed.length);
        start+=biClrUsed.length;
        System.arraycopy(biClrImportant,0,header,start,biClrImportant.length);
        return header;
    }
    private void integerToBytes(byte[] bytes,int lenth,int data)
    {
        for(int i=0;i<lenth;i++)
        {
            bytes[i]=(byte)(data % 256);
            data/=256;
        }
    }

    public static void main(String[] args) {
        BmpBuilder builder=new BmpBuilder();
        BmpImage image= builder.biBitCount(32).build();
        System.out.println("fileheader:"+Arrays.toString(image.getFileHeader()));
        System.out.println("imageheader:"+Arrays.toString(image.getImageHeader()));

    }
}
