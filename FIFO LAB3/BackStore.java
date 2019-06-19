import java.io.RandomAccessFile;
import java.io.*;


public class BackStore{


        /**
         * function of getDate
         * 
         * @param pageNum        page number
         */
        public static int[] getData(int pageNum){ 
                byte[] value = new byte[256];
                int[] result = new int[256];
                File fileName;
                RandomAccessFile disk = null;
                try{
                        fileName = new File("BACKING_STORE"); //randomaccess file RandomAccessFile클래스는 말그대로 파일을 랜덤하게 읽고 쓸수 있는 클래스 입니다.
                    disk = new RandomAccessFile(fileName, "r");


            // seek in byte
                        disk.seek(pageNum*256); //RandomAccessFile.seek(포인터 위치값) : 포인터 위치값을 설정

                        				//RandomAccessFile.read(바이트배열) : 현 포인터 위치에서부터 바이트 배열 길이만큼 읽어 들임
                        disk.read(value);


                        disk.close(); 
                }
                catch (IOException e) {
                        System.err.println ("Unable to start the disk");
                        System.exit(1);
                }
        for(int i=0; i<256; i++){
            result[i] = value[i];
        }
        return result;
        }


        public static void main(String args[]){
                int[] i = new int[32];
                System.arraycopy(getData(100),0,i,0,32); //페이지 넘버가 100인 것의 0번째 배열부터 32개를 i배열의 0부터 채워넣어라
                for(int j=0;j<32;j++)
                        System.out.println(i[j]);


                System.arraycopy(getData(255),0,i,0,32);
                for(int j=0;j<32;j++)
                        System.out.println(i[j]);
        }
}

