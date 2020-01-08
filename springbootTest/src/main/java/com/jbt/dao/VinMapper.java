package com.jbt.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jbt.model.Vin;

/**
 * @Author caidonglin
 * @Date 2019/10/29
 */
public interface VinMapper extends BaseMapper<Vin> {

    public void add(Vin vin);
}
