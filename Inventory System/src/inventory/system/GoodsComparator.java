/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.system;

import java.util.Comparator;

/**
 *
 * @author hamza
 */
public class GoodsComparator implements Comparator<Goods>{

    @Override
    public int compare(Goods o1, Goods o2) {
        return o1.id - o2.id;
    }
    
}
