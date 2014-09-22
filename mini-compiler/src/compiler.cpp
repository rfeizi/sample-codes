#include "stdafx.h"
#include <string>
#include <vector>
using namespace std;
#include "error.h"
#include "functions.h"
#include "compiler.h"

bool BaseType::SetName(string name)
{
	Name="";
	if(!isName(name))
		return false;
	Name=name;
	return true;
}
bool BaseType::SetType(string type)
{
	Type=T_Unknown;
	if(type=="int")
	{
		Type=T_Int;
		return true;
	}
	if(type=="float")
	{
		Type=T_Float;
		return true;
	}
	if(type=="double")
	{
		Type=T_Double;
		return true;
	}
	if(type=="char")
	{
		Type=T_Char;
		return true;
	}
	if(type=="bool")
	{
		Type=T_Bool;
		return true;
	}
	if(type=="void")
	{
		Type=T_Void;
		return true;
	}
	return false;
}

void BaseType::SetType(Types type)
{
	Type=type;
}
Value::Value(string name,Types type,bool gotValue)
{
	SetName(name);
	SetType(type);
	GotValue=gotValue;
}
Function::Function(string name,Types type)
{
	SetName(name);
	SetType(Type);
	Parameters.clear();
}
bool Function::AddParameter(string define)
{
	define=CorrectWhiteSpace(define);
	vector<string> pars=Split(define,' ');
	if(pars.size()!=2)
		return false;
	Value val;
	if(!val.SetName(pars[1]))
		return false;
	if(!val.SetType(pars[0]))
		return false;
	AddParameter(val);
	return true;
}
Block::Block(Block * parent,string name,unsigned int startLine)
{
	Parent = parent;
	SetName(name);
	SetType(T_Unknown);
	Returned=false;
	if(parent==NULL)
	{
		HasNameSpace=false;
		HasIOStream=false;
	}else{
		HasNameSpace=parent->HasNameSpace;
		HasIOStream=parent->HasIOStream;
	}
	Values.clear();
	Functions.clear();
	StartLine=startLine;
}
Block::Block(Block &block)
{
	Parent=block.GetParent();
	SetName(block.GetName());
	SetType(block.GetType());
	HasNameSpace=block.HasNameSpace;
	HasIOStream=block.HasIOStream;
	Returned=block.Returned;
	Values=block.GetValues();
	Functions=block.GetFunctions();
	StartLine=block.StartLine;
}
Function Block::GetFunction(string name)
{
	if(Parent!=NULL)
		return Parent->GetFunction(name);
	for(unsigned int i=0;i<Functions.size();i++)
	{
		if(Functions[i].GetName()==name)
			return Functions[i];
	}
	return Function();
}
Value Block::GetValue(string name)
{
	for(unsigned int i=0;i<Values.size();i++)
	{
		if(Values[i].GetName()==name)
			return Values[i];
	}
	if(Parent!=NULL)
		return Parent->GetValue(name);
	return Value();
}
unsigned int Block::FunctionParams(string name)
{
	return GetFunction(name).ValuesSize();
}
bool Block::CheckLValue(string str,unsigned int line)
{
	if(isReserved(str))
	{
		error.AddError("Cannot use '"+str+"' as a value",line);
		return false;
	}
	str=trim(str);
	if(str[0]=='(' && str[str.length()-1]==')')
	{
		str=str.erase(0,1);
		str=str.erase(0,1);
	}
	if(!isName(str))
	{
		error.AddError("'=' : left operand must be l-value!",line);
		return false;
	}
	if(!isValue(str))
	{
		error.AddError("'"+str+"' : undeclared identifier",line);
		return false;
	}
	return true;
}
bool Block::CheckRValue(string str,unsigned int line)
{
	if(isName(str)){
		if(!isValue(str))
		{
			error.AddError("'"+str+"' : undeclared identifier",line);
			return false;
		}
		return true;
	}else if(isConst(str)){
		return true;
	}else{
		if(isReserved(str)){
			error.AddError("Cannot use '"+str+"' as a value",line);
			return false;
		}
		error.AddError("'"+str+"' : Syntax error",line);
		return false;
	}
}
Types Block::ParseCode(string code,unsigned int line,Types ret,bool isLValue)
{
	unsigned int tmp;
	if(code=="")
	{
		error.AddError("missing value!",line);
		return T_Unknown;
	}
	if(code[0]=='(' && code.find(")")==code.length()-1)
		code=code.substr(1,code.length()-2);
	unsigned int pPos=code.find("(");
	if(pPos!=string::npos)
	{
		tmp=start(code,pPos);
		string fname=code.substr(tmp,pPos-tmp);
		tmp=end(code,pPos,true);
		if(fname=="")
		{
			return ParseCode(code.substr(pPos+1,code.length()-pPos-2),line,ret);
		}
		if(!isFunction(fname))
		{
			error.AddError("'"+fname+"': undeclared function",line);
			return T_Unknown;
		}
		vector<string> params;
		params=Split(code.substr(pPos+1),',');
		if(params.size()!=FunctionParams(fname))
		{
			char temp[10];
			sprintf(temp,"%d",params.size());
			error.AddError("'"+fname+"' does not take "+string(temp)+" parametrs!",line);
			return T_Unknown;
		}
		Function func=GetFunction(fname);
		Types retType=func.GetType();
		if(!TypesMatch(retType,ret))
		{
			error.AddError("cannot convert from '"+TypeName(retType)+"' to '"+TypeName(ret)+"'",line);
			return T_Unknown;
		}
		if(func.ValuesSize()>0)
		{
			Types parType,parRet=func.GetValue(0).GetType();
			for(unsigned int i=0;i<params.size();i++)
			{
				if(retType==T_Same)
					parType=parRet;
				else
					parType=func.GetValue(i).GetType();
				parRet=ParseCode(params[i],line,parType,(fname=="___EQQ"&&i==0)?true:false);
			}
			if(retType==T_Same)
				return parRet;
			else
				return retType;
		}
		return func.GetType();
	}else{
		if(isLValue)
		{
			if(!CheckLValue(code,line))
				return T_Unknown;
		}else{
			if(!CheckRValue(code,line))
				return T_Unknown;
		}
		Types t=GetType(code);
		if(!TypesMatch(t,ret))
		{
			error.AddError("cannot convert from '"+TypeName(t)+"' to '"+TypeName(ret)+"'",line);
			return T_Unknown;
		}
		return t;
	}
}
bool Block::isValue(string name)
{
	if(!Values.empty())
	{
		for(unsigned int i=0;i<Values.size();i++)
		{
			if(Values[i].GetName()==name)
				return true;
		}
	}
	if(Parent!=NULL)
		return Parent->isValue(name);
	return false;
}
bool Block::isFunction(string name)
{
	if(Parent!=NULL)
		return Parent->isFunction(name);
	for(unsigned int i=0;i<Functions.size();i++)
	{
		if(Functions[i].GetName()==name)
			return true;
	}
	return false;
}
void Block::Define(Value value,unsigned int line)
{
	if(isValue(value.GetName()))
	{
		error.AddError("'"+value.GetName()+"' : redefinition",line);
		return;
	}
	if(isFunction(value.GetName()))
	{
		error.AddError("Cannot redefine function '"+value.GetName()+"' as variable",line);
		return;
	}
	Values.push_back(value);
}
void Block::Define(Function function,unsigned int line)
{
	if(Parent!=NULL)
	{
		error.AddError("'"+function.GetName()+"' : local function definitions are illegal",line);
		return;
	}
	if(isValue(function.GetName()))
	{
		error.AddError("Cannot redefine variable '"+function.GetName()+"' as function",line);
		return;
	}
	if(isFunction(function.GetName()))
	{
		error.AddError("'"+function.GetName()+"' : redefinition of function",line);
		return;
	}
	Functions.push_back(function);
}
void Block::Define(string type,string def,unsigned int line)
{
	if(type=="return")
	{
		Parse(def,line,Type);
		if(def!="")
			Return(line);
		return;
	}
	if(type=="cin"||type=="cout")
	{
		CinCout(type+" "+def,line);
		return;
	}
	def=CorrectWhiteSpace(def,"=");
	vector<string> defines=Split(def,',');
	for(unsigned int i=0;i<defines.size();i++)
	{
		if(defines[i].find("=")!=string::npos)
		{
			vector<string> tmp=Split(defines[i],'=');
			if(tmp.size()!=2)
			{
				error.AddError("'=' : Syntax error",line);
				return;
			}
			Value val;
			if(!val.SetName(tmp[0]))
			{
				error.AddError("'=' : left operand must be l-value!",line);
				return;
			}
			if(!val.SetType(type))
			{
				error.AddError("Undefined type '"+type+"' given",line);
				return;
			}
			if(ParseCode(Correct(tmp[1]),line,val.GetType())==T_Unknown)
				return;
			Define(val,line);
		}else{
			unsigned int pos=defines[i].find("(");
			if(pos!=string::npos){
				vector<string> params=Split(defines[i].substr(pos+1),',');
				Function func;
				if(!func.SetType(type))
				{
					error.AddError("Undefined type '"+type+"' given",line);
					return;
				}
				if(!func.SetName(defines[i].substr(0,pos)))
				{
					error.AddError("Cannot define '"+defines[i].substr(0,pos)+"'",line);
					return;
				}
				for(unsigned int k=0;k<params.size();k++)
				{
					if(!func.AddParameter(params[k]))
					{
						error.AddError("Cannot pass '"+params[k]+"' as a parameter",line);
						return;
					}
				}
				Define(func,line);
			}else{
				Value val;
				if(!val.SetName(defines[i]))
				{
					error.AddError("Cannot define '"+defines[i]+"'",line);
					return;
				}
				if(!val.SetType(type))
				{
					error.AddError("Undefined type '"+type+"' given",line);
					return;
				}
				Define(val,line);
			}
		}
	}
}
void Block::Compile(std::string str)
{
	str=Remove(str,"/*","*/");
	str=Remove(str,"//","\n");
	vector<string> lines=Split(str,'\n',true);
	if(CorrectWhiteSpace(str).length()>1)
	{
		string tmp;
		for(unsigned int i=0;i<lines.size();i++)
		{
			tmp=lines[i];
			if(tmp=="")
				continue;
			tmp=CorrectWhiteSpace(tmp);
			tmp=CorrectWhiteSpace(tmp,"<");
			tmp=CorrectWhiteSpace(tmp,">");
			if(tmp=="#include<iostream>")
			{
				if(Parent!=NULL)
				{
					error.AddError("'#include' must be on global scope",i+StartLine);
					return;
				}
				HasIOStream=true;
				continue;
			}
			unsigned int temp=endOfCode(tmp),line=i;
			while(temp==string::npos)
			{
				i++;
				if(i>=lines.size())
				{
					error.AddError("Missing ';'",i+StartLine);
					return;
				}
				tmp=tmp+"\n"+lines[i];
				temp=endOfCode(tmp);
			}
			if(tmp[temp]=='}')
			{
				for(unsigned int k=line;k<i;k++)
				{
					if(lines[k].find("{")!=string::npos)
						break;
					line++;
				}
				line+=StartLine;
				Block block(this,"",line);
				if(temp<tmp.length()-1)
				{
					lines[i]=tmp.substr(temp+1);
					i--;
				}
				tmp=tmp.substr(0,temp+1);
				unsigned int pos=tmp.find("{");
				if(pos==string::npos)
				{
					error.AddError("Unhandeled error!!",line);
					return;
				}
				block.Header(CorrectWhiteSpace(tmp.substr(0,pos)));
				tmp.erase(tmp.length()-1);
				block.Compile(tmp.substr(pos+1));
			}else{
				if(temp<tmp.length()-1)
				{
					lines[i]=tmp.substr(temp+1);
					i--;
				}
				Parse(CorrectWhiteSpace( tmp.substr(0,temp) ),line+StartLine,T_Unknown);
			}
		}
	}
	if( !Returned && GetType()!=T_Void && GetType()!=T_Unknown )
	{
		error.AddError("'"+GetName()+"' : must return a value",lines.size()+StartLine-1);
	}
}

