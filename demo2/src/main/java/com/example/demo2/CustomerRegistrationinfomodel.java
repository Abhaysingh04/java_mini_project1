package com.example.demo2;

public class CustomerRegistrationinfomodel {


        int CUSTOMER_ID ;
        String CUSTOMER_NAME;
        String CUSTOMER_Email;

        int CUSTOMER_Ph_NO;

        String CUSTOMER_ID_PROOF;

        public CustomerRegistrationinfomodel(String Cust_name, int Cust_Cont , String Cust_email, String Cust_Adhar, int Cust_custId){

            this.CUSTOMER_ID= Cust_custId;
            this.CUSTOMER_NAME= Cust_name;
            this.CUSTOMER_Email=Cust_email;
            this.CUSTOMER_Ph_NO= (Cust_Cont);
            this.CUSTOMER_ID_PROOF= (Cust_Adhar);

        }


        public Integer getCUSTOMER_ID() {
            return CUSTOMER_ID;
        }

        public String getCUSTOMER_NAME() {
            return CUSTOMER_NAME;
        }
        public String getCUSTOMER_Email() {
            return CUSTOMER_Email;
        }


        public Integer getCUSTOMER_Ph_NO() {
            return CUSTOMER_Ph_NO;
        }

        public String getCUSTOMER_ID_PROOF() {
            return CUSTOMER_ID_PROOF;}



        public void setCUSTOMER_ID(Integer CUSTOMER_ID) {
            CUSTOMER_ID = CUSTOMER_ID;
        }

        public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
            CUSTOMER_NAME = CUSTOMER_NAME;
        }
        public void setCUSTOMER_Email(String CUSTOMER_Email) {
            CUSTOMER_Email = CUSTOMER_Email;
        }


        public void setCUSTOMER_Ph_NO(Integer CUSTOMER_Ph_NO ) {
            CUSTOMER_Ph_NO = CUSTOMER_Ph_NO;
        }

        public void setCUSTOMER_ID_PROOF(String CUSTOMER_ID_PROOF) {
            CUSTOMER_ID_PROOF = CUSTOMER_ID_PROOF;
        }


}
