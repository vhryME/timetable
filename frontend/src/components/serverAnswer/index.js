import { connect } from "react-redux";
import { bindActionCreators } from "redux";
import { serverGetHelloWorld, serverGetError } from "./actions";
import ServerAnswer from "./ServerAnswer";

const mapStateToProps = (state, self) => {
  return {
    ...state.server,
    ...self,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    ...bindActionCreators(
      {
        serverGetError,
        serverGetHelloWorld,
      },
      dispatch
    ),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(ServerAnswer);
