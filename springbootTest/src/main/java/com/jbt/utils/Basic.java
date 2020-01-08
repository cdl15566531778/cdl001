package com.jbt.utils;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Request;
import cn.wanghaomiao.seimi.struct.Response;
import com.jbt.model.Vin;
import org.seimicrawler.xpath.JXDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Crawler(name = "basic")
public class Basic extends BaseSeimiCrawler {

    private static final Logger logger = LoggerFactory.getLogger(Basic.class);

    @Override
    public String[] startUrls() {
        return new String[]{"https://www.cn357.com/notice_list"};
    }

    @Override
    public void start(Response response) {
        JXDocument doc = response.document();
        try {
            List<Object> urls = doc.sel("//div[@class='lotList uiLinkList clear']/a/@href");
//			logger.info("文章数量=[{}]",urls.size());
            for (Object url : urls) {
//				logger.info("url:[{}]","https://www.cn357.com"+url);
                push(Request.build("https://www.cn357.com" + url.toString(), Basic::getUrlTitle));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int count = 0;

    public void getUrlTitle(Response response) {
        JXDocument doc = response.document();
        try {
            List<Object> urls2 = doc.sel("//table[@class='listTable uiLinkList']/tbody/tr/td/a/@href");
            for (Object url : urls2) {
                push(Request.build("https://www.cn357.com" + url.toString(), Basic::getContent));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Vin> getContent(Response response) {
        JXDocument doc = response.document();
        List<Vin> vinList = new ArrayList<>();
        List<Vin> list = new ArrayList<>();
        try {
            List<Object> vehicleModelCodes = doc.sel("//table[@class='listTable itemTable uiLinkList']/tbody/tr[2]/td[2]/text()");
            List<Object> brands = doc.sel("//table[@class='listTable itemTable uiLinkList']/tbody/tr[3]/td[2]/text()");
            if (brands.size() < 0 || brands == null || "".equals(brands.get(0))) {
                List<Object> brandss = doc.sel("//table[@class='listTable itemTable uiLinkList']/tbody/tr[3]/td[2]/a/text()");
                brands.removeAll(brands);
                brands.addAll(brandss);
            }
            if (vehicleModelCodes.size() < 0 || vehicleModelCodes == null || "".equals(vehicleModelCodes.get(0))) {
                List<Object> vehicleModelCodess = doc.sel("//table[@class='listTable itemTable uiLinkList']/tbody/tr[2]/td[2]/a/text()");
                vehicleModelCodes.removeAll(vehicleModelCodes);
                vehicleModelCodes.addAll(vehicleModelCodess);
            }
            List<Object> vins = doc.sel("//table[@class='listTable itemTable uiLinkList']/tbody/tr[11]/td[4]/text()");
            boolean istrue = brands != null && brands.size() > 0 && vins != null && vins.size() > 0;
            if (istrue) {
                if ("".equals(vins.get(0)) == false) {
                    //处理vin码，截取前八位
                    String vinStr = String.valueOf(vins.get(0));
                    String[] vinStrs = vinStr.split(",");
                    for (String vinStr1 : vinStrs) {
                        Vin vin = new Vin();
                        vin.setVehicleModelCode(String.valueOf(vehicleModelCodes.get(0)));
                        vin.setBrand(String.valueOf(brands.get(0)));
                        vin.setVin(vinStr1.substring(0, 8));
                        vinList.add(vin);
                    }

                }
            }
            //去重
            list = vinList.stream().collect(Collectors.collectingAndThen(
                    Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(
                            o -> o.getVin() + ";" + o.getVehicleModelCode()
                    ))), ArrayList::new
            ));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }
}
