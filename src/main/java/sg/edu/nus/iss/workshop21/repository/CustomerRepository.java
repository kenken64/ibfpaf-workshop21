package sg.edu.nus.iss.workshop21.repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop21.model.Customer;
import sg.edu.nus.iss.workshop21.model.Orders;

@Repository
public class CustomerRepository implements CustomersQueries, OrdersQueries{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomers(){
        List<Customer> result = new LinkedList<Customer>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_ALL_CUSTOMERS);
        
        while(rs.next()){
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("first_name"));
            c.setLastName(rs.getString("last_name"));
            result.add(c);
        }
        
        return Collections.unmodifiableList(result); 
    }

    public List<Customer>
                getAllCustomerWithPagination(int limit, int offset){
        List<Customer> result = new LinkedList<Customer>();
        final SqlRowSet rs = jdbcTemplate
                        .queryForRowSet(GET_ALL_CUSTOMERS_WITH_PAGINATION, 
                                    limit, offset);
        while(rs.next()){
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("first_name"));
            c.setLastName(rs.getString("last_name"));
            result.add(c);
        }
        return Collections.unmodifiableList(result);
    }

    public Customer getCustomerById(int id){
        Customer c = new Customer();
        final SqlRowSet rs = jdbcTemplate
                        .queryForRowSet(GET_CUSTOMER_BY_ID, id);
        System.out.println("rs: "+rs);
        if(rs.next()){
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("first_name"));
            c.setLastName(rs.getString("last_name"));
        }
        return c;
    }

    public boolean isCustomerExist(int id){
        boolean isExist = false;
        final SqlRowSet rs = jdbcTemplate
                        .queryForRowSet(IS_CUSTOMER_EXIST, id);
        System.out.println("rs: "+rs);
        if(rs.next()){
            int x = rs.getInt("count");
            if(x>0){
                isExist = true;
            }
        }
        return isExist;
    }


    public List<Orders> getCustomerByOrders(int id){
        List<Orders> result = new LinkedList<Orders>();
        final SqlRowSet rs = jdbcTemplate
                    .queryForRowSet(GET_CUSTOMER_BY_ORDER, id);

        while(rs.next()){
            Orders o = new Orders();
            o.setId(rs.getInt("c_id"));
            o.setFirstName(rs.getString("c_fn"));
            o.setLastName(rs.getString("c_ln"));
            o.setTaxRate(rs.getDouble("o_trate"));
            LocalDateTime oDate= (LocalDateTime)
                            rs.getObject("o_odate");
            o.setOrderDate(oDate);
            
            result.add(o);
        }
        return Collections.unmodifiableList(result);
    }
    
    
}
