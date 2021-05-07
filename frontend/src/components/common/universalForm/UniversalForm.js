import React from "react";
import {Form, Row, Col} from "antd";

import actionsCreator from "./ActionsCreator";
import fieldsCreator from "./FieldsCreator";

import "./styles.css";

import moment from "moment";
import PropTypes from "prop-types";

class UniversalForm extends React.Component {
  constructor(props) {
    super(props);
    if (this.props.observer) {
      if (this.props.observer.submit) {
        this.props.observer.submit(() => this.formRef.current.validateFields());
      }
    }
  }

  state = {
    dictionaries: this.props.dictionaries.data
  }

  formRef = React.createRef();

  renderButtons() {
    const actions = this.props.actions;
    return this.props.cols
      ? <Row>
        {Object.keys(actions).map((action) => {
          return actionsCreator[action](this.formRef, actions[action]);
        })}
      </Row>
      : <Form.Item noStyle>
        {Object.keys(actions).map((action) => {
          if (action === "onSubmit" && this.props.id) {
            return undefined;
          }
          return actionsCreator[action](this.formRef, actions[action]);
        })}
      </Form.Item>;
  }

  nestedWrapper = (fields, current) => {
    if (fields[current].dependsOnField && this.formRef.current) {
      return (
        <Form.Item shouldUpdate noStyle>
          {() =>
            this.formRef.current.getFieldValue(fields[current].dependsOnField) === fields[current].dependsOnValue &&
            this.getFieldItem(fields, current)
          }
        </Form.Item>
      )
    }
    return this.getFieldItem(fields, current);
  };

  getFieldItem = (fields, current) => {
    return (
      <Form.Item
        labelCol={{
          span: this.props.labelsSpan // todo: add labelsSpan to doc
        }}
        wrapperCol={{
          span: this.props.wrappersSpan // todo: add wrappersSpan to doc
        }}
        key={current}
        label={fields[current].label}
        name={current}
        rules={fields[current].rules}
        valuePropName={
          fields[current].type === "checkbox" || fields[current].type === "switch" ? "checked" : undefined
        }
        colon={fields[current].type !== "checkbox"}
      >
        {fieldsCreator[fields[current].type](this, fields[current])}
      </Form.Item>
    )
  }

  getFields = (fields) => {
    if (!this.props.cols) {
      return Object.keys(fields).map((field) => {
        return this.nestedWrapper(fields, field);
      });
    } else {
      let children = [...Array(Math.ceil(Object.keys(fields).length / this.props.cols))];

      return children.map((item, col) => {
        return (
          <Row gutter={30} style={{width: "100%"}} key={col}>
            {Object.keys(fields).filter((_, index) => {
              return index - col * this.props.cols >= 0 && index - col * this.props.cols < this.props.cols
            }).map((field) => {
              return (
                <Col style={{width: 100 / this.props.cols + "%"}} key={field}>
                  {this.nestedWrapper(fields, field)}
                </Col>)
            })}
          </Row>
        )
      })
    }
  };

  componentDidMount() {
    this.forceUpdate();
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    if (prevProps.dictionaries !== this.props.dictionaries) {
      this.setState({dictionaries: this.props.dictionaries.data});
    }
  }

  dataPreprocess() {
    let data = {...this.props.data};

    let hasDate = false;
    let dateFieldKeys = [];
    let hasDict = false;
    let dictFieldKeys = [];

    Object.keys(this.props.schema.fields).map(field => {
      if (this.props.schema.fields[field].type === "date" || this.props.schema.fields[field].type === "time") {
        hasDate = true;
        dateFieldKeys.push(field);
      }
      if (this.props.schema.fields[field].type === "dict") {
        hasDict = true;
        dictFieldKeys.push(field);
      }
    });

    if (hasDate || hasDict) {
      dateFieldKeys.forEach(field => data[field] = moment(data[field]))
      dictFieldKeys.forEach(field => data[field] = data[field].toString())
    }

    return data;
  }

  buildForm() {
    const {fields, name} = this.props.schema;
    let initialValues = Object.keys(fields).reduce(
      (prev, curr) => ({...prev, [curr]: fields[curr]["initial"] ?? ""}),
      {}
    );

    return (
      <Form
        ref={this.formRef}
        key={this.props.data}
        labelAlign={"left"}
        layout={this.props.layout}
        id={this.props.id}
        name={name}
        requiredMark={!this.props.readonly}
        initialValues={this.props.data ? this.dataPreprocess() : initialValues}
        onFinish={this.props.readonly ? undefined : this.props.actions.onSubmit}
        onFinishFailed={this.props.readonly ? undefined : this.props.actions.onError}
      >
        {this.getFields(fields)}
        {this.props.readonly ? undefined : this.renderButtons()}
      </Form>
    );
  }

  render() {
    return this.buildForm();
  }
}

UniversalForm.propTypes = {
  actions: PropTypes.objectOf(PropTypes.func),
  schema: PropTypes.object.isRequired,
  readonly: PropTypes.bool,
  data: PropTypes.object,
  labelsSpan: PropTypes.number,
  wrappersSpan: PropTypes.number,
  id: PropTypes.string,
}

UniversalForm.defaultProps = {
  actions: {},
  readonly: false,
  // data: {},
  labelsSpan: 12,
  wrappersSpan: 12,
}

export default UniversalForm;
