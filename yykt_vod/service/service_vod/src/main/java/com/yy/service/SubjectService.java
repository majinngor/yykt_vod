package com.yy.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.model.vod.Subject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author abc
 * @since 2023-06-08
 */
public interface SubjectService extends IService<Subject> {
    //查询下一层课程分类
    List<Subject> selectList(Long id);
    /**
     * 导出
     * @param response
     */
    void exportData(HttpServletResponse response);

    void importDictData(MultipartFile file);
}
