const Form = ({ fields, formData, setFormData, onSubmit }) => {
  return (
    <form onSubmit={onSubmit} className="space-y-3">
      {fields.map((field) => (
        <input
          key={field}
          placeholder={field}
          className="border p-2 w-full"
          value={formData[field] || ""}
          onChange={(e) =>
            setFormData({ ...formData, [field]: e.target.value })
          }
        />
      ))}
      <button className="bg-blue-500 text-white px-4 py-2">Submit</button>
    </form>
  );
};

export default Form;