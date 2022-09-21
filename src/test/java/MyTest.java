import com.pushihao.dao.student.StudentDao;
import com.pushihao.dao.student.impl.StudentDaoImpl;
import com.pushihao.dao.teacher.TeacherDao;
import com.pushihao.dao.teacher.impl.TeacherDaoImpl;
import com.pushihao.pojo.Student;
import com.pushihao.pojo.Teacher;
import com.pushihao.util.PageSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

    @Test
    public void testSelectOneTeacherByEmail() {
        TeacherDao dao = new TeacherDaoImpl();
        Teacher teacher = dao.selectOneTeacherByEmail("pillage@qq.com");
        System.out.println(teacher.get_email());
    }

    @Test
    public void testSelectTeachersByVagueName() {
        TeacherDao dao = new TeacherDaoImpl();
        List<Teacher> list = dao.selectTeachersByVagueName("p");
        for (Teacher teacher : list) {
            System.out.println(teacher.get_email());
        }
    }

    @Test
    public void testSelectAllTeachers() {
        TeacherDao dao = new TeacherDaoImpl();
        List<Teacher> teachers = dao.selectAllTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher.get_email());
        }
    }

    @Test
    public void testUpdateOneTeacher() {
        TeacherDao dao = new TeacherDaoImpl();
        Teacher teacher = new Teacher();
        teacher.set_id(2);
        teacher.set_sex("man");
        teacher.set_role(1);
        teacher.set_password("pillage");
        teacher.set_class(1);
        teacher.set_name("pillage");
        teacher.set_age(19);
        teacher.set_email("pillage@qq.com");
        System.out.println(dao.updateOneTeacher(teacher));
    }

    @Test
    public void testAddOneTeacher() {
        TeacherDao dao = new TeacherDaoImpl();
        Teacher teacher = new Teacher();
        teacher.set_sex("man");
        teacher.set_role(1);
        teacher.set_password("caoxueqin");
        teacher.set_class(2);
        teacher.set_name("曹雪芹");
        teacher.set_age(85);
        teacher.set_email("caoxueqin@qq.com");
        System.out.println(dao.addOneTeacher(teacher));
    }

    @Test
    public void testDeleteOneTeacher() {
        TeacherDao dao = new TeacherDaoImpl();
        Teacher teacher = new Teacher();
        teacher.set_id(6);
        System.out.println(dao.deleteOneTeacher(teacher));
    }

    @Test
    public void testSelectStudent() {
        StudentDao dao = new StudentDaoImpl();
        List<Student> students = dao.selectStudent("张", "1", "boy", "passed", "1", "4");
        students.forEach(student -> System.out.println(student.get_name()));
    }

    @Test
    public void testArray() {
        List<String> list = new ArrayList<>();
        list.add("gh");
        list.add("jk");
        list.add("kl");
        Object[] objects = list.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    public void testPageSupport() {
        PageSupport support = new PageSupport();
        support.setTotalDataNum(10);
        support.setCurrentPageNum(2);
        for (int index : support.getIndex()) {
            System.out.println(index);
        }
        support.setCurrentPageNum(1);
        for (int index : support.getIndex()) {
            System.out.println(index);
        }
    }
}
