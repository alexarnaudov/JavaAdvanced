package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public List<Pet> getData() {
        return data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }

    public GroomingSalon() {
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){

        if(!data.contains(pet)){
            if(this.capacity>this.data.size()){
                this.data.add(pet);
            }
        }

    }

    public boolean remove(String name){
        int indexToRemove = -1;

        for (int i = 0; i < data.size(); i++) {
            Pet pet = data.get(i);
            if(pet.getName().equals(name)){
                indexToRemove = i;
                break;
            }
        }

        if(indexToRemove!=-1){
            data.remove(indexToRemove);
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        Pet pet = null;

        for (Pet e:data) {

            if(!name.equals(owner))
            {
                if(e.getName().equals(name)&&e.getOwner().equals(owner)) pet = e;
            }

        }
        return pet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics(){

        StringBuilder out = new StringBuilder("The grooming salon has the following clients:");

        for (Pet pet: data) {
            out.append(System.lineSeparator());
            out.append(pet.toString());
        }
        return out.toString();
    }

}
