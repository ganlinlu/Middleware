/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "mathService.h"

bool_t
xdr_Math (XDR *xdrs, Math *objp)
{
	register int32_t *buf;

	 if (!xdr_int (xdrs, &objp->op))
		 return FALSE;
	 if (!xdr_double (xdrs, &objp->arg1))
		 return FALSE;
	 if (!xdr_double (xdrs, &objp->arg2))
		 return FALSE;
	 if (!xdr_double (xdrs, &objp->result))
		 return FALSE;
	return TRUE;
}
