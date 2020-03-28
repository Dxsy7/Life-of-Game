package Game;
import java.util.Random;
import java.util.Scanner;

    /*
    1.����С��Ϸ���ھ�Ϊ�������Һ�б�Խ�һ���˸�λ��;
    2.Ĭ��ѡ��4*4�ĸ��ӡ�
    3.��Ĭ�ϵĸ��ӳ�ʼ��������ӡ���
    4.ʹ��LifeGame�еķ���������һ�ֵ�״̬������ӡ
     */

public class Main {
    public static void main(String[] args) {

        //������һ����ά����洢���еĸ���
        String[][] map = new String[8][8];

        LifeGame me = new LifeGame();

        //�����и��ӽ��г�ʼ�����룬��Ϊ0����Ϊ1
        //������ɸ���λ�õ��ھ����
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                int num = new Random().nextInt(2);
                if (num == 1)
                    map[i][j] = "��";
                else if (num == 0)
                    map[i][j] = "��";
            }
        }

        //��ӡ���ӳ�ʼ״̬
        System.out.println("��ʼ״̬Ϊ��");
        me.newMap(map);
        System.out.println("===========");

        int n = 0;
        int num = 0;//��¼�仯�Ĵ���
        while (n == 0) {

            //��point���飬��¼��Ӧλ����һ�ֵ�״̬��1��һ������2��һ�������3��һ������
            int[] point = me.check(map, new int[64]);

            //�����һ�α仯���ͼ��
            map = me.getNext(map, point).clone();

            System.out.println("��" + (++num) + "�α仯��");

            //��ӡ����
            me.newMap(map);
            System.out.println("===========");

            System.out.println("����0����������һ�����������������˳���");
            n = new Scanner(System.in).nextInt();
        }
    }
}

