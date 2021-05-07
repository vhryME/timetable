import { connect } from "react-redux";
import UTable from "./UniversalTable";

const mapStateToProps = ({dictionaries}) => ({dictionaries})

export const UniversalTable = connect(mapStateToProps, null)(UTable);