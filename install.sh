#! /bin/bash

if ! [ -x "$(command -v npm)" ]; then
	echo "node must be installed... T_T"
	exit 1
fi

unameOut="$(uname -s)"

case "${unameOut}" in
	Linux*)		machine=Linux;;
	Darwin*)	machine=Mac;;
	CYGWIN*)	machine=Windows;;
	MINGW*)		machine=Windows;;
	*)		machine="Unknown:${unameOut}";;
esac

npm install --savedev github-uploader
git clone https://github.com/2013008264/github-uploader-binary
mv node_modules github-uploader-binary/

#Build with maven

if [ -x "$(command -v mvn)" ]; then
	mvn clean package -Dmaven.test.skip=true
	exit 0
fi

if 	[ "${machine}" == "Linux" ] 
then	
	./mvnw clean package -Dmaven.test.skip=true

elif 	[ "${machine}" == "Mac" ] 
then	
	./mvnw clean package -Dmaven.test.skip=true
elif 	[ "${machine}" == "Windows" ] 
then 	
	./mvnw.cmd clean package -Dmaven.test.skip=true
fi