Types Block::Parse(string code,unsigned int line,Types ret)
{
	int tmp=checkParanteses(code);
	if(tmp!=0)
	{
		error.AddError("'"+(tmp==1?string(")"):string("("))+"' : Syntax error",line);
		return T_Unknown;
	}
	string t=Correct(code);
	if(t.find(" ")==string::npos){
		if(t=="")
			return T_Unknown;
		return ParseCode(t,line,ret);
	}else{
		vector<string> arr=Split(code,' ');
		if(arr.size()==2)
		{
			Define(CorrectWhiteSpace(arr[0]),CorrectWhiteSpace(arr[1]),line);
			Value val;
			val.SetType(CorrectWhiteSpace(arr[0]));
			return val.GetType();
		}else if(arr.size()>2)
		{
			if(arr.size()==3 && arr[0]=="using" && arr[1]=="namespace" && arr[2]=="std")
			{
				HasNameSpace=true;
				return T_Unknown;
			}else if(arr[0]=="cin" || arr[0]=="cout"){
				CinCout(code,line);
				return T_Unknown;
			}
		}
		error.AddError("' ' : Syntax error",line);
		return T_Unknown;
	}
}
void Block::Header(string code)
{
	vector<string> arr=Split(code,' ');
	if(arr.size()==2)
	{
		string tmp;
		tmp=arr[1].substr(0,arr[1].find("("));
		if(!SetName(tmp))
		{
			error.AddError("Cannot define '"+tmp+"'",StartLine);
			return;
		}
		if(!SetType(arr[0]))
		{
			error.AddError("Undefined type '"+arr[0]+"' given",StartLine);
			return;
		}
		if(GetName()=="main"&&GetType()!=T_Int)
		{
			error.AddError("'main' function must be 'int'",StartLine);
			return;
		}
		if(!isFunction(tmp))
		{
			Parent->Define(arr[0],arr[1],StartLine);
		}
		tmp=arr[1].substr(arr[1].find("(")+1);
		vector<string> pars=Split(tmp,',');
		for(unsigned int i=0;i<pars.size();i++)
		{
			vector<string> parts=Split(pars[i],' ');
			if(parts.size()!=2)
			{
				error.AddError("'"+pars[i]+"' : Syntax error",StartLine);
				return;
			}
			Define(parts[0],parts[1],StartLine);
		}
	}else if(arr.size()==1){
		unsigned int pos=code.find("(");
		if(pos==string::npos){
			if(code=="else"||code==""){
				Name=code;
			}else{
				error.AddError("'"+code+"' : Syntax error",StartLine);
				return;
			}
		}else{
			string tmp=code.substr(0,pos);
			if(tmp=="if"||tmp=="while"){
				Parse(code.substr(pos+1,code.length()-pos-2),StartLine,T_Bool);
			}else if(tmp=="for"){
				string inputs=code.substr(pos+1,code.length()-pos-2);
				vector<string> commands=Split(inputs,';');
				if(commands.size()!=3)
				{
					error.AddError("missing ';' before ')'",StartLine);
				}
				Parse(commands[0],StartLine,T_Unknown);
				Parse(commands[1],StartLine,T_Bool);
				Parse(commands[2],StartLine,T_Unknown);
			}else{
				error.AddError("'"+code+"' : Syntax error",StartLine);
				return;
			}
			Name=tmp;
		}
	}else{
		error.AddError("'"+code+"' : Syntax error",StartLine);
		return;
	}
}
Types Block::GetType(string code)
{
	if(isName(code))
		return GetValue(code).GetType();
	else if(isInt(code))
		return T_Int;
	else if(isFloat(code))
		return T_Float;
	else if(isBool(code))
		return T_Bool;
	else if(isChar(code))
		return T_Char;
	return T_Unknown;
}
void Block::Return(unsigned int line)
{
	if(Parent==NULL)
	{
		error.AddError("Global Scope cannot return values",line);
		return;
	}
	if(GetType()==T_Void)
	{
		error.AddError("'void' function returning a value",line);
		return;
	}
	if(GetType()==T_Unknown)
	{
		Parent->Return(line);
		return;
	}
	Returned=true;
}
void Block::CinCout(string code,unsigned int line)
{
	vector<string> Parts=Split(code,' ');
	if(Parts.size()<2)
		return;
	if(Parts[0]=="cin"){
		if(!HasIOStream || !HasNameSpace)
		{
			error.AddError("'cin' : undefined identifier",line);
			return;
		}
		for(unsigned int i=1;i<Parts.size();i++)
		{
			Parts[i]=CorrectWhiteSpace(Parts[i],">>");
			if(Parts[i]=="")
				continue;
			if(Parts[i].substr(0,2)==">>")
				Parts[i]=Parts[i].substr(2);
			if(Parts[i]=="")
				continue;
			if(!isName(Parts[i]))
			{
				error.AddError("'"+Parts[i]+"' : Syntax error",line);
				return;
			}
			if(!isValue(Parts[i]))
			{
				error.AddError("'"+Parts[i]+"' : Undefined variabale",line);
				return;
			}
		}
	}else if(Parts[0]=="cout"){
		if(!HasIOStream || !HasNameSpace)
		{
			error.AddError("'cin' : undefined identifier",line);
			return;
		}
		for(unsigned int i=1;i<Parts.size();i++)
		{
			Parts[i]=CorrectWhiteSpace(Parts[i],"<<");
			if(Parts[i]=="")
				continue;
			if(Parts[i].substr(0,2)=="<<")
				Parts[i]=Parts[i].substr(2);
			if(Parts[i]=="")
				continue;
			Parse(Parts[i],line,T_Unknown);
		}
	}else{
		error.AddError("Unespexted '"+Parts[0]+"'",line);
	}
}
Block initGlobal()
{
	Block global;
	Function func;
	Value value;
	func.AddParameter(value);
	func.SetType(T_Same);
	global.Define(func,0);
	func.SetName("___EQQ");
	func.AddParameter(value);
	global.Define(func,0);
	func.SetName("___SET1");
	global.Define(func,0);
	func.SetName("___SET2");
	global.Define(func,0);
	func.SetType(T_Bool);
	func.SetName("___SET3");
	global.Define(func,0);
	return global;
}


bool TypesMatch(Types type1,Types type2)
{
	if(type1==T_Unknown||type1==T_Same||type2==T_Unknown||type2==T_Same)
		return true;
	switch (type1)
	{
	case T_Bool:
		if(type2==T_Bool||type2==T_Int)
			return true;
		break;
	case T_Char:
		if(type2==T_Char)
			return true;
		break;
	case T_Double:
		if(type2==T_Double||type2==T_Float||type2==T_Int)
			return true;
		break;
	case T_Float:
		if(type2==T_Float||type2==T_Double||type2==T_Int)
			return true;
		break;
	case T_Int:
		if(type2==T_Int||type2==T_Float||type2==T_Double)
			return true;
		break;
	case T_Void:
		if(type2==T_Void)
			return true;
		break;
	}
	return false;
}
string TypeName(Types type)
{
	switch(type)
	{
	case T_Bool:return"bool";
	case T_Char:return"char";
	case T_Double:return"double";
	case T_Float:return"float";
	case T_Int:return"int";
	case T_Void:return"void";
	default:return"";
	}
}


