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
    public PhysicalMemory(){ //구조체
        this.frames = new Frame[128]; // 프레임 크기 256바이트
        this.currentFreeFrame = 0;
    }  


    /**
     * function to add a new frame to memory
     *
     * @param f Frame to be added
     * @return int the frame number just added
     */
    public int addFrame(Frame f){ //프레임에 값더해주기
    	
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
    public int getValue(int f_num, int offset){ //피지컬메모리안에 있는 값을 받아오는건데
        Frame frame = this.frames[f_num]; 		//프레임은 f num 몇번째 프레임인지 판단
        return frame.data[offset]; 				// 오프셋은 프레임 안에서 무엇인지 판단
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
    public Frame(int[] d){ //프레임틀을 생성 256개
        this.data = new int[256]; 
        for(int i=0;i<256;i++){//d배열의 i번째에 있는 값을 data프레임안에 넣어줌
            this.data[i] = d[i];
        }
    }


    /**
     * Copy Constructor
     *
     * @param f Frame to be copied
     */
    public Frame(Frame f){ //한 프레임 내부에 관한 설계
        this.data = new int[256]; //겉프레임이 256이고 속데이터가 256
        System.arraycopy(f.data, 0, this.data, 0, 256); //f data의 0번쨰 부터 this.data 0배열부터 256개 저장
    }
}

