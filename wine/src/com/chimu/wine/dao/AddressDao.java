package com.chimu.wine.dao;

import com.chimu.wine.bean.AddressBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    void addAddress(AddressBean addressBean);
    void deleteAddress(@Param("is_delete")Integer is_delete, @Param("id")Integer id);
    List<AddressBean> getAddressByUid(Integer uid);
    AddressBean getAddressById(Integer id);
    void modifyAddressById(AddressBean addressBean);
    AddressBean getSelectedByUid(Integer uid);
}
