const Table = ({ data }) => {
  return (
    <table className="w-full border">
      
      <thead className="bg-gray-200">
        <tr>
          <th>ID</th>
          <th>Quantity</th>
          <th>Product Name</th>
          <th>Storage Bin</th>
        </tr>
      </thead>

      <tbody>
        {data.map((row) => (
          <tr key={row.id}>
            <td>{row.id}</td>
            <td>{row.quantity}</td>
            <td>{row.product?row.product.name:"N/A"}</td>
            <td>
              {row.storageBin
                ? `${row.storageBin.zone}-${row.storageBin.aisle}`
                : "N/A"}
            </td>
          </tr>
        ))}
      </tbody>

    </table>
  );
};
export default Table;