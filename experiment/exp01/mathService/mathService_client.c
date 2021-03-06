/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "mathService.h"


void
mathservice_1(char *host)
{
	CLIENT *clnt;
	struct Math  *result_1;
	struct Math  mathoperate_1_arg;

	// add by ganlin on 2020/03/09

	char c;
	printf("选择你进行的运算：0：加法；1：减法；2：对数\n");
	c = getchar();
	switch(c){
		case '0':
			mathoperate_1_arg.op = ADD;
			break;
		case '1':
			mathoperate_1_arg.op = SUB;
			break;
		case '2':
			mathoperate_1_arg.op = LOG;
			break;
		default:
			printf("错误的输入！！\n");
			exit(1);
	}
	printf("请输入两个整数\n");
	scanf("%lf %lf", &mathoperate_1_arg.arg1, &mathoperate_1_arg.arg2);

	// add end


#ifndef	DEBUG
	clnt = clnt_create (host, MATHSERVICE, VERSION, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */

	result_1 = mathoperate_1(&mathoperate_1_arg, clnt);
	if (result_1 == (struct Math *) NULL) {
		clnt_perror (clnt, "call failed");
	}
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
	// add by ganlin on 2020/09/09
	
	printf("计算的结果为：%.3f \n", result_1->result);
	
	// end add
}


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	mathservice_1 (host);
exit (0);
}
