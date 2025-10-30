package org.sbmicroservice.orders.entity;


import jakarta.persistence.*;
//import org.sbmicroservice.users.entity.Users;

@Entity
@Table(name = "orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ordernum")
    private String ordernum;

    @Column(name = "ordersum")
    private int ordersum;

    @Column(name = "iduser")
    private int iduser;

//    @Column(name = "iduser")
//    private Users iduser;


//    public Orders() { }
//
//    public Orders(int ordersum, Users iduser, String ordernum) {
//        this.iduser = iduser;
//        this.ordernum = ordernum;
//        this.ordersum = ordersum;
//    }

    public Orders() { }

    public Orders(int ordersum, int iduser, String ordernum) {
        this.iduser = iduser;
        this.ordernum = ordernum;
        this.ordersum = ordersum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(int ordersum) {
        this.ordersum = ordersum;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

//    public Users getIduser() {
//        return iduser;
//    }

//    public void setIduser(Users iduser) {
//        this.iduser = iduser;
//    }



    @Override
    public String toString() {
        return "Orders{" +
                "id = " + id +
                ", ordersum = " + ordersum +
                ", ordernum = " + ordernum +
                ", iduser = " + iduser + '\'' +
                '}';
    }
}
