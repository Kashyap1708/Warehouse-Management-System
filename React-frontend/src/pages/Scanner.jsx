

import { Html5QrcodeScanner } from "html5-qrcode";
import { useEffect } from "react";

const Scanner = () => {

  useEffect(() => {
    const scanner = new Html5QrcodeScanner(
      "reader",
      { fps: 10, qrbox: 250 },
      false
    );

    scanner.render(
      (decodedText) => {
        alert("Scanned: " + decodedText);
      },
      (error) => console.log(error)
    );
  }, []);

  return (
    <div>
      <h2 className="text-xl font-bold mb-4">Scan Barcode</h2>
      <div id="reader"></div>
    </div>
  );
};

export default Scanner;