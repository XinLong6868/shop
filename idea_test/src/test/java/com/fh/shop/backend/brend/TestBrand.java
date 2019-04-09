package com.fh.shop.backend.brend;

        import com.fh.shop.backend.biz.brand.IBrandService;
        import com.fh.shop.backend.po.brand.BrandText;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBrand {
        //测试增加（main方法）
        public static void main(String[] args) {
            String[] arr = {"classpath:spring/spring-common.xml"};
            ClassPathXmlApplicationContext cPXAC = new ClassPathXmlApplicationContext(arr);
            IBrandService iBrandServiceImpl = (IBrandService) cPXAC.getBean("iBrandService");
            BrandText brandText = new BrandText();
            brandText.setBrandName("iphone X666");
            iBrandServiceImpl.addBrand(brandText);
        }

}
