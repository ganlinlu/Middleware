/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include <memory.h> /* for memset */
#include "mathService.h"

/* Default timeout can be changed using clnt_control() */
static struct timeval TIMEOUT = { 25, 0 };

struct Math *
mathoperate_1(struct Math *argp, CLIENT *clnt)
{
	static struct Math clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	if (clnt_call (clnt, mathOperate,
		(xdrproc_t) xdr_Math, (caddr_t) argp,
		(xdrproc_t) xdr_Math, (caddr_t) &clnt_res,
		TIMEOUT) != RPC_SUCCESS) {
		return (NULL);
	}
	return (&clnt_res);
}
