package com.fh.shop.backend.controller.product;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.*;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fh.shop.backend.annnotation.Log;
import com.fh.shop.backend.biz.photo.IPhotoService;
import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.po.brand.BrandText;
import com.fh.shop.backend.po.photo.PhotoInfo;
import com.fh.shop.backend.util.DateUtil;
import com.fh.shop.backend.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 *
 * <pre>项目名称：shop-admin-v2    
 * 类名称：ProductController    
 * 类描述：    
 * 创建人：辛龙       2427776882@qq.com    
 * 创建时间：2018年12月23日 下午8:23:00    
 * 修改人：辛龙       2427776882@qq.com     
 * 修改时间：2018年12月23日 下午8:23:00    
 * 修改备注：       
 * @version </pre>
 */
//<bean id="productController" class="com.fh.shop.backend.controller.product.ProductController">
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fh.shop.backend.biz.brand.IBrandService;
import com.fh.shop.backend.biz.product.IProductService;
import com.fh.shop.backend.controller.BaseController;
import com.fh.shop.backend.po.product.Product;

import net.sf.json.JSONObject;


@Controller
public class ProductController extends BaseController {
    @Autowired
    @Qualifier("iProductService")
    private IProductService iProductService;
    @Autowired
    @Qualifier("iBrandService")
    private IBrandService iBrandService;

    @Resource(name = "photoService")
    private IPhotoService photoService;

    /**
     * <pre>toAddProduct(跳转到增加页面)
     * 创建人：辛龙       2427776882@qq.com
     * 创建时间：2018年12月23日 下午8:27:44
     * 修改人：辛龙       2427776882@qq.com
     * 修改时间：2018年12月23日 下午8:27:44
     * 修改备注：
     * @return</pre>
     */
    @RequestMapping("/product/toAddProduct")
    public String toAddProduct() {

        return "product/addProduct";
    }

