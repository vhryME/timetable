import { connect } from "react-redux";
import MatchesTableLayout from "./AllMatchesLayout";
import MatchLayout from "./MatchLayout";
import { getAllMatches, newMatch, editMatch, getOneMatch, deleteMatch, getMatchesFiltered } from "./actions";

const mapStateToProps = ({matches}) => ({matches});

const mapDispatchToProps = {
  getAllMatches, newMatch, editMatch, getOneMatch, deleteMatch, getMatchesFiltered
};

export const MatchesTable = connect(mapStateToProps, mapDispatchToProps)(MatchesTableLayout);
export const MatchForm = connect(mapStateToProps, mapDispatchToProps)(MatchLayout);