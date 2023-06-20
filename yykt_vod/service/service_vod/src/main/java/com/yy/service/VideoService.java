package com.yy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.model.vod.Video;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author abc
 * @since 2023-06-08
 */
public interface VideoService extends IService<Video> {

    void removeVideoByCourseId(Long id);

    void removeVideoById(Long id);
}
