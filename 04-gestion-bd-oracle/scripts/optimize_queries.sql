CREATE INDEX idx_productos_nombre ON inv_user.productos(nombre);

EXPLAIN PLAN FOR
SELECT * FROM inv_user.productos WHERE nombre = 'TuProducto';

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY());
