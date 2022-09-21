package com.pushihao.dao.teacher;

import com.pushihao.pojo.Teacher;

import java.sql.ResultSet;
import java.util.List;

public interface TeacherDao {

    /**根据id查找某一位老师
     * */
    public Teacher selectOneTeacherById(int id);

    /**根据邮件查找某一位老师
     * */
    public Teacher selectOneTeacherByEmail(String email);

    /**根据模糊姓名查找一些老师
     * */
    public List<Teacher> selectTeachersByVagueName(String vagueName);

    /**根据班级查找一些老师
     * */
    public List<Teacher> selectTeachersByClass(int _class);

    /**查找所有的老师
     * */
    public List<Teacher> selectAllTeachers();

    /**修改老师信息
     * @param teacher 新的老师实体对象
     * @return 返回true，修改成功，返回false，修改失败
     * */
    public boolean updateOneTeacher(Teacher teacher);

    /**增加一位老师
     * @param teacher 新的老师实体对象
     * @return 添加成功返回true，添加失败返回false
     * */
    public boolean addOneTeacher(Teacher teacher);

    /**删除一位老师
     * @param teacher 要删除的老师的实体对象
     * @return 删除成功返回true，删除失败返回false
     * */
    public boolean deleteOneTeacher(Teacher teacher);

    /**根据条件使用动态sql查询老师
     * @param _name 老师姓名
     * @param _sex 老师性别，man代表男老师，woman代表女老师
     * @param _class 老师所在班级
     * */
    public List<Teacher> selectTeachers(String _name, String _sex, String _class);
}
