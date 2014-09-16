function [w_ml ] = constraint_ml(mustlinks,index,clusters,h,Data)

w_ml=0;
for i=1:size(Data,1)
    if(mustlinks(i,Data(index,1))==1 && h~=clusters(i,2) )
        w_ml=w_ml+1;
    end
end



end

