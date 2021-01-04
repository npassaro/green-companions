import { expect as expectCDK, matchTemplate, MatchStyle } from '@aws-cdk/assert';
import * as cdk from '@aws-cdk/core';
import * as Cdk from '../lib/eks-cluster-stack';

test('Empty Stack', () => {
    const app = new cdk.App();
    // WHEN
    const stack = new Cdk.EKSClusterStack(app, 'MyTestStack', { vpcName: 'testVpc' });
    // THEN
    expectCDK(stack).to(matchTemplate({
      "Resources": {}
    }, MatchStyle.EXACT))
});
