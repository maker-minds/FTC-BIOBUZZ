package org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public class Outtake {

    //---Objects---\\
    private DcMotorEx flywheelSmall = null;
    private DcMotorEx flywheelBig = null;
    private Servo turretSmall = null, turretBig = null;
    private Servo rampSmall = null, rampBig = null;

    //---Formulas---\\
    /* x(t) = v_0,x * t + x_0  =  v_0 * cos(alpha) * t + x_0
     * y(t) = -1/2 * g * t^2 + v_0,y * t + y_0  =  -1/2 * g * t^2 + v_0 * sin(alpha) * t + y_0
     */


    //---Functions---\\
    public void init(HardwareMap hardwareMap) {
        flywheelSmall = hardwareMap.get(DcMotorEx.class, "flywheelSmall");
        flywheelBig = hardwareMap.get(DcMotorEx.class, "flywheelBig");
        turretSmall = hardwareMap.get(Servo.class, "turretSmall");
        turretBig = hardwareMap.get(Servo.class, "turretBig");
        rampSmall = hardwareMap.get(Servo.class, "rampSmall");
        rampBig = hardwareMap.get(Servo.class, "rampBig");
        flywheelBig.setDirection(DcMotorSimple.Direction.FORWARD);
        flywheelSmall.setDirection(DcMotorSimple.Direction.FORWARD);
        flywheelSmall.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheelBig.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void aim(Pose3D targetPos) {
        double x0small = -0.2, y0small = 0;
        double x0big = -0.3, y0big = 0;
        double v0small = 0, v0big = 0;
        double yaw = targetPos.getOrientation().getYaw();
        double pitch = targetPos.getOrientation().getPitch();
    }
}
