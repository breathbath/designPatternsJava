package com.templatemethod;

public abstract class CoffeineBeverage {

    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }

    protected abstract void addCondiments();

    protected abstract void brew();

    protected boolean customerWantsCondiments(){
        return true;
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
