import React from "react";
import {Form, Row, Col} from "antd";

import actionsCreator from "./ActionsCreator";
import fieldsCreator from "./FieldsCreator";

import "./styles.css";

import moment from "moment";

class UniversalForm extends React.Component {
  formRef = React.createRef();

  renderButtons() {
    const actions = this.props.actions;
    return this.props.cols
      ? <Row>
        {Object.keys(actions).map((action) => {
          return actionsCreator[action](this.formRef, actions[action]);
        })}
      </Row>
      : <Form.Item>
        {Object.keys(actions).map((action) => {
          if (action === "onSubmit" && this.props.id) {
            return undefined;
          }
          return actionsCreator[action](this.formRef, actions[action]);
        })}
      </Form.Item>;
  }

  formDependsOnStyling = (field) => {
    if (field.dependsOnField && this.formRef.current) {
      return this.formRef.current.getFieldValue(field.dependsOnField) !== field.dependsOnValue;
    }
    return false;
  }

  nestedWrapper = (fields, current) => {
    if (fields[current].dependsOnField && this.formRef.current) {
      return (
        <Form.Item shouldUpdate noStyle>
          {() =>
            this.formRef.current.getFieldValue(fields[current].dependsOnField) == fields[current].dependsOnValue &&
              this.getFieldItem(fields, current)
          }
        </Form.Item>
      )
    }
    return this.getFieldItem(fields, current);
  }

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
          fields[current].type === "checkbox" ? "checked" : undefined
        }
        colon={fields[current].type !== "checkbox"}
      >
        {fieldsCreator[fields[current].type](
          this.props.readonly,
          fields[current].options
        )}
      </Form.Item>
    )
  }

  getFields = (fields) => {
    if (!this.props.cols) {
      return Object.keys(fields).map((field, index) => {
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

  rebuildDataIfDates() {
    let data = this.props.data;
    let hasDate = false;
    let dateFieldKeys = [];
    Object.keys(this.props.schema.fields).map(field => {
      if (this.props.schema.fields[field].type === "date") {
        hasDate = true;
        dateFieldKeys.push(field);
      }
    });
    if (hasDate) {
      dateFieldKeys.forEach(field => data[field] = moment(data[field]))
    }
    return data;
  }

  buildForm() {
    const {fields, name} = this.props.schema;
    let initialValues = Object.keys(fields).reduce(
      (prev, curr) => ({...prev, [curr]: fields[curr]["initial"]}),
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
        initialValues={this.props.data ? this.rebuildDataIfDates() : initialValues}
        onFinish={this.props.readonly ? undefined : this.props.actions.onSubmit}
        onFinishFailed={this.props.readonly ? undefined : this.props.actions.onError}
      >
        {this.getFields(fields)}
        {this.props.readonly ? undefined : this.renderButtons()}
      </Form>
    );
  }

  render() {
    const Form = this.buildForm();
    return Form;
  }
}

export default UniversalForm;
