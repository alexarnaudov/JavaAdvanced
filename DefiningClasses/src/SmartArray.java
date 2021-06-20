public class SmartArray {
    public static final int INITIAL_CAPACITY = 4;
    private int size;
    private int capacity;
    private int[] data;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void resize(){
        this.capacity*=2;
        int[] copy = new int[this.capacity];

        for (int i = 0; i < this.data[i]; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }

    public void add(int element){
        if(this.size==this.capacity) this.resize();

        this.data[this.size++] = element;
    }

    public int get(int index){
        checkIndex(index);
        return this.data[index];
    }

    public void checkIndex(int index){
        if(index<0||index>=this.size){
            String message = String.format("Index %d is out of bound for length %d",
                    index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public void shift(int index){
        for (int i = index; i < this.size-1; i++) {
            this.data[i] = this.data[i+1];
        }
        this.data[size-1] = 0;
    }

    public void shrink(){
        this.capacity/=2;
        int[] copy = new int[this.capacity];

        for (int i = 0; i < this.size; i++) {
            copy[i] = this.data[i];
        }
        this.data=copy;
    }

    public int remove(int index){
        checkIndex(index);
        int element = this.data[index];
        shift(index);
        this.size--;
        if(this.size<=this.capacity/4){
            shrink();
        }
return element;
    }

    public void shiftRight(int index){
        for (int i = this.size-1; i >index ; i--) {
this.data[i] = this.data[i-1];
        }
    }

    public void add(int index, int element){
        checkIndex(index);

        if(index==this.size-1){
            add(this.data[this.size-1]);
            this.data[this.size-2] = element;
        }else{
            this.size++;
            shiftRight(index);
            this.data[index]=element;
        }
    }
}
