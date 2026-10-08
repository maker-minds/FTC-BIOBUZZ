package org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class Limelight {

    //---Objects---\\
    private Limelight3A limelight;
    private LLResult llresult;
    private IMU imu = null;
    private Telemetry telemetry;
    RevHubOrientationOnRobot revHubOrientationOnRobot;

    //---Functions---\\
    public void init(HardwareMap hardwareMap) {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        imu = hardwareMap.get(IMU.class, "imu");
        limelight.pipelineSwitch(0);
        revHubOrientationOnRobot = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.RIGHT);
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));
        limelight.start();
    }

    public double[] getResult() {
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        limelight.updateRobotOrientation(orientation.getYaw());
        llresult = limelight.getLatestResult();
        Pose3D botPose = limelight.getLatestResult().getBotpose_MT2();
        double[] results = new double[3];
        if(llresult != null && llresult.isValid()) {
            results[0] = llresult.getTx();
            results[1] = llresult.getTy();
            results[2] = llresult.getTa();
        }
        return results;
    }
}
