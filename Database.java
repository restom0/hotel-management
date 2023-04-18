public class Database {
    private Customer[] customerDB;
    private Room[] roomDB;
    private Extra[] extraDB;
    private Receipt[] receiptDB;

    public Database(Customer[] customerDB, Room[] roomDB, Extra[] extraDB, Receipt[] receiptsDB) {
        this.customerDB = customerDB;
        this.roomDB = roomDB;
        this.extraDB = extraDB;
        this.receiptDB = receiptsDB;
    }

    // Customer
    public Customer[] getCustomerDB() {
        return this.customerDB;
    }

    public void setCustomerDB(Customer[] customerDB) {
        this.customerDB = customerDB;
    }

    public void addCustomer(Customer customer) {
        Customer[] temp = new Customer[this.customerDB.length + 1];
        for (int i = 0; i < this.customerDB.length; i++) {
            temp[i] = customerDB[i];
        }
        temp[this.customerDB.length] = customer;
        customerDB = temp;
    }

    public void editCustomer(int index, Customer customer) {
        customerDB[index - 1] = customer;
    }

    public void removeCustomer(Customer customer) {
        Customer[] temp = new Customer[this.customerDB.length - 1];
        for (int i = 0; i < this.customerDB.length; i++) {
            if (customerDB[i].getCustomerId() == customer.getCustomerId()) {
                for (int j = i; j < this.customerDB.length; j++) {
                    temp[j] = customerDB[j + 1];
                }
                break;
            }
            temp[i] = customerDB[i];
        }
    }

    public Customer getCustomer(int index) {
        return customerDB[index - 1];
    }

    public Customer searchCustomer(String name) {
        for (Customer i : this.customerDB) {
            if (name == i.getName()) {
                return i;
            }
        }
        return null;
    }

    // Room
    public Room[] getRoomDB() {
        return this.roomDB;
    }

    public void setRoomDB(Room[] roomDB) {
        this.roomDB = roomDB;
    }

    public void addRoom(Room room) {
        Room[] temp = new Room[this.roomDB.length + 1];
        for (int i = 0; i < this.roomDB.length; i++) {
            temp[i] = roomDB[i];
        }
        temp[this.roomDB.length] = room;
        roomDB = temp;
    }

    public void editRoom(int index, Room room) {
        roomDB[index - 1] = room;
    }

    public void removeRoom(Room room) {
        Room[] temp = new Room[this.roomDB.length - 1];
        for (int i = 0; i < this.roomDB.length; i++) {
            if (roomDB[i].getProperty().getId() == room.getProperty().getId()) {
                for (int j = i; j < this.roomDB.length; j++) {
                    temp[j] = roomDB[j + 1];
                }
                break;
            }
            temp[i] = roomDB[i];
        }
    }

    public Room getRoom(int index) {
        return roomDB[index - 1];
    }

    public Room searchRoom(String name) {
        for (Room i : this.roomDB) {
            if (name == i.getProperty().getName()) {
                return i;
            }
        }
        return null;
    }

    // Extra
    public Extra[] getExtraDB() {
        return this.extraDB;
    }

    public void setExtraDB(Extra[] extraDB) {
        this.extraDB = extraDB;
    }

    public void addExtra(Extra extra) {
        Extra[] temp = new Extra[this.extraDB.length + 1];
        for (int i = 0; i < this.extraDB.length; i++) {
            temp[i] = extraDB[i];
        }
        temp[this.extraDB.length] = extra;
        extraDB = temp;
    }

    public void editExtra(int index, Extra extra) {
        extraDB[index - 1] = extra;
    }

    public void removeExtra(Extra extra) {
        Extra[] temp = new Extra[this.extraDB.length - 1];
        for (int i = 0; i < this.extraDB.length; i++) {
            if (extraDB[i].getName() == extra.getName()) {
                for (int j = i; j < this.extraDB.length; j++) {
                    temp[j] = extraDB[j + 1];
                }
                break;
            }
            temp[i] = extraDB[i];
        }
    }

    public Extra getExtra(int index) {
        return extraDB[index - 1];
    }

    public Extra searchExtra(String name) {
        for (Extra i : this.extraDB) {
            if (name == i.getName()) {
                return i;
            }
        }
        return null;
    }

    // Receipt
    public Receipt[] getReceiptDB() {
        return this.receiptDB;
    }

    public void setreceiptDB(Receipt[] receiptDB) {
        this.receiptDB = receiptDB;
    }

    public void addreceipt(Receipt receipt) {
        Receipt[] temp = new Receipt[this.receiptDB.length + 1];
        for (int i = 0; i < this.receiptDB.length; i++) {
            temp[i] = receiptDB[i];
        }
        temp[this.receiptDB.length] = receipt;
        receiptDB = temp;
    }

    public void editreceipt(int index, Receipt receipt) {
        receiptDB[index - 1] = receipt;
    }

    public void removereceipt(Receipt receipt) {
        Receipt[] temp = new Receipt[this.receiptDB.length - 1];
        for (int i = 0; i < this.receiptDB.length; i++) {
            if (receiptDB[i].getRecreiptId() == receipt.getRecreiptId()) {
                for (int j = i; j < this.receiptDB.length; j++) {
                    temp[j] = receiptDB[j + 1];
                }
                break;
            }
            temp[i] = receiptDB[i];
        }
    }

    public Receipt getreceipt(int index) {
        return receiptDB[index - 1];
    }

    public Receipt searchreceipt(int id) {
        for (Receipt i : this.receiptDB) {
            if (id == i.getRecreiptId()) {
                return i;
            }
        }
        return null;
    }
}
