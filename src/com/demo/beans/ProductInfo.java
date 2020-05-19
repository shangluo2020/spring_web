package com.demo.beans;

import com.demo.common.ValidGroup1;
import com.demo.common.ValidGroup2;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class ProductInfo {
    @NotNull(groups = ValidGroup2.class)
    private Integer prdId;

    @NotNull(message = "请输入商品名称！", groups = {ValidGroup1.class, ValidGroup2.class})
    @Size(min = 2, message = "商品名称不能少于3个字符！", groups = {ValidGroup1.class, ValidGroup2.class})
    private String prdName;

    private Integer typeId;
    private String desc;
//    private String phone;
//    private Date produceDate;


//    @AssertTrue(message = "生产日期不在有效范围内！")
//    public boolean getProductDateIsVaild() {
//        if (this.produceDate == null) {
//            return true;
//        }
//        Date date1=new GregorianCalendar(2020,0,1).getTime();
//        Date date2=new Date(System.currentTimeMillis());
//
//        return this.produceDate.after(date1)&& this.produceDate.before(date2);
//    }
//
//    public Date getProduceDate() {
//        return produceDate;
//    }
//
//    public void setProduceDate(Date produceDate) {
//        this.produceDate = produceDate;
//    }

    //@NotNull(message = "请输入商品价格！")
    //@Min(value = 0, message = "价格不能小于0元！")
    private Float price;

    public Integer getPrdId() {
        return prdId;
    }

    public void setPrdId(Integer prdId) {
        this.prdId = prdId;
    }

    public String getPrdName() {
        return prdName;
    }

    //    @NotBlank(message = "请输入商品名称！")
//    @Length(min = 2,max = 7,message = "商品名长度必须是2-7之间")
    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    @NotNull
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @NotNull(message = "价格不能为空！")
    @Range(min = 0, max = 70, message = "价格输入不符合要求！请输入0-100的数值！", groups = {ValidGroup1.class, ValidGroup2.class})
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

//    @Pattern(regexp = "1[3789]\\d{9}",message ="{my.pattern.invalid}")
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
}
