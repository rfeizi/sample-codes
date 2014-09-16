function [ ML ] = MustLinks( Neighborhoods,length,k )

size_ml=0;
j=1;
display(k);
while j<=k
size_ml=(length(1,j)* (length(1,j)-1)/2)+size_ml;
j=j+1;
end

ML=zeros(size_ml,2);


mlc=0;
for h=1:k
    for i=1:length(1,h)
        for j=i+1:length(1,h)
            mlc=mlc+1;
            ML(mlc,1)=Neighborhoods(h,i);
            ML(mlc,2)=Neighborhoods(h,j);
        end
    end
    


end
end
