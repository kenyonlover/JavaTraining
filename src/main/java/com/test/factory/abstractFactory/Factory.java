package com.test.factory.abstractFactory;

class Factory implements IFactory{
    public IProduct1 createProduct1() {  
        return new Product1();  
    }  
    public IProduct2 createProduct2() {  
        return new Product2();  
    }  
}  