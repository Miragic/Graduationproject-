package com.wbg.sums.dao;

import com.wbg.sums.entity.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer aId);
    int count();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbg.generated
     */
    int insert(Attendance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbg.generated
     */
    Attendance selectByPrimaryKey(Integer aId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbg.generated
     */
    List<Attendance> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Attendance record);

//    根据类型、时间、部门查询  List<Attendance> selectTypedate(String a_type,String a_date,String d_name);
//    select a_id,a_type,u.m_user,u.m_name,a_titile,a_date,a_remaks,m.m_name from Attendance a
//    join MemberInformation m on a.a_m_id=m.m_id
//    join MemberInformation u on a.m_user=u.m_user
//    where a_type=#{a_type} or a_date=#{a_date} or d_name=#{d_name}
//    根据标题模糊查询 List<Attendance> selectTitle(String title);
//    select a_id,a_type,u.m_user,u.m_name,a_titile,a_date,a_remaks,m.m_name from Attendance a
//    join MemberInformation m on a.a_m_id=m.m_id
//    join MemberInformation u on a.m_user=u.m_user
//    where title like concat('%',#{title}'%')
//    根据m_user查询 List<Attendance> selectTitle(String m_user);
//    select a_id,a_type,u.m_user,u.m_name,a_titile,a_date,a_remaks,m.m_name from Attendance a
//    join MemberInformation m on a.a_m_id=m.m_id
//    join MemberInformation u on a.m_user=u.m_user
//    where a.m_user=#{m_user}

    //姓名、部门、操作员、时间
    List<Attendance> selects(@Param("aMName") String aMName,@Param("dName") String dName,@Param("mName") String mName,@Param("beforeDate") String beforeDate, @Param("afterDate") String afterDate);
    int counts(@Param("aMName") String aMName,@Param("dName") String dName,@Param("mName") String mName,@Param("beforeDate") String beforeDate, @Param("afterDate") String afterDate);

}