#include <iostream>

using namespace std;

struct fecha {
    short D;
    short M;
    short A;
    
    int comparar(const fecha &F) const {
        if (A > F.A)
            return -1;
        else if (A < F.A)
            return 1;
        else if (M > F.M)
            return -1;
        else if (M < F.M)
            return 1;
        else if (D > F.D)
            return -1;
        else if (D < F.D)
            return 1;
        else
            return 0;
    }
    
    void print() const {
        cout << A << "-" << M << "-" << D << endl;
    }
};

struct producto {
    char Descripcion[100];
    float Precio;
    int Existencia;
    int ID;
    
    int comparar(const producto &P) const {
        if (Precio > P.Precio)
            return -1;
        else if (Precio < P.Precio)
            return 1;
        else
            return 0;
    }
    
    void print() const {
        cout <<"Descripcion:  " << Descripcion << endl;
        cout << "Precio:  " << Precio << endl;
        cout << "Existencia:  " << Existencia << endl;
        cout << "ID:  " << ID << endl;
    }
};

int main() {
    int c1, c2;
    fecha F1 = {10, 5, 2010};
    fecha F2 = {2, 12, 1980};
    producto P1 = {"Pecsi", 18.50F, 36, 666};
    producto P2 = {"Picafresa", 5.0F, 51, 9876};
    
    c1 = F1.comparar(F2);
    c2 = P1.comparar(P2);
    
    if (c1 > 0) {
        F1.print();
        F2.print();
    } else {
        F2.print();
        F1.print();
    }
    
    if (c2 > 0) {
        P1.print();
        P2.print();
    } else {
        P2.print();
        P1.print();
    }
}
