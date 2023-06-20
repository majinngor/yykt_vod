package com.yy.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.model.vod.Chapter;
import com.yy.vo.vod.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author abc
 * @since 2023-06-08
 */
public interface ChapterService extends IService<Chapter> {
    //章节小结列表
    List<ChapterVo> getNestedTreeList(Long courseId);

    void removeChapterByCourseId(Long id);
}
