package com.allong.yj.springdata.dao;

import com.allong.yj.springdata.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: PersonRepository
 * Author:   yangjian
 * Date:     2020/11/15 0:29
 * Description：空接口，标记接口，如果类实现了该接口，会被spring识别，并放入IOC容器
 * 也可以通过@RepositoryDefinition 注解将其标明为 实现了 Repository 的类
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/15 0:29        1.0              描述
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person getByLastName(String lastName);

    /**
     * lastName like ?% and id <
     *
     * @param lastName
     * @param id
     * @return
     */
    List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, Integer id);

    List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, Integer id);

    List<Person> getByEmailInOrBirthLessThan(List<String> emails, Date birth);

    /**
     * 使用Query 注解自定义Query 查询
     *
     * @return
     */
    @Query("select p from Person p where p.id = (select max(p2.id) from Person p2)")
    Person getMaxIdPerson();

    @Query("select p from Person  p where p.lastName = ?1 and p.email = ?2")
    Person getAnnotationPerson(String lastName, String email);

    @Query("select p from Person  p where p.lastName = :lastName and p.email = :email")
    Person getAnnotationPerson2(@Param("email")String email,@Param("lastName") String lastName);

    @Query("select p from Person  p where p.lastName like %?1% and p.email like %?2%")
    List<Person> getAnnotationPerson3( String lastName, String email);

    @Query(value = "select count(id) from person", nativeQuery = true)
    long getTotalCount();

    @Modifying
    @Query("update Person  p set p.lastName = :lastName where p.id  = :id")
    void updatePerson(@Param("lastName")String lastName,@Param("id")Integer id);

}
