package com.wms.warehouseMS.controller;

import com.wms.warehouseMS.util.BarcodeUtil;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/barcode")
public class BarcodeController {
     @GetMapping(value="/{sku}",produces=MediaType.IMAGE_PNG_VALUE)
    public byte[] generateBarcode(@PathVariable String sku) throws Exception{
         System.out.println("sku_value:"+sku);
        var image= BarcodeUtil.generateQRCode(sku);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

}
