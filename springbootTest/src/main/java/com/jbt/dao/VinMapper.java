package spring.boot.seimi.crawler.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import spring.boot.seimi.crawler.pojo.Vin;

/**
 * @Author caidonglin
 * @Date 2019/10/29
 */
public interface VinMapper extends BaseMapper<Vin> {

    public void add(Vin vin);
}
