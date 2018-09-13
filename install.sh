#! /bin/bash
npm install --savedev github-uploader
git clone https://github.com/2013008264/github-uploader-binary
mv node_modules github-uploader-binary/
mvn clean package -Dmaven.test.skip=true

