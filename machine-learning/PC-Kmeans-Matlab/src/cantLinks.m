function [ CL ] = cantLinks( Neighborhoods,length,k )
clc=0;

for h=1:k
    for t=h+1:k
    for i=1:length(1,h)
        for j=1:length(1,t)
            clc=clc+1;
            CL(clc,1)=Neighborhoods(h,i);
            CL(clc,2)=Neighborhoods(t,j);
        end
    end
    end
end
    


end



