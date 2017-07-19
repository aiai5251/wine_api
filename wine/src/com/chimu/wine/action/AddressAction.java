package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.tools.CMString;
import com.chimu.wine.bean.AddressBean;
import com.chimu.wine.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/wine")
public class AddressAction extends BaseAction {
    @Autowired()
    private AddressService addressService;

    @RequestMapping(value = "/address_add")
    @ResponseBody
    public Map<String, Object> addAddress(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();

        String uid = request.getParameter("uid");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");

        List<AddressBean> addressList = addressService.getAddressByUid(Integer.parseInt(uid));
        AddressBean addressBean = new AddressBean();
        addressBean.setUid(Integer.parseInt(uid));
        addressBean.setName(name);
        addressBean.setTel(tel);
        addressBean.setAddress(address);
        if (addressList.size() == 0) {
            // 第一次添加就是默认地址，默认选中
            addressBean.setIs_default(1);
            addressBean.setIs_selected(1);
        } else {
            addressBean.setIs_default(0);
            addressBean.setIs_selected(0);
        }
        addressService.addAddress(addressBean);
        map.put("data", addressBean);
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "address_modify")
    @ResponseBody
    public Map<String, Object> modifyAddress(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");

        AddressBean addressBean = new AddressBean();
        addressBean.setId(Integer.parseInt(id));
        addressBean.setName(name);
        addressBean.setTel(tel);
        addressBean.setAddress(address);
        addressService.modifyAddressById(addressBean);
        map.put("data", addressBean);
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/address_default")
    @ResponseBody
    public Map<String, Object> defaultAddress(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String uid = request.getParameter("uid");
        String id = request.getParameter("id");
        Map<String, Object> map = new HashMap<>();
        if (CMString.isValid(id) && CMString.isValid(uid)) {
            // 获取所有的地址，全部修改为0
            List<AddressBean> addressList = addressService.getAddressByUid(Integer.parseInt(uid));
            for (AddressBean addressBean : addressList) {
                addressBean.setIs_default(0);
                addressService.modifyAddressById(addressBean);
            }

            // 设置默认地址
            AddressBean addressBean = addressService.getAddressById(Integer.parseInt(id));
            addressBean.setIs_default(1);
            addressService.modifyAddressById(addressBean);
            map.put("data", addressBean);
        } else {
            return super.configResponseMap(map, 0);
        }
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/address_selected")
    @ResponseBody
    public Map<String, Object> selectedAddress(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String uid = request.getParameter("uid");
        String id = request.getParameter("id");
        Map<String, Object> map = new HashMap<>();
        if (CMString.isValid(id) && CMString.isValid(uid)) { //设置为默认
            // 获取所有的地址，全部选中设置为0
            List<AddressBean> addressList = addressService.getAddressByUid(Integer.parseInt(uid));
            for (AddressBean addressBean : addressList) {
                addressBean.setIs_selected(0);
                addressService.modifyAddressById(addressBean);
            }

            // 设置选中地址
            AddressBean addressBean = addressService.getAddressById(Integer.parseInt(id));
            addressBean.setIs_selected(1);
            addressService.modifyAddressById(addressBean);
            map.put("data", addressBean);
        } else {
            return super.configResponseMap(map, 0);
        }
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "address_delete")
    @ResponseBody
    public Map<String, Object> deleteAddress(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String id = request.getParameter("id");
        Map<String, Object> map = new HashMap<>();
        addressService.deleteAddress(1, Integer.parseInt(id));
        return super.configResponseMap(map, 1);
    }

}
