package com.besti.springcloud.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/24
 */
@Data
public class OrderHandler {

    private OrderHandlerVO orderHandlerVO;
    private List<Order2> data;

    public List<Order2> getOrderMsg(OrderVO orderVO){

        for (int i = 0; i < orderVO.getCount() ; i++) {
            data.get(i).setId(orderVO.getData().get(i).getId());
            data.get(i).setName(orderVO.getData().get(i).getMenu().getName());
            data.get(i).setPrice(orderVO.getData().get(i).getMenu().getPrice());
            data.get(i).setFlavor(orderVO.getData().get(i).getMenu().getFlavor());
            data.get(i).setNickname(orderVO.getData().get(i).getUser().getNickname());
            data.get(i).setTelephone(orderVO.getData().get(i).getUser().getTelephone());
            data.get(i).setAddress(orderVO.getData().get(i).getUser().getAddress());
            data.get(i).setDate(orderVO.getData().get(i).getDate());
        }
        System.out.println(data);
        return data;
    }

    public OrderHandlerVO hander(List<Order2> data){
        orderHandlerVO.setCode(0);
        orderHandlerVO.setMsg("");
        orderHandlerVO.setCount(0);
        orderHandlerVO.setData(data);
        return orderHandlerVO;
    }

}
