package org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics;

import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class DriveTrain {

    public DcMotorEx leftFront;
    public DcMotorEx rightFront;
    public DcMotorEx leftBack;
    public DcMotorEx rightBack;

    public DriveTrain(HardwareMap hardwareMap) {
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        leftBack = hardwareMap.get(DcMotorEx.class, "leftBack");
        rightBack = hardwareMap.get(DcMotorEx.class, "rightBack");
    }

    public void setMode(DcMotorEx.RunMode mode) {
        leftFront.setMode(mode);
        rightFront.setMode(mode);
        leftBack.setMode(mode);
        rightBack.setMode(mode);
    }

    public void setVelocity(double angularRate) {
        AngleUnit unit = AngleUnit.DEGREES;
        leftFront.setVelocity(angularRate, unit);
        rightFront.setVelocity(angularRate, unit);
        leftBack.setVelocity(angularRate, unit);
        rightBack.setVelocity(angularRate, unit);
    }

    public void setDirection(Direction direction) {
        leftFront.setDirection(direction);
        rightFront.setDirection(direction);
        leftBack.setDirection(direction);
        rightBack.setDirection(direction);
    }

    public void setZeroPowerBehaviour(ZeroPowerBehavior zeroPowerBehaviour) {
        leftFront.setZeroPowerBehavior(zeroPowerBehaviour);
        rightFront.setZeroPowerBehavior(zeroPowerBehaviour);
        leftBack.setZeroPowerBehavior(zeroPowerBehaviour);
        rightBack.setZeroPowerBehavior(zeroPowerBehaviour);
    }
}
