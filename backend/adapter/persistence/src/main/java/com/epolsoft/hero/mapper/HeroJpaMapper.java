package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.*;
import com.epolsoft.mapper.DateMapper;
import com.epolsoft.mapper.JpaMapper;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;


@Mapper(uses = {SpellJpaMapper.class, TalentJpaMapper.class, DateMapper.class, HeroJpaMapper.RoleJpaMapper.class,
HeroJpaMapper.StatusJpaMapper.class})
public interface HeroJpaMapper extends JpaMapper<HeroJpa, Hero> {

    default Page<Hero> jpaHeroPageToHeroPage(Page<HeroJpa> heroJpaPage){
      return heroJpaPage.map(this::jpaEntityToEntity);
    };

    @Mapper
    interface StatusJpaMapper extends JpaMapper<StatusJpa, Status> {}

    @Mapper
    interface RoleJpaMapper extends JpaMapper<RoleJpa, Role> {}

}