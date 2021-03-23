import { connect } from "react-redux";
import { bindActionCreators } from "redux";
import { serverGetPost, serverGetError } from "./actions";
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
        serverGetPost,
      },
      dispatch
    ),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(ServerAnswer);
