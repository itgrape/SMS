package com.pushihao.service.teacher;

import com.pushihao.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    /**检查登录信息是否正确
     * @return 返回null代表登录失败，返回老师实体代表登录成功
     * */
    public Teacher teacherLogin(String email, String password);

    /**教师自行注册
     * @return 返回true代表注册成功，返回false代表注册失败
     * */
    public boolean teacherRegist(Teacher teacher);

    /**根据条件查询老师
     * @param _name 老师姓名
     * @param _sex 老师性别，man代表男老师，woman代表女老师
     * @param _class 老师所在班级
     * */
    public List<Teacher> selectTeachers(String _name, String _sex, String _class);

    /**根据条件查询所有数据数
     * @param _name 老师姓名
     * @param _sex 老师性别，man代表男老师，woman代表女老师
     * @param _class 老师所在班级
     * */
    public int getTotalDataNum(String _name, String _sex, String _class);

    /**根据id删除一名老师（id是唯一的）
     * @return 删除成功返回true，删除失败返回false
     * */
    public boolean deleteOneTeacherById(int id);

    /**根据id查找一位老师
     * */
    public Teacher selectOneTeacherById(int id);

    /**修改一名老师的信息
     * */
    public boolean updateOneTeacher(Teacher teacher);

    /**增加一位老师
     * */
    public boolean addOneTeacher(Teacher teacher);
}