    /**
     * <pre>addProduct(增加后跳转到查询页面)
     * 创建人：辛龙       2427776882@qq.com
     * 创建时间：2018年12月23日 下午8:30:09
     * 修改人：辛龙       2427776882@qq.com
     * 修改时间：2018年12月23日 下午8:30:09
     * 修改备注：
     * @param product
     * @return</pre>
     */
    @RequestMapping("/product/addProduct")
    @Log(value = "添加产品")
    public String addProduct(Product product, @RequestParam MultipartFile[] productChildImage, @RequestParam MultipartFile productImage, HttpServletRequest request) {
        //--------------上传文件---------

        //将本地硬盘上的文件上传到服务器的硬盘长

        //将已经上传到临时文件夹下的文件拷贝到指定的目录下

        //图片经常放项目的在web文件夹下（注意：编译部署后的）
        try {
            InputStream inputStream = productImage.getInputStream();
            String originalFilename = productImage.getOriginalFilename();
            //参数应该是相对于编译部署后的项目的web文件夹【根目录,绝对路径】
            String reqPath = request.getServletContext().getRealPath("/images");
            //获取项目编译部署后的的路径
            //System.out.println(reqPath);
            String uploadeFileName = FileUtil.copyFile(inputStream, originalFilename, reqPath);
            //将路径信息(相对路径)保存到数据库的表中
            product.setProductImagePath("/images/" + uploadeFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //增加产品
        iProductService.addProduct(product);

        //--------------上传子图图片---------

        //将本地硬盘上的文件上传到服务器的硬盘长

        //将已经上传到临时文件夹下的文件拷贝到指定的目录下

        //图片经常放项目的在web文件夹下（注意：编译部署后的）
        try {
            for (int i = 0; i < productChildImage.length; i++) {
                MultipartFile multipartFile = productChildImage[i];
                InputStream inputStream = multipartFile.getInputStream();
                String originalFilename = multipartFile.getOriginalFilename();
                //参数应该是相对于编译部署后的项目的web文件夹【根目录,绝对路径】
                String reqPath = request.getServletContext().getRealPath("/images");
                //获取项目编译部署后的的路径
                String uploadeFileName = FileUtil.copyFile(inputStream, originalFilename, reqPath);
                //将路径信息(相对路径)保存到数据库的表中
                //product.setProductImagePath("/images/"+uploadeFileName);
                PhotoInfo photoInfo = new PhotoInfo();
                photoInfo.setPhotoPath("/images/" + uploadeFileName);
                photoInfo.getProduct().setId(product.getId());
                photoService.addPhotoInfo(photoInfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/product/tolist.action";
    }

    //跳转到查询
    @RequestMapping("product/tolist")
    public String tolist() {
        return "/product/datatable";
    }

    /**
     * <pre>listProduct(普通查询)
     * 创建人：辛龙       2427776882@qq.com
     * 创建时间：2018年12月25日 下午3:35:53
     * 修改人：辛龙       2427776882@qq.com
     * 修改时间：2018年12月25日 下午3:35:53
     * 修改备注：
     * @param
     * @return</pre>
     */
    @RequestMapping("product/list")
    @ResponseBody
    public ServerResponse listProduct(Integer start,
                                      Integer length,
                                      Integer draw,
                                      Product product,
                                      HttpServletRequest request) {
        //获取前台传过来的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
       //构建datatable所需要的数据
        DataTableResult data = iProductService.buildProductDataTable(start, length, draw, product, parameterMap);
        //返回结果
        return ServerResponse.success(data);
    }


    /**
     * <pre>deleteProductID(单个删除)
     * 创建人：辛龙       2427776882@qq.com
     * 创建时间：2018年12月26日 下午3:35:14
     * 修改人：辛龙       2427776882@qq.com
     * 修改时间：2018年12月26日 下午3:35:14
     * 修改备注：
     * @param id</pre>
     */
    @RequestMapping("deleteProductID")
    @ResponseBody
    @Log("删除产品")
    public ServerResponse deleteProductID(Integer id) {
        iProductService.deleteProductID(id);
        return ServerResponse.success();
    }

    /**
     * <pre>deleteBatchProduct(批量删除)
     * 创建人：辛龙       2427776882@qq.com
     * 创建时间：2018年12月26日 下午3:38:24
     * 修改人：辛龙       2427776882@qq.com
     * 修改时间：2018年12月26日 下午3:38:24
     * 修改备注：
     * @param ids
     * @return</pre>
     */
    @RequestMapping("deleteBatchProduct")
    public void deleteBatchProduct(String ids, HttpServletResponse response) {
        Map result = new HashMap<String, Object>();
        iProductService.deleteBatchProduct(ids);
        result.put("status", "ok");
        //将Java对象转换成json格式的字符串json-lib
        String json = JSONObject.fromObject(result).toString();
        //向客户端发出响应
        outJson(json, response);
    }

    /**
     * <pre>findproduct(回填)
     * 创建人：辛龙       2427776882@qq.com
     * 创建时间：2018年12月26日 下午9:02:52
     * 修改人：辛龙       2427776882@qq.com
     * 修改时间：2018年12月26日 下午9:02:52
     * 修改备注：
     * @param id
     * @return</pre>
     */
    @RequestMapping("findproduct")
    public ModelAndView findproduct(Integer id, ModelMap map, String images, String Path) {
        ModelAndView modelAndView = new ModelAndView("product/update");
        //获取产品信息
        Product product = iProductService.findproduct(id);
        //获取子图信息
        List<PhotoInfo> photoList = photoService.findProductList(id);
        modelAndView.addObject("photoList", photoList);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    /**
     * <pre>updateProduct(修改)
     * 创建人：辛龙       2427776882@qq.com
     * 创建时间：2018年12月26日 下午9:06:11
     * 修改人：辛龙       2427776882@qq.com
     * 修改时间：2018年12月26日 下午9:06:11
     * 修改备注：
     * @param product
     * @return</pre>
     */
    @RequestMapping("/product/updateProduct")
    @Log(value = "修改产品")
    public String updateProduct(Product product, @RequestParam MultipartFile[] productChildImage, @RequestParam MultipartFile productImage, HttpServletRequest request, String lookIds, String lookPaths) {
        if (productImage.getSize() > 0) {
            //删除旧图片
            String productImagePath = product.getProductImagePath();
            String realPath = request.getServletContext().getRealPath(productImagePath);
            File file = new File(realPath);
            if (file.exists()) {
                file.delete();
            }
            //增加新图片
            try {
                InputStream inputStream = productImage.getInputStream();
                String originalFilename = productImage.getOriginalFilename();
                //参数应该是相对于编译部署后的项目的web文件夹【根目录,绝对路径】
                String reqPath = request.getServletContext().getRealPath("/images");
                //重新拷贝新上传的图片
                String uploadeFileName = FileUtil.copyFile(inputStream, originalFilename, reqPath);
                //更新表里面的路径信息
                product.setProductImagePath("/images/" + uploadeFileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //更新数据库中的路径信息
        iProductService.updateProduct(product);
        //--------------上传子图图片---------

        //将本地硬盘上的文件上传到服务器的硬盘长

        //将已经上传到临时文件夹下的文件拷贝到指定的目录下

        //图片经常放项目的在web文件夹下（注意：编译部署后的）
        if (productChildImage[0].getSize() > 0) {
            try {
                for (int i = 0; i < productChildImage.length; i++) {
                    MultipartFile multipartFile = productChildImage[i];
                    InputStream inputStream = multipartFile.getInputStream();
                    String originalFilename = multipartFile.getOriginalFilename();
                    //参数应该是相对于编译部署后的项目的web文件夹【根目录,绝对路径】
                    String reqPath = request.getServletContext().getRealPath("/images");
                    //获取项目编译部署后的的路径
                    String uploadeFileName = FileUtil.copyFile(inputStream, originalFilename, reqPath);
                    //将路径信息(相对路径)保存到数据库的表中
                    //product.setProductImagePath("/images/"+uploadeFileName);
                    PhotoInfo photoInfo = new PhotoInfo();
                    photoInfo.setPhotoPath("/images/" + uploadeFileName);
                    photoInfo.getProduct().setId(product.getId());
                    if (productChildImage[0].getSize() > 0) {
                        photoService.addPhotoInfo(photoInfo);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


				/*判断不为空的时候删除  如果想先删除数据库中的，就先传id，
				如果想先删除服务器上的，就先传path，两个都需要判断删除*/
        if (StringUtils.isNotEmpty(lookPaths)) {
            String[] pathArr = lookPaths.split(",");
            /*liuyumeng 是前台传过来后来分割完的。*/
            for (String liuyumeng : pathArr) {
                String realPath2 = request.getSession().getServletContext().getRealPath(liuyumeng);
                /*删除文件夹里的*/
                File file = new File(realPath2);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        //判断数据库中的
        if (StringUtils.isNotEmpty(lookIds)) {
            //把数组放到list集合中
            List<Integer> idsList = new ArrayList<Integer>();
            //分割一下
            String[] split = lookIds.split(",");
            //遍历循环数组  数据库中的图片id
            for (String id : split) {
                idsList.add(Integer.parseInt(id));
            }
            /*这应该是imageService*/
            photoService.deleteChildImage(idsList);
        }

        //修改完后重定向到查询展示界面
        return "redirect:/product/tolist.action";
    }


    /**
     * poi导出Excel
     */

    @RequestMapping("/product/exportExcel")
    public void exportExcel(Product product, HttpServletResponse response) {
        //查询符合条件的商品数据
        List<Product> productList = iProductService.findProductList(product);
        //将其转换为exxel格式即workbook
        XSSFWorkbook workbook = buildWoorkBook(productList);
        //下载
        FileUtil.excelDownload(workbook, response);
    }

    private XSSFWorkbook buildWoorkBook(List<Product> productList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        //构建sheet
        buildSheet(productList, workbook);
        return workbook;
    }

    private void buildSheet(List<Product> productList, XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("产品表");

        //构建大标题
        buildTitle(sheet, workbook);
        //构建表头
        buildHeaer(sheet);
        //创建表体
        buildBody(productList, sheet, workbook);

    }

    private XSSFCellStyle buildTitleStyle(XSSFWorkbook workbook) {
        //构建大标题的样式
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置标题字体的大小
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        //大小
        font.setFontHeightInPoints((short) 28);
        //颜色
        font.setColor(HSSFColor.RED.index);
        cellStyle.setFont(font);
        //背景色
        cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        return cellStyle;
    }

    private void buildTitle(XSSFSheet sheet, XSSFWorkbook workbook) {
        XSSFRow row = sheet.createRow(3);
        XSSFCell cell = row.createCell(7);
        cell.setCellValue("商品展示列表");
        //firstRow 区域中第一个单元格的行号
        //lastRow 区域中最后一个单元格的行号
        //firstCol 区域中第一个单元格的列号
        //lastCol 区域中最后一个单元格的列号
        CellRangeAddress cellRangeAddress = new CellRangeAddress(3, 5, 7, 11);
        sheet.addMergedRegion(cellRangeAddress);
        //设置标题样式
        XSSFCellStyle cellStyle = buildTitleStyle(workbook);
        //设置个样式
        cell.setCellStyle(cellStyle);

    }

    private void buildBody(List<Product> productList, XSSFSheet sheet, XSSFWorkbook wb) {
        int startRow = 7;
        int startCol = 7;
        XSSFCellStyle cellDate = wb.createCellStyle();
        cellDate.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        for (int i = 0; i < productList.size(); i++) {
            Product productInfo = productList.get(i);
            XSSFRow row = sheet.createRow(i + startRow);
            //商品名称
            XSSFCell productNameCell = row.createCell(startCol);
            productNameCell.setCellValue(productInfo.getProductName());
            //商品价格
            XSSFCell priceCell = row.createCell(startCol + 1);
            priceCell.setCellValue(productInfo.getProductprivace());
            //商品品牌名称
            XSSFCell brandNameCell = row.createCell(startCol + 2);
            brandNameCell.setCellValue(productInfo.getBrandText().getBrandName());
            //商品录入时间
						/*XSSFCell entryTimeCell = row.createCell(3);
						entryTimeCell.setCellValue(productInfo.getCreateTime());
						entryTimeCell.setCellStyle(cellDate);
						//有关于时间类型转化
						XSSFCellStyle cellDate = workbook.createCellStyle();
						cellDate.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd hh:mm:ss"));
						*/
            XSSFCell entryTimeCell = row.createCell(startCol + 3);
            entryTimeCell.setCellValue(productInfo.getCreateTime());
            entryTimeCell.setCellStyle(cellDate);
            //商品创建时间
						/*XSSFCell updateTimeCell = row.createCell(4);
						updateTimeCell.setCellValue(productInfo.getUpdateTime());
						updateTimeCell.setCellStyle(cellDate);*/
            XSSFCell updateTimeCell = row.createCell(startCol + 4);
            updateTimeCell.setCellValue(productInfo.getUpdateTime());
            updateTimeCell.setCellStyle(cellDate);
        }
    }

    private void buildHeaer(XSSFSheet sheet) {
        String[] headers = {"产品名", "产品价格", "产品品牌名", "产品录入时间", "产品创建时间"};
        XSSFRow title = sheet.createRow(6);
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];
            XSSFCell productNameTitle = title.createCell(i + 7);
            productNameTitle.setCellValue(header);
        }
    }

    //PoI根据品牌导出Excel
    @RequestMapping("/product/exportExcelByBrandText")
    public void exportExcelByBrandText(Product product, HttpServletResponse response) {
        //根据品牌查询出符合条件的数据
        List<BrandText> bradTextList = iBrandService.findBradTextList();
        XSSFWorkbook wb = new XSSFWorkbook();
        //调整格式（时间）
        XSSFCellStyle cellDate = wb.createCellStyle();
        cellDate.setDataFormat(wb.createDataFormat().getFormat("yyyy-MM-dd hh:mm:ss"));
        Integer brandId = product.getBrandText().getId();
        //将数据转化成指定的格式【workBo	ok】{word,pdf...}
        for (BrandText brandText : bradTextList) {
            List<Product> productList = null;
            if (brandId == -1) {
                //核心代码
                product.getBrandText().setId(brandText.getId());
                //获取各个品牌对应的产品列表
                productList = iProductService.findProductList(product);
            } else {
                //获取各个品牌对应的产品列表
                if (brandText.getId() == product.getBrandText().getId()) {

                    productList = iProductService.findProductList(product);
                } else {
                    //返回个空的List集合
                    productList = new ArrayList<Product>();
                }

            }
            //创建品牌sheet
            XSSFSheet sheet = wb.createSheet(brandText.getBrandName() + "【" + productList.size() + "】");
            //内容
            XSSFRow title = sheet.createRow(0);
            XSSFCell productNameTitle = title.createCell(0);
            productNameTitle.setCellValue("产品名");
            XSSFCell productPriceTitle = title.createCell(1);
            productPriceTitle.setCellValue("产品价格");
            XSSFCell brandNameTitle = title.createCell(2);
            brandNameTitle.setCellValue("产品品牌名");
            XSSFCell productEntryTimeTitle = title.createCell(3);
            productEntryTimeTitle.setCellValue("产品录入时间");
            XSSFCell productUpdateTimeTitle = title.createCell(4);
            productUpdateTimeTitle.setCellValue("产品创建时间");

            for (int i = 0; i < productList.size(); i++) {
                Product productInfo = productList.get(i);
                XSSFRow row = sheet.createRow(i + 1);
                //商品名称
                XSSFCell productNameCell = row.createCell(0);
                productNameCell.setCellValue(productInfo.getProductName());
                //商品价格
                XSSFCell priceCell = row.createCell(1);
                priceCell.setCellValue(productInfo.getProductprivace());
                //商品品牌名称
                XSSFCell brandNameCell = row.createCell(2);
                brandNameCell.setCellValue(productInfo.getBrandText().getBrandName());
                //商品录入时间
                XSSFCell entryTimeCell = row.createCell(3);
                entryTimeCell.setCellValue(productInfo.getCreateTime());
                entryTimeCell.setCellStyle(cellDate);
                //商品创建时间
                XSSFCell updateTimeCell = row.createCell(4);
                updateTimeCell.setCellValue(productInfo.getUpdateTime());
                updateTimeCell.setCellStyle(cellDate);
            }
        }
        //下载
        FileUtil.excelDownload(wb, response);
    }

}
