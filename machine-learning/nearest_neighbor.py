import numpy
from numpy import linalg
from numpy import *
input=open("voting2.dat",'r')
testCount=0
k=6
mistakes=0

feature_encoding={'y':1, '?':0 , 'n':-1, 'democrat':1, 'republican':0}
X=numpy.zeros([435,15])
Y=numpy.zeros([435,1])
lineno=0;



# filing the matrices X and Y
for line in input.readlines():
	line=line[0:len(line)-1]
	fields=line.split(',')
	Y[lineno][0]=feature_encoding[fields[0]]
	for i in range (0,15):
		X[lineno][i]=feature_encoding[fields[i+1]]
	lineno=lineno+1




# dividing the data into test and train data	
Xtrain=X[0:392,:]
Xtest=X[392:436,:]


# each iteration finds the k-nearest neighbor for one of the test data. I have 42 test data
for j in range (0,42):

	democ=repub=0
	Temp=numpy.array([Xtest[j]])
	for i in range (1,392):
		Temp = numpy.vstack([Temp, Xtest[j]])


	A=Temp-Xtrain

	A=A**2

	distances=numpy.array([A[0].sum()])
	for i in range (1,392):
		distances = numpy.vstack([distances, A[i].sum()])

	K_minimum=argsort(distances.T)
		
	
	for i in range(0,k):
		if Y[K_minimum.T[i]]==1:
			democ=democ+1
		else:
			repub=repub+1
	#deciding which class to assign to Xtest[j]
	if democ>=repub:
		assignment=1
	else:
		assignment=0

	#for accuracy:
	
	if assignment==Y[392+j-1]:
		testCount=testCount+1
	else:
		mistakes=mistakes+1
		testCount=testCount+1

print "size of test data: ",testCount
accuracy=(testCount-mistakes)/(testCount*1.0)
print "accracy= ",accuracy









	
	



