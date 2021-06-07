package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.HeroJpa;
import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.domain.RoleJpa;
import com.epolsoft.mapper.DateMapper;
import com.epolsoft.mapper.JpaMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(uses = {SpellJpaMapper.class, TalentJpaMapper.class, DateMapper.class, HeroJpaMapper.RoleJpaMapper.class})
public interface HeroJpaMapper extends JpaMapper<HeroJpa, Hero> {

    @Mapper
    interface RoleJpaMapper extends JpaMapper<RoleJpa, Role> {}

}