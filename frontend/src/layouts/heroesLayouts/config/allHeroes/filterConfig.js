export const schema = {
  name: "heroesFilter",

  fields: {
    name: {
      type: "string",
      label: "Name",
    },

    roleId: {
      type: "dict",
      dictName: "role",
      label: "Role",
    },

    dateOfCreation: {
      type: "string",
      label: "Creation date",
    },

    isMelee: {
      type: "checkbox",
      label: "Is melee?",
    },
  },
};

export const actions = (context) => {
  return {
    onSubmit: (value) => {
      context.props.getHeroesFiltered(value);
    },
    onClear: (ref) => {
      ref.resetFields();
      context.props.getAllHeroes();
    },
  }
}
