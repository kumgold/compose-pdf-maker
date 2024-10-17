package com.example.hellospring.demo;

import com.example.hellospring.demo.repository.MemberRepository;
import com.example.hellospring.demo.repository.MemoryMemberRepository;
import com.example.hellospring.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
