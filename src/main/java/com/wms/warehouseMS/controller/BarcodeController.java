package com.wms.warehouseMS.controller;
import com.wms.util.BarcodeUtil;
import lombok.var;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/barcode")
public class BarcodeController {
    @GetMapping("/{sku}")
    public byte[] generateBarcode(@PathVariable String sku) throws Exception {

        var image = BarcodeUtil.generateQRCode(sku);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image,"png",baos);

        return baos.toByteArray();
    }
}
