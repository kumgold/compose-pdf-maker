package com.example.hellospring.demo;

import com.example.hellospring.demo.repository.JdbcMemberRepository;
import com.example.hellospring.demo.repository.JdbcTemplateMemberRepository;
import com.example.hellospring.demo.repository.JpaMemberRepository;
import com.example.hellospring.demo.repository.MemberRepository;
import com.example.hellospring.demo.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
