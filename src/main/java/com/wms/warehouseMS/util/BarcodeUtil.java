package com.wms.warehouseMS.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.var;

import java.awt.image.BufferedImage;

public class BarcodeUtil {

    public static BufferedImage generateQRCode(String text) throws WriterException {

        QRCodeWriter writer = new QRCodeWriter();
        int width = 300;
        int height = 300;

        var bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
            }
        }

        return image;
    }
}