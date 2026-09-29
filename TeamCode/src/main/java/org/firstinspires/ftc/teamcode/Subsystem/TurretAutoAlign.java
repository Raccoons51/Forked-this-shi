package org.firstinspires.ftc.teamcode.Subsystem;


import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.LLStatus;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.hardware.limelightvision.LLFieldMap;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.openftc.apriltag.AprilTagDetection;

public class TurretAutoAlign extends OpMode {
    private AprilTagLimelightTest aprilTagLimelightTest = new AprilTagLimelightTest();
    private TurretMechanism turret = new TurretMechanism();

    double[] stepSizes = {0.1, 0.01, 0.001, 0.0001, 0.00001};

    int stetIndex =2;


    @Override
    public void init(){
        aprilTagLimelightTest.init(hardwareMap, telemetry);// can cause problmes
        turret.init(hardwareMap);

        telemetry.addLine("initialized all mechanisms");

    }

    @Override
    public void start(){
        turret.resetTimer();

    }

    @Override
    public void loop(){
        aprilTagLimelightTest.update() ;//can cause problems
        AprilTagDetection id36 = aprilTagLimelightTest.getTagBySpecificId(36);

        turret.update(id36);

        if (gamepad1.bWasPressed()) {
            stetIndex = (stetIndex + 1) % stepSizes.length;
        }

        if (gamepad1.dpadLeftWasPressed()) {
            turret.setkP(turret.getkP() - stepSizes[stetIndex]);

        }

        if (gamepad1.dpadRightWasPressed()) {
            turret.setkP(turret.getkP() + stepSizes[stetIndex]);
        }

        if (gamepad1.dpadUpWasPressed()){
            turret.setkD(turret.getkD() + stepSizes[stetIndex]);
        }
        if (gamepad1.dpadDownWasPressed()) {
            turret.setkD(turret.getkD() - stepSizes[stetIndex]);
        }

        if (id36 != null) {
            telemetry.addData(" cur ID" , aprilTagLimelightTest);
        } else {
            telemetry.addLine(" No Tag Detected Stopping Turret Motor");
        }
        telemetry.addLine("----------------------");
        telemetry.addData("Tuning P", "%.5f (D-Pad L/R)", turret.getkP());
        telemetry.addData("Tuning D", "%.5f (D-Pad U/D)", turret.getkD());
        telemetry.addData("Step Size", "%.5f (B Button)", stepSizes[stetIndex]);
    }
}
