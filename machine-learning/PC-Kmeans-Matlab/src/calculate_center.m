function [ center ] = calculate_center( Neighborhoods,i,length,Data )

colomns=size(Data,2);
center=zeros(1,colomns-2);
for j=1:length(1,i)
    center=Data(Neighborhoods(i,j),2:colomns-1)+center;
end

center=center/length(1,i);






end

