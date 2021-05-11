package com.wu.greenfarm.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class ImageUtil {
    public static void decodeAndWrite(String encodeText, String path) {
        final Base64.Decoder decoder = Base64.getDecoder();
        byte[] imageBytes = decoder.decode(encodeText);
        ByteArrayInputStream in = new ByteArrayInputStream(imageBytes);
        try {
            BufferedImage bufferedImage = ImageIO.read(in);
            OutputStream outputStream = new FileOutputStream(path);
            ImageIO.write(bufferedImage,"jpg",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到上传图片的文件名
     * @param ownerId
     * @return
     */
    public static String getFileName(int ownerId) {
        //获取当前时间
        Date date = new Date();
        //定义转化为字符串的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
        //将时间转化为类似 2020-02-13 16:01:30 格式的字符串
        String strDate=sdf.format(date);
        String fileName = ownerId + "-" + strDate.replaceAll(" ", "-") + ".jpg";
        return fileName;
    }

    /**
     * 获得图片保存的本地地址
     * @param fileName
     * @return
     */
    public static String getFilePath(String fileName) {
        String filePath = "/Users/WuTao/greenFarmServer/static/farm/" + fileName;
        return filePath;
    }

    public static String getPictureUrl(String subDir, String fileName) {
        return "/static/" + subDir + "/" + fileName;
    }
}
