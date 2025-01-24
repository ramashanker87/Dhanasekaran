package com.rama.app.custom;

public class TestNameValidation {
    public static void main(String[] args) {
        TestNameValidation test=new TestNameValidation();
        try{
            test.validateName("Sekar");
        }catch(NameValidationException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Name Validation Exception Executed");
        }
    }

    public void validateName(String name) throws NameValidationException {
        if (name != "Dhana") {
            throw new NameValidationException("Name must be Dhana.");
        }
    }
}