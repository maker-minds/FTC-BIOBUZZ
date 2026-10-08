package org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {

    //---Objects---\\
    DcMotorEx flywheel = null;
    Servo turret = null;
    Servo ramp = null;

    public void init(HardwareMap hardwareMap) {
        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        turret = hardwareMap.get(Servo.class, "turret");
        ramp = hardwareMap.get(Servo.class, "ramp");
    }
}
