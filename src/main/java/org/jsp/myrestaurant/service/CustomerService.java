package org.jsp.myrestaurant.service;

import java.util.Random;

import org.jsp.myrestaurant.dao.CustomerDao;
import org.jsp.myrestaurant.dto.Customer;
import org.jsp.myrestaurant.helper.AES;
import org.jsp.myrestaurant.helper.LoginHelper;
import org.jsp.myrestaurant.helper.SendMailLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
@Component
public class CustomerService {

    @Autowired
    CustomerDao dao;

    @Autowired
    SendMailLogic logic;

    public String signup(Customer customer, ModelMap map) {
        Customer customer1 = dao.fetchByEmail(customer.getEmail());
        Customer customer2 = dao.fetchByMobile(customer.getMobile());
        if (customer1 == null && customer2 == null) {
            int otp = new Random().nextInt(100000, 999999);
            customer.setOtp(otp);
            logic.send(customer);
            customer.setPassword(AES.encrypt(customer.getPassword(), "123"));
            dao.save(customer);
            map.put("id", customer.getId());
            return "CustomerVerifyOtp";
        } else {
            map.put("neg", "Email and Phone Number Should not be repeated");
            return "CustomerSignUp";
        }
    }

    public String verifyOtp(int id, int otp, ModelMap map) {
        Customer customer = dao.fetchById(id);
        if (customer.getOtp() == otp) {
            customer.setStatus(true);
            dao.save(customer);
            map.put("pos", "Otp verify Successfully");
            return "CustomerLogin";
        } else {
            map.put("neg", "Otp mismatch");
            map.put("id", customer.getId());
            return "CustomerVerifyOtp";
        }
    }

    public String login(LoginHelper helper, ModelMap map) {
        Customer customer = dao.fetchByEmail(helper.getEmail());
        if (customer == null) {
            map.put("neg", "Invalid Email");
            return "CustomerLogin";
        } else if (AES.decrypt(customer.getPassword(), "123").equals(helper.getPassword())) {
            map.put("pos", "Valid Email");
            return "CustomerHome";
        } else {
            map.put("neg", "Invalid Password");
            return "CustomerLogin";
        }
    }
}
