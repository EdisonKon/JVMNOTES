package com.test.TestJVM.util;


/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-11 12:42
 * @from
 **/
public class Convert {
        /**
         * 将int型数值转为二进制数组
         * 方法说明：<br/>
         * 创建时间：2012-7-16<br/>
         * 修改时间：2012-01-01   修改人：user   修改备注：原因及思路   <br/>
         * 注意 ：下列参数也须注释<br/>
         * @param from
         * @param len
         * @return<br/>
         */
        public static byte[] intToBin( int from, int len )
        {
            byte[] to = new byte[len];
            int max = len;
            for( int i_move = max - 1, i_to = 0; i_move >= 0; i_move--, i_to++ )
            {
                to[i_to] = (byte)( from >> ( 8 * i_move ) );
            }
            return to;
        }

        /**
         * 将二进制数组转为int型数值
         * 方法说明：<br/>
         * 创建时间：2012-7-16<br/>
         * 修改时间：2012-01-01   修改人：user   修改备注：原因及思路   <br/>
         * 注意 ：下列参数也须注释<br/>
         * @param from
         * @param offset
         * @param len
         * @return<br/>
         */
        public static int binToInt( byte[] from, int offset, int len )
        {
            int to = 0;
            int min = offset;
            to = 0;
            for( int i_move = len - 1, i_from = min; i_move >= 0; i_move--, i_from++ )
            {
                to = to << 8 | ( from[i_from] & 0xff );
            }
            return to;
        }
        public static void main(String[] args) {
            byte[] byt=intToBin("信贷的人儿".getBytes().length,4);
            System.out.println(byt);
            int byt1=binToInt(byt,0,4);
            System.out.println(byt1);
        }
}
