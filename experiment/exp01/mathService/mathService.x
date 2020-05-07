const ADD = 0;  
const SUB = 1;  
const LOG = 2;  
  
struct Math{  
    int op;  
    double arg1;  
    double arg2;  
    double result;  
};  
 
program MATHSERVICE {  
version VERSION {  
struct Math mathOperate(struct Math)=1;  
} = 1;  
} = 2017013164;  