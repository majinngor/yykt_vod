package com.yy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yy.model.vod.VideoVisitor;
import com.yy.vo.vod.VideoVisitorCountVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 视频来访者记录表 Mapper 接口
 * </p>
 *
 * @author abc
 * @since 2023-06-08
 */
@Repository
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {
    ////显示统计数据
    List<VideoVisitorCountVo> findCount(Long courseId, String startDate, String endDate);
}
