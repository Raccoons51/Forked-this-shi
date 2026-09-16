package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Subsystem.Intake;

import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.ftc.components.BulkReadComponent;

@TeleOp(name = "RedTele", group = "Robot")
public class RedTele extends NextFTCOpMode {

    public RedTele() {
    }
    DcMotor Fl;
    DcMotor Fr;
    DcMotor Bl;
    DcMotor Br;
    public void onInit() {
        addComponents(
                new SubsystemComponent(Intake.INSTANCE),
                BulkReadComponent.INSTANCE,
                BindingsComponent.INSTANCE
        );
        Fl = hardwareMap.get(DcMotor.class, "Fl");
        Fr = hardwareMap.get(DcMotor.class, "Fr");
        Bl = hardwareMap.get(DcMotor.class, "Bl");
        Br = hardwareMap.get(DcMotor.class, "Br");
    }
}
