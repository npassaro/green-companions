import * as autoscaling from '@aws-cdk/aws-autoscaling';
import * as iam from '@aws-cdk/aws-iam';
import * as ec2 from '@aws-cdk/aws-ec2';
import * as eks from '@aws-cdk/aws-eks';
import * as cdk from '@aws-cdk/core';

export interface EKSClusterStackProps extends cdk.StackProps {
    vpcName: string;
}

export class EKSClusterStack extends cdk.Stack {
    public readonly vpc: ec2.Vpc;

    constructor(scope: cdk.App, id: string, props: EKSClusterStackProps) {
        super(scope, id, props);

        this.vpc = new ec2.Vpc(this, props.vpcName);

        const workerRole = new iam.Role(this, 'EKSWorkerRole', {
            assumedBy: new iam.ServicePrincipal('ec2.amazonaws.com'),
        });

        const eksCluster = new eks.Cluster(this, 'Cluster', {
            vpc: this.vpc,
            defaultCapacity: 0, // we want to manage capacity our selves
            version: eks.KubernetesVersion.V1_17,
        });

        const onDemandASG = new autoscaling.AutoScalingGroup(
            this,
            'OnDemandASG',
            {
                vpc: this.vpc,
                role: workerRole,
                minCapacity: 1,
                maxCapacity: 10,
                instanceType: new ec2.InstanceType('t3.micro'),
                machineImage: new eks.EksOptimizedImage({
                    kubernetesVersion: '1.17',
                    nodeType: eks.NodeType.STANDARD, // without this, incorrect SSM parameter for AMI is resolved
                }),
                updatePolicy: autoscaling.UpdatePolicy.rollingUpdate(),
            }
        );

        eksCluster.connectAutoScalingGroupCapacity(onDemandASG, {});
    }
}
