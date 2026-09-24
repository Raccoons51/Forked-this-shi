package org.firstinspires.ftc.teamcode.Subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class TurretAutoAlign extends OpMode {
    private AprilTagLimelightTest aprilTagLimelightTest = new AprilTagLimelightTest();
    private TurretMechanism turret = new TurretMechanism();


    @Override
    public void init(){
        aprilTagLimelightTest.init(hardwareMap, telemetry);
        turret.init(hardwareMap);

        telemetry.addLine("initialized all mechanisms");

    }

    @Override
    public void start(){

    }

    @Override
    public void loop(){

    }l
}
