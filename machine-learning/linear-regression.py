import numpy
from numpy import linalg
from numpy import *


#opening the file. I've removed the extra lines from voting2.dat
input=open("voting2.dat",'r')


#changing the data to numeric features
feature_encoding={'y':1, '?':0 , 'n':-1, 'democrat':1, 'republican':0}

#defining matrices
X=numpy.zeros([435,15])
Y=numpy.zeros([435,1])
lineno=0;


#filling the matrix X and Y
for line in input.readlines():
	line=line[0:len(line)-1]
	fields=line.split(',')
	Y[lineno][0]=feature_encoding[fields[0]]
	for i in range (0,15):
		X[lineno][i]=feature_encoding[fields[i]]
	lineno=lineno+1

#calculating the linear regression
weights=dot(linalg.inv( dot(X.T,X)),dot(X.T,Y))
Yhat=dot(X,weights)
error=dot((Yhat-Y).T,(Yhat-Y))
print "error of linear regression:  ",error