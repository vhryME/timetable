package com.epolsoft.match.adapter;


import com.epolsoft.hero.domain.HeroJpa;
import com.epolsoft.hero.domain.TalentJpa;
import com.epolsoft.hero.repository.HeroRepository;
import com.epolsoft.hero.repository.TalentRepository;
import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.MatchJpa;
import com.epolsoft.match.domain.PlayerInMatchJpa;
import com.epolsoft.match.domain.PlayerJpa;
import com.epolsoft.match.mapper.MatchJpaMapper;
import com.epolsoft.match.port.out.MatchPort;
import com.epolsoft.match.repository.MatchRepository;
import com.epolsoft.match.repository.PlayerRepository;
import com.epolsoft.match.specification.MatchSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Component
@RequiredArgsConstructor
class MatchAdapter implements MatchPort {

    private final MatchRepository matchRepository;

    private final HeroRepository heroRepository;

    private final TalentRepository talentRepository;

    private final PlayerRepository playerRepository;

    private final MatchJpaMapper matchJpaMapper;

    @Override
    @Transactional
    public Match find(Long id) throws Exception {
        MatchJpa matchJpa = matchRepository.findById(id).get();

        return matchJpaMapper.jpaEntityToEntity(matchJpa);
    }


    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        matchRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Match create(Match match) {
        MatchJpa matchJpa = matchJpaMapper.entityToJpaEntity(match);

        List<HeroJpa> heroes = heroRepository.findAll();
        List<TalentJpa> talents = talentRepository.findAll();
        List<PlayerJpa> players = playerRepository.findAll();

        Set<PlayerInMatchJpa> playersFromTeam1 = matchJpa.getTeam1().getPlayers();
        Set<PlayerInMatchJpa> playersFromTeam2 = matchJpa.getTeam2().getPlayers();

        setIdsForHeroesOfPlayersInMatchInSaveMethod(playersFromTeam1, heroes);
        setIdsForHeroesOfPlayersInMatchInSaveMethod(playersFromTeam2, heroes);

        setIdsForTalentsOfPlayersInMatchInSaveMethod(playersFromTeam1, talents);
        setIdsForTalentsOfPlayersInMatchInSaveMethod(playersFromTeam2, talents);

        setIdsForPlayersOfPlayersInMatchInSaveMethod(playersFromTeam1, players);
        setIdsForPlayersOfPlayersInMatchInSaveMethod(playersFromTeam2, players);

        matchRepository.save(matchJpa);

        return matchJpaMapper.jpaEntityToEntity(matchJpa);
    }

    @Override
    @Transactional
    public Match update(Long id, Match match) throws Exception {
        MatchJpa current = matchRepository.findById(id).get();

        if (current != null) {
            current = matchJpaMapper.entityToJpaEntity(match);
        }
        matchRepository.save(current);

        return matchJpaMapper.jpaEntityToEntity(current);
    }


    @Override
    @Transactional
    public List<Match> findAll() throws Exception {
        List<MatchJpa> jpaMatches = matchRepository.findAll();

        return matchJpaMapper.listJpaEntityToListEntity(jpaMatches);
    }


    @Override
    public Page<Match> findPageOfMatch(Pageable pageable) throws Exception {
        Page<MatchJpa> jpaMatches = matchRepository.findAll(pageable);

        return matchJpaMapper.jpaMatchPageToMatchPage(jpaMatches);
    }


    @Override
    public Page<Match> findPageOfMatchFiltered(Pageable pageable, MatchPort.MatchFiltered matchFiltered) throws Exception {
        if (matchFiltered != null) {
            return matchRepository.findAll(MatchSpecification.filter(matchFiltered), pageable).
                    map(matchJpaMapper::jpaEntityToEntity);
        }

        return null;
    }


    public void setIdsForHeroesOfPlayersInMatchInSaveMethod(Set<PlayerInMatchJpa> players,
                                                            List<HeroJpa> heroes) {
        players.forEach(player -> heroes.forEach(hero -> {
            if (player.getHero().getName().equals(hero.getName())) {
                player.setHero(hero);
            }
        }));
    }


    public void setIdsForTalentsOfPlayersInMatchInSaveMethod(Set<PlayerInMatchJpa> players,
                                                             List<TalentJpa> talents) {
        players.forEach(player -> talents.forEach(talent -> player.getTalents().forEach(playerTalent -> {
            if (playerTalent.getName().equals(talent.getName())) {
                playerTalent.setId(talent.getId());
            }
        })));
    }


    public void setIdsForPlayersOfPlayersInMatchInSaveMethod(Set<PlayerInMatchJpa> playersFromMatch,
                                                             List<PlayerJpa> players) {
        playersFromMatch.forEach(playerFromMatch -> players.forEach(player -> {
            if (playerFromMatch.getPlayer().getLogin().equals(player.getLogin())) {
                playerFromMatch.getPlayer().setId(player.getId());
            }
        }));
    }
}