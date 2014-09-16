function [accs]= expl_test(cln,maxq,step)
    accs=zeros(maxq/step,2);
    for i=0:maxq/step
        
        accs(i+1,:)=[i*step,expl(cln,i*step)];
    end
    
    figure(2);
    plot(accs(:,1),accs(:,2));
    drawnow
end