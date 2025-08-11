#!/bin/bash
IMP_USER=inv_user
IMP_PASS=inv_password
SERVICE=XEPDB1
DUMPFILE=$1
if [ -z "$DUMPFILE" ]; then
  echo "Uso: restore.sh archivo.dmp"; exit 1;
fi
impdp ${IMP_USER}/${IMP_PASS}@${SERVICE} schemas=INV_USER dumpfile=${DUMPFILE} logfile=import_${DUMPFILE}.log
echo "Import terminado: ${DUMPFILE}"
