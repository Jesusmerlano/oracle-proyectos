-- EJEMPLO VULNERABLE (no usar)
SELECT * FROM productos WHERE nombre = '" || :userInput || "';
