## Universal table usage
To use this component you should add it in your markup with `data` and `columns` props. `actions` and `schema` props are **optional**.

Example:

```js
import UniversalTable from "../../components/universalTable/UniversalTable";
import schema from "./config";
import filterSchema from "./filterConfig";

const tableData = [
  {
    key: "1",
    firstName: "Ilya",
    lastName: "Degtyarik",
    age: "20",
    checkbox: true,
    telephone: "375298323063",
    email: "degtyarik.ilya@yandex.ru",
    team: "Ninjas in Pijamas",
  },
  {
    key: "2",
    firstName: "Vasya",
    lastName: "Pupkin",
    age: "36",
    checkbox: true,
    telephone: "88005553535",
    email: "prosche.pozvonit@chemzanim.at",
    team: "Na'Vi",
  },
  {
    key: "3",
    firstName: "Vladimir",
    lastName: "Puptin",
    age: "28",
    checkbox: false,
    telephone: "88005553536",
    email: "prosche.pozvonit@chemzanimatbelaru.si",
    team: "Na'Vi",
  },
];

const tableColumns = {
  firstName: {
    label: "First name",
    sorter: (a, b) => a.firstName.length - b.firstName.length,
  },
  lastName: "Last name",
  age: { label: "Age", sorter: (a, b) => a.age - b.age },
  telephone: "Mobile number",
  email: "Email",
  team: "Team",
};

const tableActions = {
  onDelete: (value) => {
    console.log("Row deleted: ", value);
  },
  onAdd: (value) => {
    console.log("New row added: ", value);
  },
  onEdit: (value) => {
    console.log("Row edited to: ", value);
  },
};

class MainLayout extends React.Component {
  render() {
    return (
      <UniversalTable
        schema={schema}
        data={tableData}
        actions={tableActions}
        columns={tableColumns}
      />
    );
  }
}
```

#### Readonly usage

```js
{<UniversalTable data={tableData} columns={tableColumns}>
```

#### Edit usage

```js
{<UniversalTable schema={schema} actions={tableActions} data={tableData} columns={tableColumns}>}
```

### Overall

`data` prop is used for filling table with information. It **should** always be an array of objects where `{fieldName: itsValue}`. 

`columns` prop used to create columns from object where `{fieldName: "Its Label"}` or `{fieldName: { label: "Its Label", sorter: sorterFunction(a, b)}}`. See an example:

```js
const tableColumns = {
  firstName: {
    label: "First name",
    sorter: (a, b) => a.firstName.length - b.firstName.length,
  },
  lastName: "Last name",
  age: { label: "Age", sorter: (a, b) => a.age - b.age },
  telephone: "Mobile number",
};
```

`schema` used only if user want's to create some new records like represented in table. To create it use [universal form documentation](./UNIVERSAL_FORM.md).

`actions` prop is used to define which actions user will be able to do on the table. 

### `Actions` structure

All actions must be *functions()*. `onSubmit` is only neccessary. Others are optional: `onClear, onError, onAdd`.

| Props | Description | What should be? |
| - | - | - |
| `onEdit` | Creates `edit` button connected to it's row in table. Accepts ready to edit row values. | `function(rowValues)` |
| `onAdd` | Creates `add` button in table footer. Accepts new created values. | `function(newValues)` |
| `onDelete` | Creates `delete` button connected to it's row in table. Accepts deleted row values. | `function(deletedValues)` |

