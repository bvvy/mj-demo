package com.mj.biz.stu.repo;

import com.mj.biz.stu.vo.StudentWithClazzNameVO;

/**
 *
 * @author bvvy
 * @date 2017/12/4
 * com.mj.demo.repository
 */
public interface StudentRepositoryCustom {



    /**
     * 获取有班级名称的学生信息
     * @param id 学生id
     * @return studentClassVO
     */
    StudentWithClazzNameVO getWithClazzName(Integer id);
}
