package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;

public class CdkWorkshopStack extends Stack {
    public CdkWorkshopStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public CdkWorkshopStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        final Function hello = Function.Builder.create(this, "HelloHandler")
            .runtime(Runtime.NODEJS_10_X)
            // The handler code is loaded from the lambda directory which we created earlier. Path is relative to where you execute cdk from, which is the project’s root directory
            .code(Code.fromAsset("lambda"))
            // The name of the handler function is hello.handler (“hello” is the name of the file and “handler” is the exported function name)
            .handler("hello.handler")
            .build();

        LambdaRestApi.Builder.create(this, "Endpoint")
            .handler(hello)
            .build();
        
    }
}
