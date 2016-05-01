package www.cput.za.animalpound.domain;

import java.io.Serializable;

/**
 * Created by Game330 on 2016-04-12.
 */
public class Customer implements Serializable {
    private Long Id;
    private String custName;
    private String custSurname;
    private Adoption adopt;
    //embeded
    private Address adress;


    private Customer() {
    }


    private Customer(Builder build)
    {
        Id = build.Id;
        adopt = build.adopt;
        custName = build.custName;
        custSurname = build.custSurname;
        adress = build.adress;

    }


    public static class Builder{

        private Long Id;
        private String custName;
        private String custSurname;
        private Adoption adopt;
        private Address adress;

        public Builder () {

        }

        public Builder adress (Address addr){
            this.adress = addr;
            return this;
        }
        public Builder id(Long id) {
            this.Id = id;
            return this;
        }

        public Builder custName(String custName) {
            this.custName = custName;
            return this;
        }

        public Builder custSurname(String custSurname) {
            this.custSurname = custSurname;
            return this;
        }
        public Builder adopt(Adoption adopt) {
            this.adopt = adopt;
            return this;
        }

        public Builder customer(Customer cust)
        {
            adopt = cust.getAdopt();
            custName = cust.getCustName();
            custSurname = cust.getCustSurname();
            Id = cust.getID();
            adress = cust.getAdress();
            return this;
        }
        public Builder copy(Customer value)
        {
            this.custName = value.custName;
            this.Id = value.Id;
            this.custSurname = value.custSurname;
            return this;
        }


        public Customer build()
        {
            return new Customer(this);
        }
    }

    public Address getAdress()
    {
        return adress;
    }
    public Long getID()
    {
        return Id;
    }
    public String getCustName() {
        return custName;
    }

    public String getCustSurname() {
        return custSurname;
    }


    public Adoption getAdopt() {
        return adopt;
    }



}
