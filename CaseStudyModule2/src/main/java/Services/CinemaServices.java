package Services;

import Models.Customer;

import java.util.LinkedList;
import java.util.Queue;

public class CinemaServices {
    private Queue<Customer> customerQueue = new LinkedList<>();
    public void addBookingCinema(Customer customer) {
        customerQueue.add(customer);
    }
    public Queue<Customer> getAllBookingCinema() {
        return customerQueue;
    }
}
