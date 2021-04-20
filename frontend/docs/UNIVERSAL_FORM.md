## Universal form usage

To use this component you should add it in your markup and pass `schema` and `actions` props in it. `readonly`, `data` and `layout` is **optional**.

`readonly` flag used to make form only readable, not to edit. `data` is an object representing form data to view or edit: `{formField: itsValue}`. `layout` exists for styling. Default is `"horizontal"`, other options is `"inline"` and `"vertical"`. 

*Example*:

```js
import { UniversalForm } from "../../components/universalForm";
import { DemoSchema } from "./config";

const actions = {
  onSubmit: (value) => {
    console.log(value);
  },
  onClear: (ref) => {
    ref.resetFields();
    console.log("onClear");
  },
  onAdd: (ref) => {
    ref.setFieldsValue({ firstName: "Johnny" });
    console.log("onAdd");
  },
  onError: (e) => {
    console.log("onError: ", e);
  },
};

const data = {
  firstName: "SomeName",
  lastName: "SomeLName",
  age: "20",
  checkbox: true,
  telephone: "375298008080",
  email: "someemail@mail.com",
  team: "Unicorns of Love",
};

class MainLayout extends React.Component {
    render() {
        return (<UniversalForm schema={DemoSchema} actions={actions} readonly data={data} layout={"horizontal"}/>);
    }
}
```

#### Readonly usage

```js
<UniversalForm schema={DemoSchema} readonly data={data}>
```

#### Edit usage

```js
<UniversalForm schema={DemoSchema} actions={actions} data={data}>
```

#### Create usage

```js
<UniversalForm schema={DemoSchema} actions={actions}>
```

### `Schema` structure

| Props | Description |
| - | - |
| `name` | Form name. Will be the prefix of Field id. |
| `fields` | Object describing form fields and their options. Keys used as field names. |

### `Actions` structure

All actions must be *functions()*. `onSubmit` is only neccessary. Others are optional: `onClear, onError, onAdd`.

| Props | Description | What should be? |
| - | - | - |
| `onSubmit` | Contains the function which will be executed after pressing "submit" button if all fields filled **correctly**. | `function(formValues)` |
| `onError` | Contains the function which will be executed after pressing "submit" button if the fields filled **incorrectly**. | `function(formErrors)` |
| `onClear` | If exists draw the clear button in form footer. Reffering to form through it's `ref`. Read about `ref` methods in "handler methods table". | `function(ref)` |
| `onAdd` | If exists draw the add button in form footer. Reffering to form through it's `ref`. Read about `ref` methods in "handler methods table". | `function(ref)` |

### Fields props table
| Fields props | Description | What should be? |
| - | - | - |
| `type` | Contains string representing type of field | `"number", "string", "checkbox", "enum"` |
| `label` | Contains field label (will be rendered behind the field as it's description) | `string` or `HTML (div, image...)` |
| `rules` | Contains array of rules to validate the field. Always must be an array. Uses predefined validations from Validator module: `required, longerThan, shorterThan, lessThan, moreThan, equal, notEqual, regex, mail, phone`. | `[array]` of `Validator.*type*(pattern, message)` |
| `initial` | Contains the initial value of described field. |`string` |
| `options` | Enum field should have this prop. It consists of all enum options. | `[array]` of `strings` |

### Handler methods table
| Handler `ref` methods | Description | What should be? | 
| - | - | - |
| `getFieldError` | Get the error messages by the field name| `(name: NamePath) => string[]` |
| `getFieldInstance` | Get field instance| `(name: NamePath) => any` |
| `getFieldsError` | Get the error messages by the fields name. Return as an array| `(nameList?: NamePath[]) => FieldError[]` |
| `getFieldsValue` | Get values by a set of field names. Return according to the corresponding structure. Default return mounted field value, but you can use getFieldsValue(true) to get all values|	`(nameList?: NamePath[], filterFunc?: (meta: { touched: boolean, validating: boolean }) => boolean) => any` |
| `getFieldValue` | Get the value by the field name	| `(name: NamePath) => any` |
| `isFieldsTouched` | Check if fields have been operated. Check if all fields is touched when allTouched is true	| `(nameList?: NamePath[], allTouched?: boolean) => boolean` |
| `isFieldTouched` | Check if a field has been operated | `(name: NamePath) => boolean` |
| `isFieldValidating` |	Check fields if is in validating| `(name: NamePath) => boolean` |
| `resetFields` | Reset fields to initialValues| `(fields?: NamePath[]) => void` |
| `scrollToField` |	Scroll to field position| `(name: NamePath, options: [ScrollOptions]) => void` |
| `setFields` |	Set fields status| `(fields: FieldData[]) => void` |
| `setFieldsValue` | Set fields value| `(values) => void` |
| `submit` | Submit the form. It's same as click submit button | `() => void `|
| `validateFields` | Validate fields | `(nameList?: NamePath[]) => Promise` |

Example of typical schema:

```js
import { Validator } from "../../components/universalForm";

export default {
  name: "registration",

  fields: {
    firstName: {
      type: "string",
      label: "First name",
      initial: "John",
      rules: [Validator.required(), Validator.longerThan(7)],
    },

    lastName: {
      type: "string",
      label: "Last name",
      rules: [
        Validator.required("Last name is required"),
        Validator.shorterThan(10),
      ],
    },

    age: {
      type: "number",
      label: "Age",
      initial: "36",
      rules: [
        Validator.notEqual(18),
        Validator.moreThan(5),
        Validator.lessThan(99),
      ],
    },

    telephone: {
      type: "string",
      label: "Telephone",
      rules: [
        Validator.required(),
        Validator.regex(
          "^[+]{0,1}[1-9]{1,4}[(]{0,1}[0-9]{1,4}[)]{0,1}[0-9]{6,8}$",
          "Wrong format! Must be: +XXX(XX)XXXXXXX!"
        ),
        Validator.phone(),
      ], /// In this example "regex" and "phone" validators doing literally same thing.
    },

    email: {
      type: "string",
      label: "Email",
      rules: [Validator.email("Wrong format! Be careful!")],
    },

    checkbox: {
      type: "checkbox",
      label: "What?",
      initial: true,
      rules: [Validator.required("WHAT!")],
    },

    team: {
      type: "enum",
      label: "Team",
      options: ["Na'Vi", "Unicorns of Love", "Cloud9", "Ninjas in Pijamas"],
      rules: [Validator.required("Choose his team!")],
    },
  },
};
```
