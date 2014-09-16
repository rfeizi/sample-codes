function [a] = read_data_yeast
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
[x1,x2,x3,x4,x5,x6,x7,x8,x9,x10]=textread('yeast.data','%s %f %f %f %f %f %f %f %f %s');
    a=[x2,x3,x4,x5,x6,x7,x8,x9];
    
   


    
    n=size(a,1);
    ids=zeros(n,1);


    for i=1:n
            ids(i,1)=i;

    end
    
    a=[ids,a];
    
    b=zeros(n,1);
    
    for i=1:n
         if(strcmp(x10(i),'CYT'))
             b(i,1)=1;
         elseif(strcmp(x10(i,1),'NUC'))
             b(i,1)=2;
         elseif(strcmp(x10(i,1),'MIT'))
             b(i,1)=3;
         elseif(strcmp(x10(i,1),'ME3'))
             b(i,1)=4;
         elseif(strcmp(x10(i,1),'ME2'))
             b(i,1)=5;
         elseif(strcmp(x10(i,1),'EXC'))
             b(i,1)=6;
         elseif(strcmp(x10(i,1),'VAC'))
             b(i,1)=7;
         elseif(strcmp(x10(i,1),'POX'))
             b(i,1)=8;
         elseif(strcmp(x10(i,1),'ERL'))
             b(i,1)=9;
         end
    end
    
    a=[a,b];
    


end

