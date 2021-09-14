import * as cdk from '@aws-cdk/core';
import { SPADeploy } from 'cdk-spa-deploy';

export class CdkStack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    // The code that defines your stack goes here
    new SPADeploy(this, 'websiteDeploy')
      .createSiteWithCloudfront({
        indexDoc: 'index.html',
        websiteFolder: '../vue-helloworld'
      });
  }
}
