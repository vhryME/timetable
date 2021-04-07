import React from "react";
import { Form } from "antd";

import actionsCreator from "./ActionsCreator";
import fieldsCreator from "./FieldsCreator";

class UniversalForm extends React.Component {
  constructor(props) {
    super(props);
    this.layout = {
      labelCol: {
        span: 2,
      },
      wrapperCol: {
        span: 21,
      },
    };

    this.tailLayout = {
      wrapperCol: {
        offset: 2,
        span: 21,
      },
    };
  }

  formRef = React.createRef();

  renderButtons() {
    const actions = this.props.actions;
    return Object.keys(actions).map((action) => {
      return actionsCreator[action](this.formRef, actions[action]);
    });
  }

  buildLayout() {
    if (this.props.layout && this.props.layout !== "horizontal") {
      this.layout = null;
    }

    if (this.props.layout === "vertical" || this.props.layout === "inline") {
      this.tailLayout = null;
    }
  }

  buildForm() {
    this.buildLayout();
    const { fields, name } = this.props.schema;
    let initialValues = Object.keys(fields).reduce(
      (prev, curr) => ({ ...prev, [curr]: fields[curr]["initial"] }),
      {}
    );

    if (this.props.data && typeof this.props.data === "object") {
      initialValues = this.props.data;
    }

    return (
      <Form
        ref={this.formRef}
        {...this.layout}
        layout={this.props.layout}
        name={name}
        initialValues={initialValues}
        onFinish={this.props.readonly ? undefined : this.props.actions.onSubmit}
        onFinishFailed={
          this.props.readonly ? undefined : this.props.actions.onError
        }
      >
        {Object.keys(fields).map((field) => {
          return (
            <Form.Item
              key={field}
              label={fields[field].label}
              name={field}
              rules={fields[field].rules}
              valuePropName={
                fields[field].type === "checkbox" ? "checked" : undefined
              }
              colon={fields[field].type === "checkbox" ? false : true}
            >
              {fieldsCreator[fields[field].type](
                this.props.readonly,
                fields[field].options
              )}
            </Form.Item>
          );
        })}
        {this.props.readonly ? undefined : (
          <Form.Item {...this.tailLayout}>{this.renderButtons()}</Form.Item>
        )}
      </Form>
    );
  }

  render() {
    const Form = this.buildForm();
    return Form;
  }
}

export default UniversalForm;
