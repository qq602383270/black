/**
 * Project Name:black
 * File Name:TestHome.java
 * Package Name:com.brd.test
 * Date:2016年6月21日下午11:36:51
 * Copyright (c) 2016, ehking All Rights Reserved.
 *
*/

package com.brd.test;

import org.junit.Test;

/**
 * ClassName:TestHome <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年6月21日 下午11:36:51 <br/>
 * @author   wangyonghe
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class TestHome {

    @Test
    public void test(){
        
        Double home1=7.4*3.8;
        Double home2=3.4*3.2;
        Double home3=4*3.2;

        Double totalAmout=5800.0;
        
        Double total=home1+home2+home3;
        
        System.out.println(home1/total*totalAmout);
        System.out.println(home2/total*totalAmout);
        System.out.println(home3/total*totalAmout);
    }
}

