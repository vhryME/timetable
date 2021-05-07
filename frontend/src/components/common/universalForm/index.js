import { connect } from "react-redux";
import UForm from "./UniversalForm";

const mapStateToProps = ({dictionaries}) => ({dictionaries})

export { default as Validator } from "./RulesMap";
export const UniversalForm = connect(mapStateToProps, null)(UForm);