package com.venturestartup.hackathon.domain.fortune.repository;

import com.venturestartup.hackathon.domain.fortune.constant.FortuneType;
import com.venturestartup.hackathon.domain.fortune.entity.Fortune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FortuneRepository
        extends JpaRepository<Fortune, Long> {

    List<Fortune> findByFortuneType(FortuneType fortuneType);

}
