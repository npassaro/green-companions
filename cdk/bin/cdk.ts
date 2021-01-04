#!/usr/bin/env node
import 'source-map-support/register';
import * as cdk from '@aws-cdk/core';
import * as ec2 from '@aws-cdk/aws-ec2';
import * as rds from '@aws-cdk/aws-rds';
import * as sm from '@aws-cdk/aws-secretsmanager';
import { EKSRdsStack } from '../lib/eks-rds-stack';
import { EKSClusterStack } from '../lib/eks-cluster-stack';

const AWS_ACCOUNT = '599829142323';
const AWS_REGION = 'eu-west-1';
const DATABASE_USERNAME = 'greencompanion';
const VPC_NAME = 'EKSVpc';

const env = { account: AWS_ACCOUNT, region: AWS_REGION }

/* Workaround start */
import { Patch } from 'awscdk-81-patch';
Patch.apply();
/* Workaround end */

const app = new cdk.App()
const eksClusterStack = new EKSClusterStack(app, 'EKSClusterStack', { env, vpcName: VPC_NAME });

const vpc = ec2.Vpc.fromLookup(eksClusterStack, 'RdsVpc', { vpcName: `EKSClusterStack/${VPC_NAME}` }) as ec2.Vpc;
const rdsProps = { vpc, databaseUsername: DATABASE_USERNAME }
const rdsStack = new EKSRdsStack(app, 'RDSStack', rdsProps)

// Create the secret with the master username/password and database endpoint
// Pass the AWS secret to kubernetes (see https://aws.amazon.com/blogs/containers/aws-secrets-controller-poc/)




