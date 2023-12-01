package ru.netology.kochnev_danil.domain.operation;

import ru.netology.kochnev_danil.domain.Customer;

public class Operation {

    int id;
    int sum;
    String currency;
    String merchant;
    Customer customer;

    public Operation(int id, int sum, String currency, String merchant) {
        this.id = id;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
    }

    public Operation(int id, int sum, String currency, String merchant, Customer customer) {
        this.id = id;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "№:" + id +
                ", sum=" + sum +
                ", currency='" + currency + '\'' +
                ", merchant='" + merchant + '\'' +
                '}';
    }


    public Integer getCustomerId() {
        return customer.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
