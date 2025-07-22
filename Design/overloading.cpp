// same name different arguments
int test() { }
int test(int a) { }
float test(double a) { }
int test(int a, double b) { }



// Error code
int test(int a) { }
double test(int b){ }