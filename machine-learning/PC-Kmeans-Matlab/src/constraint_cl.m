function [ w_cl ] = constraint_cl(cantlinks,index,clusters,h,Data)
%UNTITLED6 Summary of this function goes here
%   Detailed explanation goes here

w_cl=0;
for i=1:size(Data,1)
    if(cantlinks(i,Data(index,1))==1 && h==clusters(i,2))
        w_cl=w_cl+1;
    end
end



end

