import { useState } from "react";
import { getBarcode } from "../services/api";

const Barcode = () => {
  const [sku, setSku] = useState("");
  const [image, setImage] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleGenerate = async () => {
    try {
      setLoading(true);
      const res = await getBarcode(sku);

      // Convert blob to image URL
      const imageUrl = URL.createObjectURL(res.data);
      setImage(imageUrl);

    } catch (err) {
      alert("Error generating barcode");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="p-4 bg-white shadow rounded">
      <h2 className="text-xl mb-4">Generate Barcode</h2>

      <input
        type="text"
        placeholder="Enter SKU"
        value={sku}
        onChange={(e) => setSku(e.target.value)}
        className="border p-2 w-full mb-3"
      />

      <button
        onClick={handleGenerate}
        className="bg-blue-500 text-white px-4 py-2"
      >
        Generate
      </button>

      {loading && <p className="mt-3">Loading...</p>}

      {image && (
        <div className="mt-4">
          <img src={image} alt="barcode" className="w-64 h-64" />
        </div>
      )}
    </div>
  );
};

export default Barcode;