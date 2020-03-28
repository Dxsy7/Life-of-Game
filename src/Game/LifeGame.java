package Game;
public class LifeGame {

    public LifeGame() {
    }

    //�÷����������λ�ã������ض�Ӧλ�õ�point����
    //��point���飬��¼��Ӧλ����һ�ֵ�״̬��1��һ������2��һ�������3��һ������
    public int[] check(String[][] map, int[] point) {

        int n = 0;
        //ͳ����Χ�ھӵ����
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                /*
                �������£������ж�
                    1.һ���˿�����8���ھӣ�
                    2.һ������ֻ��һ���ھӣ�����һ����¶�����ȥ��
                    3.����2��3���ھӣ�����һ����Ȼ���ţ�
                    4.����4���������ھӣ�����һ������ӵ��������
                    5.��ȥ��������3���ھӣ�����һ���Ḵ�
                    6.���е���ȥ�򸴻����һ���仯ʱͬʱ������
                */

                //��life������¼��Χ���ŵ��ھӸ���
                int life = 0;

                //1.�ж����·���λ��
                if (i + 1 < 8 && map[i + 1][j].equals("��")) {
                    life++;
                }

                //2.�ж�����λ��
                if (i + 1 < 8 && j + 1 < 8 && map[i + 1][j + 1].equals("��")) {
                    life++;
                }

                //3.�ж�����λ��
                if (i + 1 < 8 && j - 1 >= 0 && map[i + 1][j - 1].equals("��")) {
                    life++;
                }

                //4.�ж��Ҳ�λ��
                if (j + 1 < 8 && map[i][j + 1].equals("��")) {
                    life++;
                }

                //5.�ж����λ��
                if (j - 1 >= 0 && map[i][j - 1].equals("��")) {
                    life++;
                }

                //6.�ж����Ϸ�λ��
                if (i - 1 >= 0 && map[i - 1][j].equals("��")) {
                    life++;
                }

                //7.�ж�����λ��
                if (i - 1 >= 0 && j + 1 < 8 && map[i - 1][j + 1].equals("��")) {
                    life++;
                }

                //8.�ж�����λ��
                if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1].equals("��")) {
                    life++;
                }

                //��һ�����飬��¼��Ӧλ����һ�ֵ�״̬��1��һ������2��һ�������3��һ������
                if (map[i][j].equals("��")) {
                    if (life == 1)
                        point[n] = 1;
                    else if (life == 2 || life == 3)
                        point[n] = 2;
                    else if (life >= 4)
                        point[n] = 1;
                } else {
                    if (life == 3)
                        point[n] = 3;
                }
                n++;
            }
        }
        return point;
    }

    public String[][] getNext(String[][] map, int[] point) {

        int n = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                //���״̬
                if (point[n] == 1)
                    map[i][j] = "��";
                if (point[n] == 3)
                    map[i][j] = "��";

                n++;
            }
        }
        return map;
    }

    public void newMap(String[][] map){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 7)
                    System.out.println(map[i][j] + " ");
                else
                    System.out.print(map[i][j] + " ");
            }
        }
    }
}

