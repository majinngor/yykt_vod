package com.yy.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yy.mapper.SubjectMapper;
import com.yy.model.vod.Subject;
import com.yy.vo.vod.SubjectEeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SubjectListener extends AnalysisEventListener<SubjectEeVo> {
    @Autowired
    private SubjectMapper subjectMapper;

    public static Map<String,List> map;
    public static List<String> list1;
    public static List<String> list2;

    static {
        list1 = new ArrayList();
        list2 = new ArrayList();
        map = new HashMap();
        map.put("T",list1);
        map.put("F",list2);
    }
    //一行一行读取
    @Override
    public void invoke(SubjectEeVo subjectEeVo, AnalysisContext analysisContext) {
        QueryWrapper<Subject> objectQueryWrapper = new QueryWrapper<>();
        //调用方法添加数据库
        objectQueryWrapper.eq("title",subjectEeVo.getTitle());
        Integer integer = subjectMapper.selectCount(objectQueryWrapper);
        if (integer == 0){
            Subject subject = new Subject();
            BeanUtils.copyProperties(subjectEeVo,subject);
            subjectMapper.insert(subject);
            list1.add(subjectEeVo.getTitle());
        }else {
            list2.add(subjectEeVo.getTitle());
        }
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}