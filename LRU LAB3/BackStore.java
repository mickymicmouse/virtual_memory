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
                        fileName = new File("BACKING_STORE"); //randomaccess file RandomAccessFileŬ������ ���״�� ������ �����ϰ� �а� ���� �ִ� Ŭ���� �Դϴ�.
                    disk = new RandomAccessFile(fileName, "r");


            // seek in byte
                        disk.seek(pageNum*256); //RandomAccessFile.seek(������ ��ġ��) : ������ ��ġ���� ����

                        				//RandomAccessFile.read(����Ʈ�迭) : �� ������ ��ġ�������� ����Ʈ �迭 ���̸�ŭ �о� ����
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
                System.arraycopy(getData(100),0,i,0,32); //������ �ѹ��� 100�� ���� 0��° �迭���� 32���� i�迭�� 0���� ä���־��
                for(int j=0;j<32;j++)
                        System.out.println(i[j]);


                System.arraycopy(getData(255),0,i,0,32);
                for(int j=0;j<32;j++)
                        System.out.println(i[j]);
        }
}

