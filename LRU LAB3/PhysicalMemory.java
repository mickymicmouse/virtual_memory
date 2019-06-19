/**
 * Class to emulate the physical memory
 */
public class PhysicalMemory{
    /**
     * variable to emulate frames in memory
     */
    Frame[] frames;
    /**
     * we need a variable to store how many
     * frames are used
     */
    int currentFreeFrame;
    PageTable pt = new PageTable();

    /**
     * Constructor
     */
    public PhysicalMemory(){ //����ü
        this.frames = new Frame[128]; // ������ ũ�� 256����Ʈ
        this.currentFreeFrame = 0;
    }  


    /**
     * function to add a new frame to memory
     *
     * @param f Frame to be added
     * @return int the frame number just added
     */
    public int addFrame(Frame f){ //�����ӿ� �������ֱ�
    	
    	this.frames[this.currentFreeFrame] = new Frame(f.data);
        this.currentFreeFrame++;
        
        return this.currentFreeFrame-1; 
        
    }


    /**
     * function to get value in memory
     *
     * @param f_num int frame number
     * @param offset int offset
     * @return int content in specified location
     */
    public int getValue(int f_num, int offset){ //�����ø޸𸮾ȿ� �ִ� ���� �޾ƿ��°ǵ�
        Frame frame = this.frames[f_num]; 		//�������� f num ���° ���������� �Ǵ�
        return frame.data[offset]; 				// �������� ������ �ȿ��� �������� �Ǵ�
    }


}


/**
 * wrapper class to group all frame related logics
 */
class Frame {
    /**
     * variable to store datas of this frame
     */
    int[] data;


    /**
     * Constructor
     *
     * @param d int[256] for initializing frame
     */
    public Frame(int[] d){ //������Ʋ�� ���� 256��
        this.data = new int[256]; 
        for(int i=0;i<256;i++){//d�迭�� i��°�� �ִ� ���� data�����Ӿȿ� �־���
            this.data[i] = d[i];
        }
    }


    /**
     * Copy Constructor
     *
     * @param f Frame to be copied
     */
    public Frame(Frame f){ //�� ������ ���ο� ���� ����
        this.data = new int[256]; //���������� 256�̰� �ӵ����Ͱ� 256
        System.arraycopy(f.data, 0, this.data, 0, 256); //f data�� 0���� ���� this.data 0�迭���� 256�� ����
    }
}

