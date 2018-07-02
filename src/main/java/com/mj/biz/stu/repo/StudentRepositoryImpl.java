package com.mj.biz.stu.repo;


import com.mj.biz.stu.model.QClazz;
import com.mj.biz.stu.model.QStudent;
import com.mj.biz.stu.vo.StudentWithClazzNameVO;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static com.querydsl.core.types.Projections.constructor;

/**
 * @author bvvy
 * @date 2017/12/4
 * <p>
 * repo
 */
@Repository
public class StudentRepositoryImpl implements StudentRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public StudentWithClazzNameVO getWithClazzName(Integer id) {
        QStudent student = QStudent.student;
        QClazz clazz = QClazz.clazz;
        JPAQuery<StudentWithClazzNameVO> query = new JPAQuery<>(entityManager);
        return query.select(
                constructor(StudentWithClazzNameVO.class, student.id, student.name, student.gender, student.clazzId, clazz.name)
        ).from(student)
                .leftJoin(clazz)
                .on(student.clazzId.eq(clazz.id))
                .where(student.id.eq(id)).fetchOne();
    }
}
