package com.deepshikhayadav.Foodie;

public class cart_model {


        private int cart_img;
        private String cart_title;
        private int cart_price;
        private int cart_quantity;

        public int getCart_img() {
            return cart_img;
        }

        public void setCart_img(int cart_img) {
            this.cart_img = cart_img;
        }

        public String getCart_title() {
            return cart_title;
        }

        public void setCart_title(String cart_title) {
            this.cart_title = cart_title;
        }

        public int getCart_price() {
            return cart_price;
        }

        public void setCart_price(int cart_price) {
            this.cart_price = cart_price;
        }

        public int getCart_quantity() {
            return cart_quantity;
        }

        public void setCart_quantity(int cart_quantity) {
            this.cart_quantity = cart_quantity;
        }

        public cart_model(int cart_img, String cart_title, int cart_price, int cart_quantity) {
            this.cart_img = cart_img;
            this.cart_title = cart_title;
            this.cart_price = cart_price;
            this.cart_quantity = cart_quantity;
        }

    }
