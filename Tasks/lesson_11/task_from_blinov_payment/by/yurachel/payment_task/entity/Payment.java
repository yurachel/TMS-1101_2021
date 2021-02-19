package Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.entity;

import java.util.*;

public class Payment {
    private Customer customer;
    private List<String> banks;
    private Map<String, Integer> prices;
    private boolean isOk;

    {
        prices = new HashMap<>();
        banks = new ArrayList<>(Arrays.asList("AlfaBank", "BelarusBank", "BelGazPromBank", "BelWebBank"));
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public List<String> getBanks() {
        return banks;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<String, Integer> getPrices() {
        return prices;
    }




    @Override
    public String toString() {
        return "Information about payment: " + customer + "\nbanks = " + banks +
                ", prices = " + prices + ".";
    }

// Создаем внутренний класс

    public class Customer {
        private String bankName;
        private long bankAccountName;
        private boolean isAvailable;
        private int amountOfMoney;

        public String getBankName() {
            return bankName;
        }

        public long getBankAccountName() {
            return bankAccountName;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public int getAmountOfMoney() {
            return amountOfMoney;
        }

        public void setAmountOfMoney(int amountOfMoney) {
            this.amountOfMoney = amountOfMoney;
        }

        public Customer(String bankName, long bankAccountName, boolean isAvailable, int amountOfMoney) {
            this.bankName = bankName;
            this.bankAccountName = bankAccountName;
            this.isAvailable = isAvailable;
            this.amountOfMoney = amountOfMoney;
        }

        @Override
        public String toString() {
            return "Customer: " +
                    "bankName = " + bankName + ", bankAccountName = " + bankAccountName +
                    ", isAvailable = " + isAvailable + ", amountOfMoney = " + amountOfMoney
                    ;
        }
    }
}