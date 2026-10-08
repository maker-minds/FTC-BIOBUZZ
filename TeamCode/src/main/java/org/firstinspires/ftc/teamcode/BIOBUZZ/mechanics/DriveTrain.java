package org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics;

import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class DriveTrain {

    //---Objects---\\
    public DcMotorEx leftFront = null;
    public DcMotorEx rightFront = null;
    public DcMotorEx leftBack = null;
    public DcMotorEx rightBack = null;

    public void init(HardwareMap hardwareMap) {
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        leftBack = hardwareMap.get(DcMotorEx.class, "leftBack");
        rightBack = hardwareMap.get(DcMotorEx.class, "rightBack");
        leftFront.setDirection(Direction.FORWARD);
        leftBack.setDirection(Direction.FORWARD);
        rightFront.setDirection(Direction.REVERSE);
        rightBack.setDirection(Direction.REVERSE);
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

    public void setPower(double leftfront, double rightfront, double leftback, double rightback) {
        leftFront.setPower(Range.clip(leftfront, -1, 1));
        rightFront.setPower(Range.clip(rightfront, -1 , 1));
        leftBack.setPower(Range.clip(leftback, -1, 1));
        rightBack.setPower(Range.clip(rightback, -1, 1));
    }
}