package com.pushihao.service.student;

import com.pushihao.pojo.Student;

import java.util.List;

public interface StudentService {

    /**返回满足条件的总人数的页数
     * @param vagueName 模糊姓名
     * @param _class 班级
     * @param sex 性别，男是boy，女是girl
     * @param score 及格是passed，不及格是failed
     * */
    public int getTotalDataNum(String vagueName, String _class, String sex, String score);

    /**返回满足条件的所有学生
     * @param vagueName 模糊姓名
     * @param _class 班级
     * @param sex 性别，男是boy，女是girl
     * @param score 及格是passed，不及格是failed
     * @param startIndex 开始的行数 - 1
     * @param num 要查询的记录总数
     * */
    public List<Student> selectStudent(String vagueName, String _class, String sex, String score, String startIndex, String num);

    /**通过id删除一位学生
     * @return 删除成功返回true，删除失败返回false
     * */
    public boolean deleteOneStudentById(int studentId);

    /**通过id查找一位学生
     * */
    public Student selectOneStudentById(int studentId);

    /**更新一名学生
     * */
    public boolean updateOneStudent(Student student);

    /**新增一名学生
     * */
    public boolean addOneStudent(Student student);
}
