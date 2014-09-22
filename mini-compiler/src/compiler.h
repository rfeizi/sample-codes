#pragma once

enum Types{
	T_Void,
	T_Int,
	T_Double,
	T_Float,
	T_Char,
	T_Bool,
	T_Unknown,
	T_Same
};
class BaseType{
protected:
	string Name;
	Types Type;
public:
	bool SetName(string name);
	bool SetType(string type);
	void SetType(Types type);
	string GetName(){return Name;}
	Types GetType(){return Type;}
};

class Value : public BaseType{
private:
	bool GotValue;
public:
	Value(string name="",Types type=T_Unknown,bool gotValue=false);
};

class Function : public BaseType{
private:
	vector<Value> Parameters;
public:
	Function(string name="",Types type=T_Unknown);
	void AddParameter(Value val){Parameters.push_back(val);}
	bool AddParameter(string define);
	Value GetValue(unsigned int index){return Parameters[index];}
	unsigned int ValuesSize(){return Parameters.size();}
};
class Block : public BaseType{
private:
	bool Returned;
	bool HasIOStream;
	bool HasNameSpace;
	Block * Parent;
	vector<Value> Values;
	vector<Function> Functions;
public:
	unsigned int StartLine;
	Block(Block * parent=NULL,string name="",unsigned int startLine=1);
	Block(Block &block);
	Block* GetParent(){return Parent;}
	vector<Value> GetValues(){return Values;}
	vector<Function> GetFunctions(){return Functions;}
	Function GetFunction(string name);
	Value GetValue(string name);
	bool isValue(string name);
	bool isFunction(string name);
	bool CheckLValue(string str,unsigned int line);
	bool CheckRValue(string str,unsigned int line);
	void Define(Value value,unsigned int line);
	void Define(Function function,unsigned int line);
	void Define(string type,string def,unsigned int line);
	Types ParseCode(string code,unsigned int line,Types ret,bool isLValue=false);
	unsigned int FunctionParams(string name);
	void Compile(string str);
	Types Parse(string code,unsigned int line,Types ret);
	void Header(string head);
	Types GetType(string code);
	Types GetType(){return BaseType::GetType();}
	void Return(unsigned int line);
	void CinCout(string code,unsigned int line);
};
Block initGlobal();
bool TypesMatch(Types type1,Types type2);
string TypeName(Types type);
