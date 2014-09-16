function [a] = read_data_diabets
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
[x1,x2,x3,x4,x5,x6,x7,x8,x9]=textread('diabets.txt','%f %f %f %f %f %f %f %f %f');
    a=[x1,x2,x3,x4,x5,x6,x7,x8,x9];
    
    
    n=size(a,1);
    ids=zeros(n,1);


    for i=1:n
            ids(i,1)=i;

    end
    
    a=[ids,a];
   
    


end

