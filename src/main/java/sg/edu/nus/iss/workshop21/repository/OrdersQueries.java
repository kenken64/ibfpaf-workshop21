package sg.edu.nus.iss.workshop21.repository;

public interface OrdersQueries {
    public static final String IS_ORDERS_EXIST = 
        "SELECT count(*) as count FROM orders WHERE id = ?";   
}
