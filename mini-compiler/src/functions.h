#pragma once

string Replace(string input,string from,string to);
string CorrectWhiteSpace(string str,string what="");
string trim(string input);
unsigned int start(string str,unsigned int pos);
unsigned int end(string str,unsigned int pos,bool skip=false);
unsigned int GetPos(string str,unsigned int pos,bool goleft);
string Correct(string input);
string ChangeOperators(string str,vector<string> from,string to);
bool isChar(char input);
bool isNum(char input);
bool isName(string input);
bool isInt(string input);
bool isFloat(string input);
bool isBool(string input);
bool isChar(string input);
bool isString(string input);
bool isConst(string input);
bool isReserved(string input);
int checkParanteses(string input);
vector<string> Split(string input,char what,bool DontPass=false);
unsigned int endOfCode(string code);
string Remove(string input,string start,string end);
string toString(System::String^ input);
