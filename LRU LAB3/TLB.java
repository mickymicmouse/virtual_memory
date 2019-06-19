import java.util.*;
import java.lang.*;


public class TLB{


        /**
         * Hashtable table
         * used to implement the TLB
         */
    Hashtable table;
    LinkedList <Integer> list = new LinkedList<Integer>();


    public TLB(){
        this.table = new Hashtable();
        for(int i=0; i<16; i++){
            this.table.put(-i, -1); 
            this.list.add(-i); 
        }
    }


        /**
         * function of get
         * 
         * @param p_num        page num
         */
    public int get(int p_num){
        if(this.table.containsKey(p_num)){ // 이 테이블이(tlb테이블) page number를 가지고 있으면, 그 값을 반환
            return (int) this.table.get(p_num); //페이지 넘버와 관련된 테이블 값 즉 f_num을 반환
        }
        else{
            return -1; //아니면 1을반환
        }
    }


        /**
         * function of put
         * 
         * @param p_num                page number
         * @param f_num                frame number
         */
    public void put(int p_num, int f_num){ 
        // we need to do two things: 
        // 1. delete the oldest data in TLB 
        // 2. insert new data 
        // 
        // oldest is determined by the Queue this.list #리스트로 오래된것이 결정되니까... 언제 들어왔는지 판단하는 리스트가 되겠지, 16개의 TLB 
    	//리스트는 언제들어갔는지를 판단, table은 테이블그자체 리스트에는 페이지넘버가 들어가겠네
    	

        // get the first item in queue
        // may return null, so we needs Integer
        Integer i = this.list.poll(); //첫번째 값반환 
        if(i != null){ //첫번째값이 존재하면
            // remove this item from hashtable
            this.table.remove(i.intValue()); //페이지 넘버에 맞는 테이블의 값을 삭제 처리
        }
        
        
        this.list.add(p_num);
        this.table.put(p_num, f_num);
    } //기존 알고리즘은 그냥 순차적으로 저장시켜줌-->FIFO알고리즘. 있는지 없는지는 addresstranslator 에서 판단해줌.


    public static void main(String[] args){
        TLB tlb = new TLB();
        for(int i=0; i<=16; i++){
            tlb.put(i,i);
        }
        System.out.println(tlb.get(0));
    }
}

