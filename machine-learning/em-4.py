#Roya Feizi

import numpy
from numpy import linalg
from numpy import *
import math
import matplotlib.pyplot as plt  # NOT ISNTALLED 
#import matplotlib.pyplot as plt  # NOT ISNTALLED 

input=open("points.dat",'r')
N=1000 #size of data
d=2 #dimention
K=4 #clusters
X=numpy.zeros([N,d])
lineno=0
##########################################33333
#initialization
Mean0=numpy.array([[0.0,0.0]])
mean1=numpy.array([[3.0,0.0]])
mean2=numpy.array([[2.0,0.0]])
mean3=numpy.array([[2.0,1.0]])
cov0=numpy.array([[1.0,0.0],[0.0,1.0]]) 
cov1=numpy.array([[2.0,0.0],[1.0,2.0]])
cov2=numpy.array([[3.0,1.0],[0.0,1.0]])
cov3=numpy.array([[2.0,0.0],[3.0,4.0]])
coef= numpy.array([0.3,0.3,0.3,0.1]) # coeficients
Mean=numpy.array([Mean0,mean1,mean2,mean3])
#print "Mean[0]",Mean[0]
Cov=numpy.array([cov0,cov1,cov2,cov3])
#print "first cov",Cov

###############################################
posteriors=numpy.zeros([N,K])
def calc_posteriors(Mean,Cov,coef,K):
	#Means=numpy.array([Mean0,mean1,mean2,mean3])
	#Cov=numpy.array([cov0,cov1,cov2,cov3])
	temp=0
	
	for i in range(0,N):
		temp=marginal(i)
		for j in range(0,K):
			
			posteriors[i,j]=coef[j]*normpdf(X[i,:],Mean[j],Cov[j])/temp*1.0
			
		#tempme=0;
		#for j in range(0,K):
		#	tempme=tempme+posteriors[i,j]
		
		#if tempme!=1:
		#	print "KHARAAAAAAAAAAAAAAAAB: ", tempme 
	
#print "posteriors",posteriors
################################################
def marginal(i):
	temp=0
	for j in range(0,K):
			temp=temp+coef[j]*normpdf(X[i,:],Mean[j],Cov[j])
	return temp

def calc_N_k ():
	N_k=numpy.zeros([1,K])
	for j in xrange(0,K):
		for i in xrange(0,N):
			N_k[0,j]=N_k[0,j]+posteriors[i,j]
	return N_k

###############################################
def normpdf(X,mean,cov):
	#b = numpy.array([x1,x2])
	
	#k = b.shape[0]
	#part1 = numpy.exp(-0.5*2*numpy.log(2*numpy.pi))
	part1=1.0/2*pi
	#if abs(numpy.linalg.det(cov))==0:
		#print cov
		#print "det cov:",abs(numpy.linalg.det(cov))
	part2 = numpy.power(numpy.abs(numpy.linalg.det(cov)),-0.5)
	dev = X-mean
	#print "this is dev",dev
	#print "dev",dev
	#print "inverse of cov",numpy.linalg.inv(cov)
	#print dot(dev,numpy.linalg.inv(cov))
	part3 = numpy.exp(-0.5*dot(dot(dev,numpy.linalg.pinv(cov)),dev.T))
	dmvnorm = part1*part2*part3
	#print part2,"part3",part3,"   ","dmvnorm",dmvnorm
	return dmvnorm
#print "normpdf",normpdf(X[0,:],Mean0,cov0)
################################################
# filing the matrices X and Y
for line in input.readlines():
	line=line[0:len(line)-1]
	fields=line.split()
	
	
	
	for i in  (0,1):
		X[lineno][i]=float(fields[i])
		
	lineno=lineno+1
#print X
#print X[5]
##################################################	
#plot points to estimate the number of clusters
def plot():
	plt.plot(X[:,0],X[:,1],'+')
	plt.ylabel('x1')
	plt.xlabel('x2')
	plt.show()
##################################################
def calc_log_likelihood(Mean,Cov,coef):
	log_likelihood=0
	
	for i in xrange(0,N):
		log_likelihood=log_likelihood+numpy.log((coef[0]*normpdf(X[i,:],Mean[0],Cov[0]))+(coef[1]*normpdf(X[i,:],Mean[1],Cov[1]))+(coef[2]*normpdf(X[i,:],Mean[2],Cov[2]))+(coef[3]*normpdf(X[i,:],Mean[3],Cov[3])))
		
	return log_likelihood
	
##################################################

#print calc_log_likelihood(Mean,Cov,coef)
#calc_posteriors(Mean,Cov,coef,K)
#print calc_N_k()
###################################################
newlog_likelihood=-1
log_likelihood=-2
Mean_temp=numpy.array([0,0])
cov_temp=numpy.array([[0,0],[0,0]])
iteration=0
itlist=[]
loglikelist=[]
while newlog_likelihood-log_likelihood>=0.1:
	#print "in while :"
	iteration=iteration+1
	itlist.append(iteration)
	log_likelihood=calc_log_likelihood(Mean,Cov,coef)
	loglikelist.append(log_likelihood[0,0])
	print "log_likelihood",log_likelihood
	calc_posteriors(Mean,Cov,coef,K)
	#print "posteriors in while",posteriors
	N_k=calc_N_k()
	
	for j in range(0,K):
		Mean_temp=numpy.array([0,0])
		for i in range (0,N):
			Mean_temp=(Mean_temp)+(posteriors[i,j]*X[i,:])
		#print "mean_temp",Mean_temp
		#print "Mean0",Mean0
		
		Mean[j]=(1.0/N_k[0,j])*(Mean_temp)
		#print "Mean[j]",Mean[j]
		#print "in adad: ",(1.0/N_k[0,j])*(Mean_temp)
	#print Mean_temp0.shape[1]
	#print Mean0.shape[1]
	#print "Mean",Mean
		
		
	for j in range(0,K):
		cov_temp=numpy.array([[0,0],[0,0]])
		for i in range(0,N):
			cov_temp=cov_temp+(posteriors[i,j]*dot((X[i,:]-Mean[j]).T,X[i,:]-Mean[j]))
		Cov[j]=(1.0/N_k[0,j])*(cov_temp)
	
	#print "Cov",Cov
	for m in range (0,K):
		coef[m]=(N_k[0,m]*1.0 )/N
	#print coef
		
	newlog_likelihood=calc_log_likelihood(Mean,Cov,coef)
	print "newlog_likelihood",newlog_likelihood
	
print iteration	
plt.plot(itlist,loglikelist)
plt.ylabel('loglikelihood')
plt.xlabel('iteration')
plt.show()
	
	
	










