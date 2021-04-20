import { connect } from "react-redux";
import HeroesTableLayout from "./AllHeroesLayout";
import HeroLayout from "./HeroLayout";
import { getAllHeroes, newHero, editHero, getOneHero, deleteHero, getHeroesFiltered } from "./actions";

const mapStateToProps = ({heroes}) => ({heroes})

const mapDispatchToProps = {
  getAllHeroes, newHero, editHero, getOneHero, deleteHero, getHeroesFiltered
};

export const HeroesTable = connect(mapStateToProps, mapDispatchToProps)(HeroesTableLayout);
export const HeroForm = connect(mapStateToProps, mapDispatchToProps)(HeroLayout);