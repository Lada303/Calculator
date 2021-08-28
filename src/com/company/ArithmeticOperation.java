package com.company;

public class ArithmeticOperation {
    char Oper;
    int Num1;
    int Num2;
    ArithmeticOperation (char op, int n1, int n2) {Oper = op; Num1=n1; Num2=n2;}

    int result (){
        if (this.Oper=='+') {return this.Num1 + this.Num2;}
        if (this.Oper=='-') {return this.Num1 - this.Num2;}
        if (this.Oper=='*') {return this.Num1 * this.Num2;}
        if (this.Oper=='/') {return this.Num1 / this.Num2;}
       return 0;
    }


}
