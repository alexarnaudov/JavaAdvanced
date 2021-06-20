package groomingSalon;

public class Pet {
            private String name;
            private int age;
            private String owner;


            //constructor

    public Pet(String name, int age, String owner) {

        if(!name.equals(owner))
        {
            this.name = name;
            this.age = age;
            this.owner = owner;

        }

    }

    //ToString


    @Override
    public String toString() {
        return ""+name+" "+age+" - ("+owner+")";
    }

    //getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOwner() {
        return owner;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
