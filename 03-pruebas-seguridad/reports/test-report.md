# Informe de pruebas - Proyecto Inventario

## Resumen
Se ejecutaron pruebas unitarias, de integración y pruebas manuales para verificar inyección SQL y comportamiento funcional.

## Casos de prueba (ejemplos)
1. Crear producto -> esperado: 200 OK y producto creado.
2. Registrar movimiento OUT con stock insuficiente -> esperado: 400 Bad Request.
3. Prueba de inyección SQL: input `x' OR '1'='1` en nombre -> esperado: no devolver registros (usar PreparedStatement).

## Resultados
- Unit tests: pasar/ejecutar con `mvn test`.
- Vulnerabilidad de inyección: mitigada usando PreparedStatement / JPA (parametrización).

## Recomendaciones
- Usar `PreparedStatement` para JDBC.
- Validar entradas (longitud, patrones).
- Añadir tests automatizados que verifiquen cadenas maliciosas.
