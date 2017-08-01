package com.chimu.wine.dao;

import com.chimu.wine.bean.AddressBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    void addAddress(AddressBean addressBean);
    void deleteAddress(Integer id);
    void modifyAddressById(AddressBean addressBean);
    List<AddressBean> getAddressByUid(Integer uid);
    AddressBean getAddressById(Integer id);
    AddressBean getAddressSelectedByUid(Integer uid);
}
