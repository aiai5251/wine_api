package com.chimu.wine.service;

import com.chimu.utils.tools.CMString;
import com.chimu.wine.bean.AddressBean;
import com.chimu.wine.dao.AddressDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressDao addressDao;
    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public void addAddress(AddressBean addressBean) {
        addressDao.addAddress(addressBean);
    }

    public void deleteAddress(Integer id) {
        addressDao.deleteAddress(id);
    }

    public List<AddressBean> getAddressByUid(Integer uid) {
        return addressDao.getAddressByUid(uid);
    }

    public AddressBean getAddressById(Integer id) {
        return addressDao.getAddressById(id);
    }

    public void modifyAddressById(AddressBean addressBean) {
        addressDao.modifyAddressById(addressBean);
    }

    public AddressBean getAddressSelectedByUid(Integer uid) {
        return addressDao.getAddressSelectedByUid(uid);
    }
}
