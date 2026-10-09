package org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {

    //---Objects---\\
    private DcMotorEx flywheel = null;
    private Servo turret = null;
    private Servo ramp = null;

    //---Functions---\\
    public void init(HardwareMap hardwareMap) {
        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        turret = hardwareMap.get(Servo.class, "turret");
        ramp = hardwareMap.get(Servo.class, "ramp");
    }

    public void shoot() {
            
    }
}
