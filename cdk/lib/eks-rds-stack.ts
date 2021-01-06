import { App, Duration, Stack, StackProps } from '@aws-cdk/core';
import * as rds from '@aws-cdk/aws-rds';
import * as sm from '@aws-cdk/aws-secretsmanager';
import * as ec2 from '@aws-cdk/aws-ec2';

export interface EKSRdsStackProps extends StackProps {
    vpc: ec2.Vpc;
    databaseUsername: string;
}

export class EKSRdsStack extends Stack {
    readonly secret: sm.ISecret;
    readonly postgresInstance: rds.DatabaseInstance;
    readonly databaseInstanceProps: rds.DatabaseInstanceProps;

    constructor(scope: App, id: string, props: EKSRdsStackProps) {
        super(scope, id, props);

        const rdsDatabaseUrlSecret = new rds.DatabaseSecret(
            this,
            `${id}Secret`,
            {
                username: props.databaseUsername,
            }
        );

        const credentials: rds.Credentials = rds.Credentials.fromSecret(
            rdsDatabaseUrlSecret
        );

        this.databaseInstanceProps = {
            engine: rds.DatabaseInstanceEngine.postgres({
                version: rds.PostgresEngineVersion.VER_12,
            }),
            instanceType: ec2.InstanceType.of(
                ec2.InstanceClass.T2,
                ec2.InstanceSize.MICRO
            ),
            vpc: props.vpc,
            vpcPlacement: { subnetType: ec2.SubnetType.PRIVATE },
            storageEncrypted: false,
            multiAz: false,
            autoMinorVersionUpgrade: true,
            allocatedStorage: 25,
            storageType: rds.StorageType.GP2,
            backupRetention: Duration.days(3),
            deletionProtection: false,
            credentials: credentials,
        };

        this.postgresInstance = new rds.DatabaseInstance(
            this,
            'postgresql-rds-instance',
            this.databaseInstanceProps
        );
    }
}
