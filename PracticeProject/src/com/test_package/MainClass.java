package com.test_package;

import javax.swing.JOptionPane;

public class MainClass {
    public static void main(String[] args) {
        // Hello World
        JOptionPane.showMessageDialog(null, "Hello World!");
        System.out.println("Hello World!");

        // Test class from outside file
        TestClass.testCall();

        // Test instance of nested class
        Second second = new Second();

        second.testCall();

        second.x = 1;

        System.out.println("New public X property value: " + second.x);

        second.setY(2);

        System.out.println("New private Y property value: " + second.getY());

        // Test instance of top-level class
        Third third = new Third();

        third.testCall();

        System.out.println("Parent of Third is: " + third.parent);

        // Test instance of top-level class with inheritance
        Fourth fourth = new Fourth();

        fourth.testCall();

        System.out.println("Parent of Fourth is: " + fourth.parent);
    }

    static class Second {
        public int x = 0;

        private int y = 0;

        protected int getY() {
            return y;
        }

        protected void setY(int y) {
            this.y = y;
        }

        public void testCall() {
            System.out.println("Testing nested class...");
            testCallPrivate();
        }

        private void testCallPrivate() {
            System.out.println("Testing private method...");
        }
    }
}

class Third {
    Third() {
        parent = "none";
    }

    protected String parent;

    protected void testCall() {
        System.out.println("Testing top-level class...");
    }
}

class Fourth extends Third {
    protected Fourth() {
        parent = "Third";
    }

    protected void testCall() {
        System.out.println("Testing top-level class which extends Third...");
    }
}