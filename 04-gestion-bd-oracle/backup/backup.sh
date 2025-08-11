#!/bin/bash
EXP_USER=inv_user
EXP_PASS=inv_password
SERVICE=XEPDB1
DUMPFILE=inv_user_$(date +%Y%m%d_%H%M).dmp
expdp ${EXP_USER}/${EXP_PASS}@${SERVICE} schemas=INV_USER dumpfile=${DUMPFILE} logfile=export_${DUMPFILE}.log
echo "Dump creado: ${DUMPFILE}"
