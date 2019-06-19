import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Class to emulate a page table
 */
public class PageTable{
   
	
	Hashtable table;
    LinkedList <Integer> list = new LinkedList<Integer>();
    
    /**
     * Constructor
     *
     * initialize PageTable with 256 items
     */
    public PageTable(){
        this.table = new Hashtable();
        for(int i=0;i<128;i++){
            this.table.put(-i,-1);
            this.list.add(-i);
        }
    }


    /**
     * function to get frame number using page number
     *
     * @param int p_num Page Number to be queried
     * @return int frame number if it's in table, -1 otherwise
     */
    public int get(int p_num){
        if(this.table.containsKey(p_num)) {
        	return (int) this.table.get(p_num);
        } else {
        	return -1;
        }
    }


    /**
     * function to add page number, frame number to PageTable
     *
     * @param p_num int Page number
     * @param f_num int Frame number
     */
    public void add(int p_num, int f_num){
        Integer i =this.list.poll();
        if(i != null) {
        	this.table.remove(i.intValue());
        }
    	
    	
        this.list.add(p_num);
        this.table.put(p_num, f_num);
    }
   


public static void main(String[] args){
    PageTable pt = new PageTable();
    for(int i=0; i<=128; i++){
        pt.add(i,i);
    }
    System.out.println(pt.get(0));
}
}
 
/**
 * class for storing items of PageTable
 *
 * Because Java doesn't have struct, we use this class
 * to emulate struct in C.
 */
class PageTableItem{
    /**
     * variable to store frame number information
     */
    int frameNumber;
    /**
     * variable to store if the frame is in memory
     *
     * not used in this project
     */
    boolean valid;


    /**
     * Constructor
     *
     * @param i int frame number
     * @param b boolean whether it's valid frame
     */
    public PageTableItem(int i, boolean b){
        this.frameNumber = i;
        this.valid = b;
    }


    /**
     * Get the frame number of this PageTable item
     *
     * @return this.frameNumber
     */
    public int getFrameNumber(){
        return this.frameNumber;
    }
}

