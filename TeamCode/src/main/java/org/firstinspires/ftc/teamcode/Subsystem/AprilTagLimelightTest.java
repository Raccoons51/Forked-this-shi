package org.firstinspires.ftc.teamcode.Subsystem;


import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.LLStatus;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

import java.util.List;

public class AprilTagLimelightTest extends OpMode {
    private Limelight3A limelight;

    @Override
    public void init() {
        limelight = hardwareMap.get(limelight3A.class, "limelight3A");
        Limelight3A
    }
    @Override
    public void start() {

    }


    @Override
    public void loop() {

    }
}
