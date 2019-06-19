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
        if(this.table.containsKey(p_num)){ // �� ���̺���(tlb���̺�) page number�� ������ ������, �� ���� ��ȯ
            return (int) this.table.get(p_num); //������ �ѹ��� ���õ� ���̺� �� �� f_num�� ��ȯ
        }
        else{
            return -1; //�ƴϸ� 1����ȯ
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
        // oldest is determined by the Queue this.list #����Ʈ�� �����Ȱ��� �����Ǵϱ�... ���� ���Դ��� �Ǵ��ϴ� ����Ʈ�� �ǰ���, 16���� TLB 
    	//����Ʈ�� ������������ �Ǵ�, table�� ���̺����ü ����Ʈ���� �������ѹ��� ���ڳ�
    	

        // get the first item in queue
        // may return null, so we needs Integer
        Integer i = this.list.poll(); //ù��° ����ȯ 
        if(i != null){ //ù��°���� �����ϸ�
            // remove this item from hashtable
            this.table.remove(i.intValue()); //������ �ѹ��� �´� ���̺��� ���� ���� ó��
        }
        
        
        this.list.add(p_num);
        this.table.put(p_num, f_num);
    } //���� �˰����� �׳� ���������� ���������-->FIFO�˰���. �ִ��� �������� addresstranslator ���� �Ǵ�����.


    public static void main(String[] args){
        TLB tlb = new TLB();
        for(int i=0; i<=16; i++){
            tlb.put(i,i);
        }
        System.out.println(tlb.get(0));
    }
}

