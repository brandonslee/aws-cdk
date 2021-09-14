This deploys a vue.js website to an S3 bucket with CloudFront.
This refers to CDK Patterns. 
  * https://cdkpatterns.com/
  * https://cdkpatterns.com/patterns/filter/?by=React

1. Create a project root dir
* $ mkdir s3-cf-vue-website
* $ cd s3-cf-vue-website

2. Initiate vue.js
  * $ vue init webpack-simple vue-helloworld

3. Run vue.js app for test
  * $ cd vue-helloworld
  * $ npm run dev

4. Build vue.js app for distribution
  * $ npm run build

5. Initiate CDK
  * $ cd ..
  * $ mkdir cdk
  * $ cd cdk
  * $ cdk init --language typescript

6. Install npm packages and modify lib/cdk-stack.ts referring to the below codes
  * https://github.com/cdk-patterns/serverless/blob/main/s3-react-website/typescript/cdk/lib/cdk-stack.ts
  * $ npm install @aws-cdk/aws-s3-deployment @aws-cdk/aws-s3 cdk-spa-deploy

7. Add npm run script to package.json of CDK
  * "deploy": "cdk deploy '*' --require-approval 'never'"

8. Create package.json in project root dir referring to the below codes. Modify npm run script not to rebuild vue.js app. Remove node_modules dir of vue.js not to be uploaded in S3 bucket. If they're uploaded, the deployment time exceeds tens of minutes.
  * https://github.com/cdk-patterns/serverless/blob/main/s3-react-website/typescript/package.json
  * $ cd ..
  * $ touch package.json

9. Deploy cdk pattern app in project rot dir.
  * $ npm run deploy

10. Open the CloudFront url from CDK Outputs in browser.


