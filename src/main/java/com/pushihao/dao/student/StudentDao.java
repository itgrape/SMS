package com.pushihao.dao.student;

import com.pushihao.pojo.Student;
import java.util.List;

public interface StudentDao {

    /**通过动态sql代码查询学生
     * @param vagueName 模糊姓名
     * @param _class 班级
     * @param sex 性别，男是boy，女是girl
     * @param score 及格是passed，不及格是failed
     * @param startIndex 开始的行数 - 1
     * @param num 要查询的记录总数
     * */
    public List<Student> selectStudent(String vagueName, String _class, String sex, String score, String startIndex, String num);

    /**通过id查找某一位学生
     * */
    public Student selectOneStudentById(int id);

    /**删除一位学生
     * @return 删除成功返回true，失败返回false
     * */
    public boolean deleteOneStudent(Student student);

    /**更新一位学生
     * @return 更新成功返回true，失败返回false
     * */
    public boolean updateOneStudent(Student student);

    /**新增一位学生
     * */
    public boolean addOneStudent(Student student);

}
