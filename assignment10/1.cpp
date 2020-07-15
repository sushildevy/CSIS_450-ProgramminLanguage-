#include <iostream>
using namespace std;
void swap(int&  a, int& b) {
  int temp;
  temp = a;
  a = b;
  b = temp;
}

int main() {
  int value = 2, list[5] = {1, 3, 5, 7, 9};
  cout<<"When Pass by refrence: "<<endl<<endl;
  cout<<"after 1st swap"<<endl;
  swap(value, list[0]);
  cout<<"Value: "<<value<<"  List[0]: "<<list[0]<<endl;
  cout<<"list: ";
  for(int i=0; i<5;i++)
  cout<<list[i]<<" ";
  cout<<endl<<endl;
  swap(list[0], list[1]);
  cout<<"after 2nd swap"<<endl;
  cout<<"value: "<<value<<"  List[0]: "<<list[0]<<"  List[1]: "<<list[1]<<endl;
  cout<<"list: ";
  for(int i=0; i<5;i++)
  cout<<list[i]<<" ";
  cout<<endl<<endl;
  swap(value, list[value]);
  cout<<"after 3rd swap"<<endl;
  cout<<"value: "<<value<<"  List[value]: "<<list[value]<<endl;
  cout<<"list: ";
  for(int i=0; i<5;i++)
  cout<<list[i]<<" ";
  cout<<endl;


  return 0;
}