package com.demo.dao;

import com.demo.beans.CustomerInfo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

    @Override
    public List<CustomerInfo> findAllCustomers() {
        //第一种方式
//        return super.getJdbcTemplate().query("SELECT customer_id,first_name,last_name,dob,phone " +
//                "FROM customers  ", new ResultSetExtractor<List<CustomerInfo>>() {
//            @Override
//            public List<CustomerInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
//                List<CustomerInfo> list = new ArrayList<>();
//                CustomerInfo info = null;
//                while (rs.next()) {
//                    return convert2Info(rs);
//                    list.add(info);
//                }
//                return list;
//            }
//        });

//        final List<CustomerInfo> list = new ArrayList<>();
//        super.getJdbcTemplate().query("SELECT customer_id,first_name,last_name,dob,phone " +
//                "FROM customers ", new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet rs) throws SQLException {
//                CustomerInfo info = new CustomerInfo();
//                info.setCustomerId(rs.getInt("customer_id"));
//                info.setFirstName(rs.getString("first_name"));
//                info.setLastName(rs.getString("last_name"));
//                info.setDob(rs.getDate("dob"));
//                info.setPhone(rs.getString("phone"));
//                list.add(info);
//            }
//        });
//
//        return list;

        return super.getJdbcTemplate().query("SELECT customer_id,first_name,last_name,dob,phone FROM customers  "

                //"where first_name like concat('%',?,'%') and dob>? ",
                //new Object[]{"o",//new java.sql.Date(new GregorianCalendar(1963,6,24).getTimeInMillis())},
               ,new RowMapper<CustomerInfo>() {
            @Override
            public CustomerInfo mapRow(ResultSet rs, int i) throws SQLException {
                return convert2Info(rs);
            }
        });


    }

    @Override
    public int count() {

        String sql="select count(*) from customers";
        return super.getJdbcTemplate().queryForObject(sql,int.class);

    }

    @Override
    public CustomerInfo findInfoById(Integer customerId) {
        
        String sql="select customer_id,first_name,last_name,dob,phone  " +
                " from customers where customer_id=?";
        
        return super.getJdbcTemplate().queryForObject(sql, new Object[]{customerId}, new RowMapper<CustomerInfo>() {

            @Override
            public CustomerInfo mapRow(ResultSet rs, int i) throws SQLException {
                return convert2Info(rs);
            }
        });

    }

    @Override
    public int saveInfo(CustomerInfo customerInfo) {
        Integer cstId=this.getJdbcTemplate().queryForObject("select ifnull(max(customer_id)+1,1) from customers",Integer.class);

        int count=this.getJdbcTemplate().update("INSERT INTO customers(customer_id,first_name,last_name,dob,phone) " +
                "VALUES(?,?,?,?,?)",new Object[]{cstId,customerInfo.getFirstName(),customerInfo.getLastName(),customerInfo.getDob(),customerInfo.getPhone()});

        return count;
    }


    public CustomerInfo convert2Info(ResultSet rs) throws SQLException {
        CustomerInfo info = new CustomerInfo();
        info.setCustomerId(rs.getInt("customer_id"));
        info.setFirstName(rs.getString("first_name"));
        info.setLastName(rs.getString("last_name"));
        info.setDob(rs.getDate("dob"));
        info.setPhone(rs.getString("phone"));
        return info;
    }


}
